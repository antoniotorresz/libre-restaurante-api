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

import com.example.librerestaurante.entity.Platillo;
import com.example.librerestaurante.service.PlatilloService;

@RestController
@RequestMapping(path = "platillos")
public class PlatilloController {
    @Autowired
    private PlatilloService platilloService;

    @GetMapping
    public List<Platillo> getAllPlatillos(){
        return platilloService.getPlatillos();
    }
    @GetMapping("/{platilloId}")
    public Optional<Platillo> getPlatilloById(@PathVariable("platilloId") Long id){
        return platilloService.getPlatilloById(id);
    }
    @PostMapping
    public Platillo insertOrUpdatePlatillo(@RequestBody Platillo p){
        platilloService.saveOrUpdate(p);
        return p;
    }
    @DeleteMapping("/{platilloId}")
    public void deletePlatillo(@PathVariable("platilloId") Long id){
        platilloService.deleteById(id);
    }
}
