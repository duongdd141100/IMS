/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dal.UserDAL;
import java.util.List;
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
    
}
