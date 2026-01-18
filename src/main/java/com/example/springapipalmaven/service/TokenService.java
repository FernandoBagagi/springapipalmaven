package com.example.springapipalmaven.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.example.springapipalmaven.dto.ParTokens;
import com.example.springapipalmaven.model.RefreshToken;
import com.example.springapipalmaven.model.Usuario;
import com.example.springapipalmaven.repository.RefreshTokenRepository;
import com.example.springapipalmaven.repository.UsuarioRepository;
import com.example.springapipalmaven.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenService {

    private static final long TEMPO_EXPIRAR_ACCESS_TOKEN = 60 * 60 * 1000L; // 1 hora de validade
    private static final long TEMPO_EXPIRAR_REFRESH_TOKEN = 7 * 24 * 60 * 60 * 1000L; // 7 dias de validade

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UsuarioRepository usuarioRepository;

    public void validarLogin(String username, String password) {

        try {

            Authentication auth = new UsernamePasswordAuthenticationToken(username, password);
            authManager.authenticate(auth);

        } catch (AuthenticationException e) {

            e.printStackTrace();
            // TODO: Criar Exception para login e/ou senha inválidos
            //throw new RuntimeException("Username e/ou senha inválidos");

        }

    }

    public RefreshToken validarToken(String token) {

        final RefreshToken refreshToken = this.refreshTokenRepository.findByToken(token)
                .orElseThrow(
                        // TODO: Criar Exception para RefreshToken não encontrado
                        () -> new RuntimeException("Refresh token inválido"));

        if (refreshToken.getExpiresAt().isBefore(Instant.now())) {
            // TODO: Criar Exception para RefreshToken expirado
            throw new RuntimeException("Refresh token expirado");
        }

        return refreshToken;

    }

    private RefreshToken findOrCreateRefreshToken(String username) {
        return this.refreshTokenRepository
                .findByUsuarioUsername(username)
                .orElse(new RefreshToken());
    }

    private String gerarTokenDoRefreshToken() {
        return UUID.randomUUID().toString();
    }

    private Instant gerarExpiresAtDoRefreshToken() {
        return Instant.now().plus(TEMPO_EXPIRAR_REFRESH_TOKEN, ChronoUnit.MILLIS);
    }

    private Usuario getUsuarioDoRefreshToken(String username) {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    private ParTokens criarAccessTokenERenovarRefreshToken(
            String username,
            RefreshToken refreshToken //
    ) {

        final String accessToken = //
                jwtService.generateToken(username, TEMPO_EXPIRAR_ACCESS_TOKEN);

        refreshToken.setToken(this.gerarTokenDoRefreshToken());
        refreshToken.setExpiresAt(this.gerarExpiresAtDoRefreshToken());
        refreshToken.setUsuario(this.getUsuarioDoRefreshToken(username));

        refreshTokenRepository.save(refreshToken);

        return new ParTokens(accessToken, refreshToken.getToken());

    }

    public ParTokens gerarTokens(String username) {

        final RefreshToken refreshToken = this.findOrCreateRefreshToken(username);

        return this.criarAccessTokenERenovarRefreshToken(username, refreshToken);

    }

    public ParTokens gerarTokens(RefreshToken refreshToken) {

        final String username = refreshToken.getUsuario().getUsername();

        return this.criarAccessTokenERenovarRefreshToken(username, refreshToken);

    }

}
