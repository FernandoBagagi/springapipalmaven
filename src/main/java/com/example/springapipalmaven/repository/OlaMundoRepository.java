package com.example.springapipalmaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapipalmaven.model.OlaMundo;

public interface OlaMundoRepository extends JpaRepository<OlaMundo, Long> {

}
