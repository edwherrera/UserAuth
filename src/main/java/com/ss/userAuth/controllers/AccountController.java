/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.controllers;

import com.ss.userAuth.models.LoginModel;
import com.ss.userAuth.models.UserSignupModel;
import static spark.Spark.*;

/**
 *
 * @author alan
 */
public class AccountController extends Controller {

    public AccountController() {
        super();
    }

    private void validateUserPassword() {
        before("/signup", (req, res) -> {
            UserSignupModel signupModel = modelFromJson(req.body(), UserSignupModel.class);
            if (!signupModel.getPassword().equals(signupModel.getConfirmPassword())) {
                System.out.println("Not valid password");
                res.status(500);
            }
        });
    }

    private void signup() {
        post("/signup", (req, res) -> {
            return "";
        });
    }

    private void login() {
        post("/login", (req, res) -> {
            LoginModel loginModel = modelFromJson(req.body(), LoginModel.class);
            return "";
        });
    }

    @Override
    protected void setupRoutes() {
        login();
        signup();
    }

    @Override
    protected void setupMiddleware() {
        validateUserPassword();
    }
}
