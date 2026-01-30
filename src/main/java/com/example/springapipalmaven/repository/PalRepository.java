package com.example.springapipalmaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapipalmaven.model.Pal;

public interface PalRepository extends JpaRepository<Pal, Long> {

}
