/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modal.User;

/**
 *
 * @author User
 */
public class UserDAL extends BaseDal {

    private final String USER_ID = "user_id";
    private final String USER_FULLNAME = "user_fullname";
    private final String CLASS_NAME = "class_name";
    private final String SUBJECT_ID = "subject_id";
    private final String TEACHER_ID = "teacher_id";
    private final String SEMESTER_ID = "senester_id";
    private final String DESCRIPTION = "description";

    public List<User> findAllTeacher() {
        try {
            String sql = "SELECT u.user_id, u.user_fullname FROM [user] u join setting s on u.rold_id = s.setting_id \n"
                    + "and s.setting_name = 'TEACHER' and s.setting_type = 'Role' and s.status = 1;";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<User> user_list = new ArrayList<>();
            while (resultSet.next()) {
                user_list.add(new User(resultSet.getInt(USER_ID),
                                        resultSet.getString(USER_FULLNAME)
                ));
            }
            return user_list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String querry = "SELECT *FROM [user]";
        try {
            statement = conn.prepareStatement(querry);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setFullName(resultSet.getString(2));
                user.setBirthday(resultSet.getDate(3));
                user.setAddress(resultSet.getString(4));
                user.setUsername(resultSet.getString(5));
                user.setPassword(resultSet.getString(6));
                user.setRoldId(resultSet.getInt(7));
                list.add(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void insertUser(String fullname, String birthday,String address, String username, String password) {
        List<User> list = new ArrayList<>();
        String querry = "INSERT INTO [dbo].[user]([user_fullname],[birthday],[address],[username],[password],[rold_id]) VALUES ('"+fullname+"', '"+birthday+"', '"+address+"', '"+username+"', '"+password+"', 2)";
        try {
            statement = conn.prepareStatement(querry);
            resultSet = statement.executeQuery();           
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
