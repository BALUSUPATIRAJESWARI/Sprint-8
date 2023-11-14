package com.cabapp.pro.exception;

import lombok.Data;

@Data
public class ComplaintException extends RuntimeException{
    private int statusCode;
    private String message;

    public ComplaintException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
