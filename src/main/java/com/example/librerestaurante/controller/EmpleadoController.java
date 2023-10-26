package com.example.librerestaurante.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librerestaurante.entity.Empleado;
import com.example.librerestaurante.service.EmpleadoService;

@RestController
@RequestMapping(path = "empleados")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> getAllEmpleados(){
        return empleadoService.getEmpleados();
    }
    
    @GetMapping("/{empleadoId}")
    public Optional<Empleado> getEmpleadoById(@PathVariable("empleadoId") Long id){
        return empleadoService.getEmpleadoById(id);
    }

    @PostMapping
    public Empleado insertOrUpdateEmpleado(@RequestBody Empleado e){
        empleadoService.insertOrUpdateEmpleado(e);
        return e;
    }

    @DeleteMapping("/{empleadoId}")
    public void deleteEmpleadoById(@PathVariable("empleadoId") Long id){
        empleadoService.deleteEmpleadoById(id);
    }
}
