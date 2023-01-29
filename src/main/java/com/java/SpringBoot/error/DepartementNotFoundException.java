package com.java.SpringBoot.error;

public class DepartementNotFoundException extends Exception {
    public DepartementNotFoundException() {
        super();
    }

    public DepartementNotFoundException(String message) {
        super(message);
    }

    public DepartementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartementNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DepartementNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
