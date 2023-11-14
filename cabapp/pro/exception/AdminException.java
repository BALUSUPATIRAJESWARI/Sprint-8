package com.cabapp.pro.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AdminException extends RuntimeException {
    private int statusCode;
    private String message;

    public AdminException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
