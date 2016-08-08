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
public enum USERS {
    
    /**
     *  returns all the Users
     */
    GetAll("SELECT * FROM users"),
    /**
     * returns the User associated with the specified id 
     */
    GetById("SELECT * FROM users WHERE id = ?"),
    /**
     * returns the User associated with the specified username
     */
    GetByUsername("SELECT * FROM users WHERE username = ?"),
    /**
     * Adds a new user to the db
     */
    Add("CALL ADD_USER(?,?,?, ?)");
    
    
    private final String sql;
    
    private USERS(String sql) {
        this.sql = sql;
    } 
    
    public String sql() {
        return sql;
    }
}
