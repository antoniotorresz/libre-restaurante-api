package com.example.librerestaurante.repository;

import org.springframework.stereotype.Repository;
import com.example.librerestaurante.entity.Platillo;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlatilloRepository extends JpaRepository<Platillo, Long>{}
