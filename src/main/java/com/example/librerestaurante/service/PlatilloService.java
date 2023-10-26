package com.example.librerestaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.librerestaurante.repository.PlatilloRepository;
import com.example.librerestaurante.entity.Platillo;
import java.util.List;
import java.util.Optional;
@Service
public class PlatilloService {
    @Autowired
    PlatilloRepository platilloRepository;

    public List<Platillo> getPlatillos(){
        return platilloRepository.findAll();
    }
    @GetMapping("/{platilloId}")
    public Optional<Platillo> getPlatilloById(@PathVariable("platilloId")Long id){
        return platilloRepository.findById(id);
    }
    public void saveOrUpdate(@RequestBody Platillo p){
        platilloRepository.save(p);
    }
    @DeleteMapping("/{platilloId}")
    public void deleteById(@PathVariable("platilloId") Long id){
        platilloRepository.deleteById(id);
    }
}
