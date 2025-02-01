package org.example.project.exceptions;

public class ProductAlreadyExistException extends Exception{
    public ProductAlreadyExistException(){
        super("Product Already Exist");
    }
}
