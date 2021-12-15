package com.example.spring_crud.exeption;

public class ValidationException extends Exception{

    private String message;

    public ValidationException(String message){
        this.message=message;
    }
    public String getMessage(){
        return message;
    }
}
