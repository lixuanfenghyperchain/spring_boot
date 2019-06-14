package com.hyperchain.spring_boot.business.exception;

/**
 * @author sunligang
 * @date 2018/11/20
 */
public class InvalidJwtException extends Exception {
    public InvalidJwtException() {
    }

    public InvalidJwtException(String message) {
        super(message);
    }
}
