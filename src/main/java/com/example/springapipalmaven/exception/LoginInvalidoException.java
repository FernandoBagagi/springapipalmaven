package com.example.springapipalmaven.exception;

import org.springframework.http.HttpStatus;

public class LoginInvalidoException extends ApiException {

    public LoginInvalidoException() {
        super(
            "Username e/ou senha inválidos",
            HttpStatus.UNAUTHORIZED,
            "INVALID_USERNAME_PASSWORD"
        );
    }
    
}

