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
public class Registro {
    String codigo_registro;
    String num_historia;  
    String id_persona; 
    String fecha;

    public Registro(String codigo_registro, String num_historia, String id_persona, String fecha) {
        this.codigo_registro = codigo_registro;
        this.num_historia = num_historia;    
        this.id_persona = id_persona;
        this.fecha = fecha;
    }
    
    public String getNum_historia() {
        return num_historia;
    }

    public void setNum_historia(String num_historia) {
        this.num_historia = num_historia;
    }

    public String getCodigo_registro() {
        return codigo_registro;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
