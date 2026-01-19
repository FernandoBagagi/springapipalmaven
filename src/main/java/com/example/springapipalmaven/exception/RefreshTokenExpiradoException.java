package com.example.springapipalmaven.exception;

import org.springframework.http.HttpStatus;

public class RefreshTokenExpiradoException extends ApiException {

    public RefreshTokenExpiradoException() {
        super(
            "Refresh token expirado",
            HttpStatus.UNAUTHORIZED,
            "REFRESH_TOKEN_EXPIRED"
        );
    }
    
}

