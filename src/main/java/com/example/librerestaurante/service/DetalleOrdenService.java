package com.example.librerestaurante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librerestaurante.entity.DetalleOrden;
import com.example.librerestaurante.repository.DetalleOrdenRepository;

@Service
public class DetalleOrdenService {
    @Autowired
    DetalleOrdenRepository detalleOrdenRepository;

    public List<DetalleOrden> getAllDetalleOrdenes() {
        return detalleOrdenRepository.findAll();
    }

    public Optional<DetalleOrden> getDetalleOrdenById(Long id) {
        return detalleOrdenRepository.findById(id);
    }

    public DetalleOrden insertOrUpdatDetalleOrden(DetalleOrden detalleOrden) {
        detalleOrdenRepository.save(detalleOrden);
        return detalleOrden;
    }

    public void deleteDetalleOrdenById(Long detalleOrdenId) {
        detalleOrdenRepository.deleteById(detalleOrdenId);
    }
}
