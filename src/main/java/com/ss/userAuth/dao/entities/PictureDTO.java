/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.dao.entities;

/**
 *
 * @author eherrerra
 */
public class PictureDTO {
    private int id;
    private String location;
    private int userId;

    public PictureDTO() {
    }

    public PictureDTO(int id, String location, int userId) {
        this.id = id;
        this.location = location;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
