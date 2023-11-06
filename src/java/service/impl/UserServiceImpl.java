/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dal.UserDAL;
import java.util.List;
import java.util.regex.Pattern;
import modal.User;
import service.UserService;

/**
 *
 * @author User
 */
public class UserServiceImpl implements UserService{
    private final UserDAL userDAL = new UserDAL();
    
    @Override
    public List<User> findAllTeacher() {
       return userDAL.findAllTeacher();
    }
    @Override
    public boolean registerSuccess(String fullname, String birthday, String address, String username, String password, String repassword) {
        boolean check = true;
        List<User> list = new UserDAL().getAll();
        // Kiểm tra tên đăng nhập đã tồn tại hoặc mật khẩu nhập lại không khớp
        for (User user : list) {
            if (user.getUsername().toUpperCase().equals(username.toUpperCase()) 
                || !password.equals(repassword))                      
                check =false;
        }
         // Kiểm tra định dạng email hoặc số điện thoại
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String phoneRegex = "^[0-9]{10}$"; // Định dạng số điện thoại gồm 10 chữ số
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        if (!emailPattern.matcher(username).matches() && !phonePattern.matcher(username).matches()) {
            check = false;
        }

        // Kiểm tra fullname chỉ chứa chữ
        String fullnameRegex = "^[a-zA-Z\\s]+$";
        Pattern fullnamePattern = Pattern.compile(fullnameRegex);
        if (!fullnamePattern.matcher(fullname).matches()) {
            check = false;
        }

        // Kiểm tra địa chỉ chỉ chứa số và chữ
        String addressRegex = "^[a-zA-Z0-9\\s]+$";
        Pattern addressPattern = Pattern.compile(addressRegex);
        if (!addressPattern.matcher(address).matches()) {
            check = false;
        }
        if (check) new UserDAL().insertUser(fullname, birthday, address, username, password);
        return check;
    }

    @Override
    public User userLogin(String username, String password) {
        User user = new User();
        List<User> list = new UserDAL().getAll();
        for (User userD : list) {
            if (userD.getUsername().toUpperCase().equals(username.toUpperCase()) 
                && userD.getPassword().equals(password))
                user = userD;
        }
        return user;
    }
    
    public static void main(String[] args) {
        User user = new UserServiceImpl().userLogin("giang@gmail.com", "1234");
        System.out.println(user.getId()==null);
    }
}
