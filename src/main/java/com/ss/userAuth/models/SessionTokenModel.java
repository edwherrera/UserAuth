/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.models;

/**
 *
 * @author eherrerra
 */
public class SessionTokenModel {
    private String token;

    public SessionTokenModel(String token) {
        this.token = token;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
}
