package com.example.springapipalmaven.controller.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapipalmaven.dto.LoginRequest;
import com.example.springapipalmaven.dto.RefreshTokenRequest;
import com.example.springapipalmaven.dto.ParTokens;
import com.example.springapipalmaven.model.RefreshToken;
import com.example.springapipalmaven.service.TokenService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final TokenService service;

    @PostMapping("/login")
    public ParTokens login(@RequestBody LoginRequest request) {
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //System.out.println(encoder.encode("123456"));

        //System.out.println("entra aqui");
        this.service.validarLogin(request.username(), request.password());
        //System.out.println("entra aqui 2");
        return this.service.gerarTokens(request.username());

    }

    @PostMapping("/refresh")
    public ParTokens refresh(@RequestBody RefreshTokenRequest request) {

        final RefreshToken refreshToken = this.service.validarToken(request.token());

        return this.service.gerarTokens(refreshToken);

    }

}
