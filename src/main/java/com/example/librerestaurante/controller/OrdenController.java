package com.example.librerestaurante.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.librerestaurante.entity.Orden;
import com.example.librerestaurante.entity.Platillo;
import com.example.librerestaurante.entity.OrdenDetalleDTO;
import com.example.librerestaurante.entity.DetalleOrden;
import com.example.librerestaurante.entity.Empleado;
import com.example.librerestaurante.service.DetalleOrdenService;
import com.example.librerestaurante.service.EmpleadoService;
import com.example.librerestaurante.service.OrdenService;
import com.example.librerestaurante.service.PlatilloService;

@RestController
@RequestMapping(path = "/api/v1/ordenes")
public class OrdenController {
    private final OrdenService ordenService;
    private final EmpleadoService empleadoService;
    private final DetalleOrdenService detalleOrdenService;
    private final PlatilloService platilloService;
    @Autowired
    public OrdenController(OrdenService _ordenService, EmpleadoService _empleadoService, DetalleOrdenService _detalleOrdenService, PlatilloService _platilloService) {
        this.ordenService = _ordenService;
        this.empleadoService = _empleadoService;
        this.detalleOrdenService = _detalleOrdenService;
        this.platilloService = _platilloService;
    }

    @GetMapping()
    public List<Orden> getAllOrdenes() {
        return ordenService.getAllOrdenes();
    }

    @GetMapping("/{ordenId}")
    public Optional<Orden> getOrdenById(@PathVariable("ordenId") Long id) {
        return ordenService.getOrdenById(id);
    }

    @PostMapping
    public ResponseEntity<Orden> crearOrden(@RequestBody OrdenDetalleDTO detalleDTO) {
        Optional<Empleado> empleadoOrden = empleadoService.getEmpleadoById(detalleDTO.getEmpleadoId());
        if (empleadoOrden.isPresent()) {
            Orden orden = new Orden();
            orden.setEmpleado(empleadoOrden.get());
            Orden ordenCreada = ordenService.insertOrUpdateOrden(orden);
            for(Long platilloId : detalleDTO.getPlatilloYCantidad().keySet()){
                DetalleOrden detalleOrden = new DetalleOrden();
                Optional<Platillo> platillo = platilloService.getPlatilloById(platilloId);
                if(platillo.isPresent()){
                    detalleOrden.setOrden(ordenCreada);
                    detalleOrden.setPlatillo(platillo.get());
                    detalleOrden.setCantidad(detalleDTO.getPlatilloYCantidad().get(platilloId));
                    detalleOrden.setSubtotal(platillo.get().getPrecio() * detalleDTO.getPlatilloYCantidad().get(platilloId));
                    detalleOrdenService.insertOrUpdatDetalleOrden(detalleOrden);
                }else{
                    return ResponseEntity.badRequest().body(null);
                }
            }
            return ResponseEntity.ok().body(null);
            
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
