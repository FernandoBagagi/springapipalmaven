package com.example.springapipalmaven.controller.auth;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ParTokens> login(@RequestBody LoginRequest request) {
        
        this.service.validarLogin(request.username(), request.password());
        
        return ResponseEntity.ok(this.service.gerarTokens(request.username()));

    }

    @PostMapping("/refresh")
    public ResponseEntity<ParTokens> refresh(@RequestBody RefreshTokenRequest request) {

        final RefreshToken refreshToken = this.service.validarToken(request.token());

        return ResponseEntity.ok(this.service.gerarTokens(refreshToken));

    }

}
