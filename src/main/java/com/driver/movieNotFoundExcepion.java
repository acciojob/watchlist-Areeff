package com.driver;

public class movieNotFoundExcepion extends RuntimeException{
    public movieNotFoundExcepion(){
        super("movie not found");
    }
}
