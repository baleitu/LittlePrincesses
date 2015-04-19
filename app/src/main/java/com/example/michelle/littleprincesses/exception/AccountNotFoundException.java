package com.example.michelle.littleprincesses.exception;

/**
 * Created by Shuoyao on 4/11/15.
 */
public class AccountNotFoundException extends Exception {

    private String message;

    public AccountNotFoundException(){
        super();
        this.message = "Account Not Found";
    }

    public String getMessage(){
        return this.message;
    }

}
