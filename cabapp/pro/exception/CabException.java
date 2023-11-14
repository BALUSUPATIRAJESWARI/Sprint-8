package com.cabapp.pro.exception;

import lombok.Data;

@Data

public class CabException extends RuntimeException {
    private int statusCode;
    private String message;

    public CabException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
