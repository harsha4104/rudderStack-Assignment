package com.rudderstack.source.exception;

import lombok.Getter;

@Getter
public class RudderStackException extends Exception{

    String status;
    String errorMessage;

    public RudderStackException(String status, String errorMessage){
        this.errorMessage = errorMessage;
        this.status = status;
    }
}
