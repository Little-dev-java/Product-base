package org.example.project.exceptions;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException(){
        super("User already exists");
    }
}
