package com.example.librerestaurante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librerestaurante.entity.Orden;
import com.example.librerestaurante.repository.OrdenRepository;

@Service
public class OrdenService {
    @Autowired
    OrdenRepository ordenRepository;

    public List<Orden> getAllOrdenes(){
        return ordenRepository.findAll();
    }

    public Optional<Orden> getOrdenById(Long id){
        return ordenRepository.findById(id);
    }

    public Orden insertOrUpdateOrden(Orden o){
        ordenRepository.save(o);
        return o;
    }

    public void deleteOrdenById(Long id){
        ordenRepository.deleteById(id);
    }
}
