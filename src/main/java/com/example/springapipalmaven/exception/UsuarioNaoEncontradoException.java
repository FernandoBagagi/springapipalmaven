package com.example.springapipalmaven.exception;

import org.springframework.http.HttpStatus;

public class UsuarioNaoEncontradoException extends ApiException {

    public UsuarioNaoEncontradoException() {
        super(
            "Usuário não encontrado",
            HttpStatus.NOT_FOUND,
            "USER_NOT_FOUND"
        );
    }
    
}

