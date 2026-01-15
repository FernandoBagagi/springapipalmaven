package com.example.springapipalmaven.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springapipalmaven.domain.OlaMundo;
import com.example.springapipalmaven.dto.OlaMundoDto;
import com.example.springapipalmaven.mapper.OlaMundoMapper;
import com.example.springapipalmaven.repository.OlaMundoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OlaMundoService {

    private final OlaMundoRepository repository;
    private final OlaMundoMapper mapper;

    public OlaMundoDto findById(final Long id) {

        final OlaMundo model = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de id " + id + " não encontrado!"));

        model.setName(model.getName() + " Teste");

        return this.mapper.fromModelToDto(model);

    }

    public List<OlaMundoDto> findAll() {

        return repository.findAll()
                .stream()
                .map(this.mapper::fromModelToDto)
                .toList();

    }
}
