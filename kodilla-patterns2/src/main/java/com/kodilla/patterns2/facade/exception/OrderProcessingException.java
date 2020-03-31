package com.kodilla.patterns2.facade.exception;

public class OrderProcessingException extends Exception {

    public static final String ERR_NOT_AUTHORIZED = "User is not authorized";
    public static final String ERR_PAYMENT_REJECTED = "Payment was rejected";
    public static final String ERR_VERIFICATION_ERROR = "Verification error";
    public static final String ERR_SUBMITTING_ERROR = "Cannot submit error";

    public OrderProcessingException(String message) {
        super(message);
    }
}
