package com.example.springapipalmaven.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapipalmaven.dto.OlaMundoDto;
import com.example.springapipalmaven.service.OlaMundoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/olamundo")
@RequiredArgsConstructor
public class OlaMundoController {

    private final OlaMundoService service;

    @GetMapping("/{id}")
    public ResponseEntity<OlaMundoDto> findById(@PathVariable Long id) {

        return ResponseEntity.ok(this.service.findById(id));

    }

}
