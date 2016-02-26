package com.augmentum.common.exception;


public class BusinessException extends Exception {
    private static final long serialVersionUID = 6207936304809473506L;

    public BusinessException() {
        super();
    }

    /**
     * @param message
     */
    public BusinessException(String message) {
        super(message);
    }

}
