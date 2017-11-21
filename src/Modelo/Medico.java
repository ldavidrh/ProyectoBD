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
public class Medico {
    String id_persona;
    String especialidad;
    String num_licencia;
    String universidad;
    String num_agenda;

    public Medico(String id_persona, String especialidad, String num_licencia, String universidad, String num_agenda) {
        this.id_persona = id_persona;
        this.especialidad = especialidad;
        this.num_licencia = num_licencia;
        this.universidad = universidad;
        this.num_agenda = num_agenda;
    }    
    
    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNum_licencia() {
        return num_licencia;
    }

    public void setNum_licencia(String num_licencia) {
        this.num_licencia = num_licencia;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getNum_agenda() {
        return num_agenda;
    }

    public void setNum_agenda(String num_agenda) {
        this.num_agenda = num_agenda;
    }
    
}
