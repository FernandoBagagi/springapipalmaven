package com.example.springapipalmaven.exception;

import org.springframework.http.HttpStatus;

public class RefreshTokenInvalidoException extends ApiException {

    public RefreshTokenInvalidoException() {
        super(
            "Refresh token inválido",
            HttpStatus.UNAUTHORIZED,
            "INVALID_REFRESH_TOKEN"
        );
    }
    
}

