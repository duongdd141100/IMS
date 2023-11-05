/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modal.User;

/**
 *
 * @author User
 */
public interface UserService{
    List<User> findAllTeacher();
    boolean registerSuccess(String fullname, String birthday, String address, String username, String password, String repassword);
    User userLogin(String username, String password);
}
