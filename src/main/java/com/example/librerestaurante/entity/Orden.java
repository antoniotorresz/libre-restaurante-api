package com.example.librerestaurante.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ordenId;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
    private Date date_time;
    private String status;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private Set<DetalleOrden> detalleOrdenes = new HashSet<>();

    

    /**
     * @return long return the ordenId
     */
    public long getOrdenId() {
        return ordenId;
    }

    /**
     * @param ordenId the ordenId to set
     */
    public void setOrdenId(long ordenId) {
        this.ordenId = ordenId;
    }

    /**
     * @return Empleado return the empleado
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * @return Date return the date_time
     */
    public Date getDate_time() {
        return date_time;
    }

    /**
     * @param date_time the date_time to set
     */
    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
        for(DetalleOrden _do: detalleOrdenes){
            _do.setOrden(this);
        }
    }

}
