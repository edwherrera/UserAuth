/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.dao.sql;

/**
 *
 * @author eherrerra
 */
public enum SESSIONS {
    
    /**
     * returns all the sessions
     */
    GetAll("SELECT * FROM sessions"),
    GetByToken("SELECT * FROM sessions WHERE token = ?"),
    Add("INSERT INTO sessions(token, user_id) VALUES(?,?)");
    
    private String sql;
    
    SESSIONS(String sql) {
        this.sql = sql;
    }
    
    public String sql() {
        return sql;
    }
    
}
