package com.example.springapipalmaven.exception;

import org.springframework.http.HttpStatus;

public class ItemNaoEncontradoException extends ApiException {

    public ItemNaoEncontradoException(final Long id) {
        super(
            "Item de id " + id + " não encontrado!",
            HttpStatus.NOT_FOUND,
            "OBJECT_NOT_FOUND"
        );
    }
    
}

