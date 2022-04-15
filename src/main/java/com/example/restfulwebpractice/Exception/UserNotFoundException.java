package com.example.restfulwebpractice.Exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String s){
        super(s);
    }
}
