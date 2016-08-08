/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.controllers;

import com.ss.userAuth.exceptions.PasswordMismatch;
import com.ss.userAuth.exceptions.UserNotFound;
import com.ss.userAuth.exceptions.UsernameAlreadyInUse;
import com.ss.userAuth.models.LoginModel;
import com.ss.userAuth.models.UserModel;
import com.ss.userAuth.models.UserSignupModel;
import com.ss.userAuth.services.SessionServices;
import com.ss.userAuth.services.UserServices;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;

/**
 *
 * @author alan
 */
public class AccountController extends Controller {

    private final UserServices userServices;
    private final SessionServices sessionServices;
    
    private static final String PATH = "/Users";

    public AccountController() {
        super();
        userServices = new UserServices();
        sessionServices = new SessionServices();
    }

    private void signup() {
        post(PATH+"/signup", (req, res) -> {
            UserSignupModel signUpModel = modelFromJson(req.body(), UserSignupModel.class);
            UserModel newUser = userServices.addUser(signUpModel);
            return gson.toJson(newUser);
        });
    }

    private void login() {

        post(PATH+"/login", (req, res) -> {

            res.type("application/json");

            LoginModel loginModel = modelFromJson(req.body(), LoginModel.class);
            userServices.login(loginModel);
            int userId = userServices.getUserByUsername(loginModel.getUsername()).getId();
            Map<String, String> returnModel = new HashMap<>();
            returnModel.put("token", sessionServices.addSession(userId));
            return gson.toJson(returnModel);

        });
    }
    
    private void userNotFoundHandler() {
        exception(UserNotFound.class, (exception,req,res) -> {
            res.body(exception.getMessage());
            res.status(403);
        });
    }
    
    private void usernameAlreadyInUseHandler() {
        exception(UsernameAlreadyInUse.class, (exception,req,res) -> {
            res.body(exception.getMessage());
            res.status(403);
        });
    }
    
    private void passwordMismatchHandler() {
        exception(PasswordMismatch.class, (exception,req,res) -> {
            res.body(exception.getMessage());
            res.status(403);
        });
    }

    @Override
    protected void setupRoutes() {
        login();
        signup();
    }

    @Override
    protected void setupMiddleware() {

    }

    @Override
    protected void setupExceptionHandling() {
        userNotFoundHandler();
        usernameAlreadyInUseHandler();
        passwordMismatchHandler();
    }
    
}
