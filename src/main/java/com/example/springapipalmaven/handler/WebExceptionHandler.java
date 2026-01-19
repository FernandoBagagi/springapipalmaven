package com.example.springapipalmaven.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.springapipalmaven.exception.ApiException;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public String handle(ApiException e, Model model) {
        model.addAttribute("code", e.getErrorCode());
        model.addAttribute("message", e.getMessage());
        model.addAttribute("timestamp", e.getTimestamp());
        return "error/erro-generico";
    }

}
