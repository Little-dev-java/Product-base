package org.example.project.exceptions;

public class QuantityException extends Exception{
    public QuantityException(){
        super("There is no such quantity");
    }
}
