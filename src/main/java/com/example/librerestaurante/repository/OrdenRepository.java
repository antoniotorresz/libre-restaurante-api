package com.example.librerestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librerestaurante.entity.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Long>{
    
}
