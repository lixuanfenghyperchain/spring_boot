package com.hyperchain.spring_boot.business.exception;

/**
 * Created by superlee on 2017/11/7.
 */
public class TokenException extends Exception {
    public TokenException(String errorMsg) {
        super(errorMsg);
    }
}
