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
public class Asignada {
    String id_persona;
    String num_cama;
    String fecha_asignacion;
    String fecha_finalizacion;

    public Asignada(String id_persona, String num_cama, String fecha_asignacion, String fecha_finalizacion) {
        this.id_persona = id_persona;
        this.num_cama = num_cama;
        this.fecha_asignacion = fecha_asignacion;
        this.fecha_finalizacion = fecha_finalizacion;
    }       
    
    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getNum_cama() {
        return num_cama;
    }

    public void setNum_cama(String num_cama) {
        this.num_cama = num_cama;
    }

    public String getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(String fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public String getFecha_finalizacion() {
        return fecha_finalizacion;
    }

    public void setFecha_finalizacion(String fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }            
}
