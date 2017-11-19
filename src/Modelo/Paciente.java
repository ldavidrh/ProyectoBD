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
public class Paciente {
    String id_persona;
    String num_historia;
    String seguridad_social;
    String fecha_nacimiento;
    String actividad_economica;

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getNum_historia() {
        return num_historia;
    }

    public void setNum_historia(String num_historia) {
        this.num_historia = num_historia;
    }

    public String getSeguridad_social() {
        return seguridad_social;
    }

    public void setSeguridad_social(String seguridad_social) {
        this.seguridad_social = seguridad_social;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getActividad_economica() {
        return actividad_economica;
    }

    public void setActividad_economica(String actividad_economica) {
        this.actividad_economica = actividad_economica;
    }
    
}
