package com.example.michelle.littleprincesses.exception;

/**
 * Created by Shuoyao on 4/11/15.
 */
public class AccountAlreadyExistException extends Exception {


    private String message;

    public AccountAlreadyExistException(){
        super();
        this.message = "Account Already Exist";
    }

    public String getMessage(){
        return this.message;
    }
}
