package com.spring.planner.exception;

public class UserDoesNotExistException extends Exception {

    public UserDoesNotExistException(){
        System.out.println("This user does not exist");
    }
}
