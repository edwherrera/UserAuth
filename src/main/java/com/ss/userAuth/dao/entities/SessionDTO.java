/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.dao.entities;

import java.sql.Timestamp;

/**
 *
 * @author eherrerra
 */
public class SessionDTO {
    
    private int id;
    private String token;
    private int userId;
    private Timestamp expires;

    public SessionDTO() {
    }

    public SessionDTO(int id, String token, int userId) {
        this.id = id;
        this.token = token;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
