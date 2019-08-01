package com.brs.oa.exception;

public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CustomException(String msg) {
        super(msg);
    }

    public CustomException() {
        super();
    }
}
