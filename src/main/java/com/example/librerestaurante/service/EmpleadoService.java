package com.example.librerestaurante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librerestaurante.entity.Empleado;
import com.example.librerestaurante.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<Empleado> getEmpleados(){
        return empleadoRepository.findAll();
    }
    
    public Optional<Empleado> getEmpleadoById(Long id){
        return empleadoRepository.findById(id);
    }

    public void insertOrUpdateEmpleado(Empleado e){
        empleadoRepository.save(e);
    }

    public void deleteEmpleadoById(Long id){
        empleadoRepository.deleteById(id);
    }
}
