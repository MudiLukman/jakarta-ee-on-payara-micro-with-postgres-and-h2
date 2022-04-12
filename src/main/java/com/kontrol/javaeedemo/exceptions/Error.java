package com.kontrol.javaeedemo.exceptions;

public class Error {
    private String message;
    private int code;

    public Error(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
