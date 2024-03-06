package com.paypilotprojectspring.card.exception;

public class CardException extends RuntimeException{

    public CardException(String message) {
        super(message);
    }

    public CardException(String message, Throwable cause) {
        super(message, cause);
    }
}