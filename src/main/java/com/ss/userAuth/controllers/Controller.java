/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.controllers;

import com.google.gson.Gson;

/**
 *
 * @author alan
 */
public abstract class Controller {
    
    protected final Gson gson;
    
    public Controller() {
        gson = new Gson();
        setupRoutes();
        setupMiddleware();
        setupExceptionHandling();
    }
    
    protected abstract void setupRoutes();
    protected abstract void setupMiddleware();
    protected abstract void setupExceptionHandling();
    
    protected <T> T modelFromJson(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }
}
