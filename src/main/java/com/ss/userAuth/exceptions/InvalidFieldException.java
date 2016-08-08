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
public abstract class InvalidFieldException extends Exception {

    public InvalidFieldException(String message) {
        super(message);
    }
    
}
