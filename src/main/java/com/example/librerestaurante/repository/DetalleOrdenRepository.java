package com.example.librerestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librerestaurante.entity.DetalleOrden;

public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> {
    
}
