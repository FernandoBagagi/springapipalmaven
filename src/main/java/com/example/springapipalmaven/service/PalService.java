package com.example.springapipalmaven.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springapipalmaven.model.Pal;
import com.example.springapipalmaven.repository.PalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PalService {

    private final PalRepository repository;

    public List<Pal> findAll() {
        return this.repository
                .findAll();
    }

}
