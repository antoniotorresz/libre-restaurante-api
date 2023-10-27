package com.example.librerestaurante.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Platillo")
public class Platillo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long platilloId;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String categoria;

    @OneToMany(mappedBy = "platillo", cascade = CascadeType.ALL)
    private Set<DetalleOrden> detalleOrdenes = new HashSet<>();

    public Platillo(){}

    /**
     * @return long return the platilloId
     */
    public long getPlatilloId() {
        return platilloId;
    }

    /**
     * @param platilloId the platilloId to set
     */
    public void setPlatilloId(long platilloId) {
        this.platilloId = platilloId;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return Double return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return String return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return Set<DetalleOrden> return the detalleOrdenes
     */
    public Set<DetalleOrden> getDetalleOrdenes() {
        return detalleOrdenes;
    }

    /**
     * @param detalleOrdenes the detalleOrdenes to set
     */
    public void setDetalleOrdenes(Set<DetalleOrden> detalleOrdenes) {
        this.detalleOrdenes = detalleOrdenes;
        for(DetalleOrden _do : detalleOrdenes){
            _do.setPlatillo(this);
        }
    }

}
