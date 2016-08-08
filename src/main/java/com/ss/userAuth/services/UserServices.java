/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.services;

import com.ss.userAuth.connections.UserPicsConnectionFactory;
import com.ss.userAuth.dao.UserDAO;
import com.ss.userAuth.dao.entities.UserDTO;
import com.ss.userAuth.exceptions.PasswordMismatch;
import com.ss.userAuth.exceptions.UserNotFound;
import com.ss.userAuth.exceptions.UsernameAlreadyInUse;
import com.ss.userAuth.models.LoginModel;
import com.ss.userAuth.models.UserModel;
import com.ss.userAuth.models.UserSignupModel;

/**
 *
 * @author eherrerra
 */
public class UserServices {
    
    private final UserDAO context;

    public UserServices() {
        this.context = new UserDAO(UserPicsConnectionFactory.getDbConnection());
    }
    
    public void login(LoginModel model) throws UserNotFound, PasswordMismatch {
        UserDTO user = context.getByUsername(model.getUsername());
        if(user == null) {
            throw new UserNotFound();
        } 
        
        if(!user.getPassword().equals(model.getPassword())) {
            throw new PasswordMismatch();
        }
    }
    
    public UserModel getUserByUsername(String username) throws UserNotFound {
        UserDTO user = context.getByUsername(username);
      
        if(user == null) {
            throw new UserNotFound();
        }
        
        UserModel model = new UserModel();
        model.setId(user.getId());
        model.setName(user.getName());
        model.setUsername(user.getUsername());
        
        return model;    
    }
    
    public UserModel addUser(UserSignupModel model) throws UsernameAlreadyInUse {
        if(context.getByUsername(model.getUsername()) != null) {
            throw new UsernameAlreadyInUse();
        }
        
        UserDTO newUser = new UserDTO();
        newUser.setName(model.getName());
        newUser.setUsername(model.getUsername());
        newUser.setPassword(model.getPassword());
        
        context.add(newUser);
        
        UserModel newUserModel = new UserModel();
        newUserModel.setId(newUser.getId());
        newUserModel.setName(newUser.getName());
        newUserModel.setUsername(newUser.getUsername());
                
        return newUserModel;
    }
}
