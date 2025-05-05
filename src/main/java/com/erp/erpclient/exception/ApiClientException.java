package com.erp.erpclient.exception;

public class ApiClientException extends RuntimeException {
    private final String errorCode;

    public ApiClientException(String errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ApiClientException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}