package com.lucadani.exception;

public class PrintErrorMessageException extends RuntimeException {
    public PrintErrorMessageException(String message) {
        super(message);
    }
}
