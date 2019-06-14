package com.hyperchain.spring_boot.service;


import com.hyperchain.spring_boot.business.exception.InvalidJwtException;
import com.hyperchain.spring_boot.business.exception.TokenException;
import com.hyperchain.spring_boot.config.interceptors.token.Token;

/**
 * Created by superlee on 2018/1/8.
 */
public interface TokenService {
    String createJwtWithSecret(Token token, String secret) throws TokenException;

    Token verifyJwt(String jwtStr) throws TokenException, InvalidJwtException;

    Token getTokenWithoutSig(String jwtStr) throws TokenException;
}
