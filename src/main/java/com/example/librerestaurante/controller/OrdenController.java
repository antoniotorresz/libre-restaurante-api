package com.example.librerestaurante.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librerestaurante.entity.Orden;
import com.example.librerestaurante.entity.Empleado;
import com.example.librerestaurante.entity.NuevaOrdenRequest;
import com.example.librerestaurante.service.EmpleadoService;
import com.example.librerestaurante.service.OrdenService;

@RestController
@RequestMapping(path = "ordenes")
public class OrdenController {
    private final OrdenService ordenService;
    private final EmpleadoService empleadoService;

    @Autowired
    public OrdenController(OrdenService _ordenService, EmpleadoService _empleadoService) {
        this.ordenService = _ordenService;
        this.empleadoService = _empleadoService;
    }

    @GetMapping()
    public List<Orden> getAllOrdenes(){
        return ordenService.getAllOrdenes();
    }

    @GetMapping("/{ordenId}")
    public Optional<Orden> getOrdenById(@PathVariable("ordenId") Long id){
        return ordenService.getOrdenById(id);
    }

    @PostMapping
    public ResponseEntity<Orden> insertOrden(@RequestBody NuevaOrdenRequest nuevaOrdenRequest){
        Optional<Empleado> _empleado = empleadoService.getEmpleadoById(nuevaOrdenRequest.getEmpleadoId());
        Empleado empleado = _empleado.orElse(null);
        if(empleado == null){
            return ResponseEntity.badRequest().body(null);
        }
               // Crear una nueva orden
        Orden nuevaOrden = new Orden();
        nuevaOrden.setEmpleado(empleado);
        nuevaOrden.setDate_time(new Date()); // Otra opción sería aceptar la fecha y hora como parte de la solicitud
        nuevaOrden.setStatus("Activa"); // Define el estado inicial de la orden

        Orden ordenCreada = ordenService.insertOrUpdateOrden(nuevaOrden);

        if (ordenCreada != null) {
            //Aqui mando a llamar la logica para guardar datos en la tabla de detalle orden
            return ResponseEntity.status(HttpStatus.CREATED).body(ordenCreada);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
