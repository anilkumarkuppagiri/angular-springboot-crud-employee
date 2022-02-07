package com.test.exception;

public class ResourceAlreadyExistsException extends RuntimeException{

    public ResourceAlreadyExistsException(){
        super("Employee already exists");
    }
}
