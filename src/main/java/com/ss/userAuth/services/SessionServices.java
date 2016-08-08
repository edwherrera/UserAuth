/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.services;

import com.ss.userAuth.connections.UserPicsConnectionFactory;
import com.ss.userAuth.dao.SessionDAO;
import com.ss.userAuth.dao.entities.SessionDTO;
import com.ss.userAuth.models.SessionTokenModel;
import java.util.UUID;

/**
 *
 * @author eherrerra
 */
public class SessionServices {
    
    private final SessionDAO context;
    
    public SessionServices() {
        context = new SessionDAO(UserPicsConnectionFactory.getDbConnection());
    }
    
    public SessionTokenModel addSession(int userId) {
        String token = UUID.randomUUID().toString();
        SessionDTO newSession = new SessionDTO();
        newSession.setToken(token);
        newSession.setUserId(userId);
        
        context.add(newSession);
        
        return new SessionTokenModel(token);
    }
    
}
