package com.paypilotprojectspring.bill.exception;

public class BillException extends RuntimeException{

    public BillException(String message) {
        super(message);
    }

    public BillException(String message, Throwable cause) {
        super(message, cause);
    }
}
