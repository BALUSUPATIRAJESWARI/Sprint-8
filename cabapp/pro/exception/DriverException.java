package com.cabapp.pro.exception;

import lombok.Data;

@Data

public class DriverException extends RuntimeException{

    private int statusCode;
    private String message;

    public DriverException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}