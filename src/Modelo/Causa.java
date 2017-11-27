/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author juandavid
 */
public class Causa {
    String codigo_causa;
    String nombre;
    String descripcion;

    public Causa(String codigo_causa, String nombre, String descripcion) {
        this.codigo_causa = codigo_causa;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public String getCodigo_causa() {
        return codigo_causa;
    }

    public void setCodigo_causa(String codigo_causa) {
        this.codigo_causa = codigo_causa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
