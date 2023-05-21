package com.driver;

public class DirectorNotFoundException extends  RuntimeException{
    public DirectorNotFoundException(){
        super("Director not found");
    }
}
