package com.example.springapipalmaven.service;

import org.springframework.stereotype.Component;

import com.example.springapipalmaven.dto.ApiErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LogService {

    private void gerarWarnLog(ApiErrorResponse body) {
        log.warn("{} Erro de negócio [{}]: {}",
                body.timestamp(),
                body.code(),
                body.message());
    }

    private void gerarErrorLog(String msgErro, Throwable t) {
        log.error(msgErro, t);
    }

    public void gerarApiErrorLogs(ApiErrorResponse body, Throwable t) {
        this.gerarWarnLog(body);
        this.gerarErrorLog(body.message(), t);
    }
    
}
