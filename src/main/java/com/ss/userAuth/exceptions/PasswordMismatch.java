/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ss.userAuth.exceptions;

/**
 *
 * @author eherrerra
 */
public class PasswordMismatch extends InvalidFieldException {
    
    private static final long serialVersionUID = 1L;

    public PasswordMismatch() {
        super("Password Mismatch");
    }  

}
