package com.example.librerestaurante.entity;

import java.util.HashMap;

public class OrdenDetalleDTO {
    //atributos necesarios para la clase Orden:
    private long empleadoId;

    //
    private HashMap<Long, Integer> platilloYCantidad;

    

    /**
     * @return long return the empleadoId
     */
    public long getEmpleadoId() {
        return empleadoId;
    }

    /**
     * @param empleadoId the empleadoId to set
     */
    public void setEmpleadoId(long empleadoId) {
        this.empleadoId = empleadoId;
    }

    /**
     * @return HashMap<Long, Long> return the platilloYCantidad
     */
    public HashMap<Long, Integer> getPlatilloYCantidad() {
        return platilloYCantidad;
    }

    /**
     * @param platilloYCantidad the platilloYCantidad to set
     */
    public void setPlatilloYCantidad(HashMap<Long, Integer> platilloYCantidad) {
        this.platilloYCantidad = platilloYCantidad;
    }

}
