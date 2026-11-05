package com.bookmanger.springbootbookmanager.exception;

public class NotLoginException extends RuntimeException {
    public NotLoginException(String message){
        super(message);
    }

}
