package com.cabapp.pro.exception;

import lombok.Data;

@Data
public class CustomerException extends RuntimeException{

    private int statusCode;
    private String message;

    public CustomerException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
