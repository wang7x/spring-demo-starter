package com.wang7x.demo.exception;

public class ShortAllowanceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ShortAllowanceException() {
        super(null, null, true, false);
    }

    public ShortAllowanceException(String message) {
        super(message, null, true, false);
    }
}
