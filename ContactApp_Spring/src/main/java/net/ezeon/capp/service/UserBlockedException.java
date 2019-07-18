/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ezeon.capp.service;

/**
 * This object will be thrown when user account is blocked.
 * @author Vikram
 */
public class UserBlockedException extends Exception{

    public UserBlockedException() {
    }

    public UserBlockedException(String message) {
        super(message);
    }
    
}
