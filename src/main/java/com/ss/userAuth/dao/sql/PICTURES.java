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
public enum PICTURES {
    
    /**
     * Returns all the pictures in the database
     */
    GetAll("SELECT * FROM pictures"),
    /**
     * returns all the pictures that belong to the specified user
     */
    GetByUserId("SELECT * FROM pictures WHERE user_id = ?");
    
    private final String sql;
    
    private PICTURES(String sql) {
        this.sql = sql;
    }
    
    public String sql() {
        return sql;
    }
    
}
