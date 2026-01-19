package com.example.springapipalmaven.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.springapipalmaven.exception.UsuarioNaoEncontradoException;
import com.example.springapipalmaven.model.Usuario;
import com.example.springapipalmaven.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        
        final Usuario usuario = repository.findByUsername(username)
                .orElseThrow(UsuarioNaoEncontradoException::new);

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER")
                .build();

    }

}
