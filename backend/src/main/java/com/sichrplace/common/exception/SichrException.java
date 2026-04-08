package com.sichrplace.common.exception;

public class SichrException extends RuntimeException {

    public SichrException(String message) {
        super(message);
    }

    public SichrException(String message, Throwable cause) {
        super(message, cause);
    }
}
