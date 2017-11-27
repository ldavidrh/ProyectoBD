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
    String num_historia;
    String codigo_causa;
    String id_persona; 
    String fecha;

    public Registro(String num_historia, String codigo_causa, String id_persona, String fecha) {
        this.num_historia = num_historia;
        this.codigo_causa = codigo_causa;
        this.id_persona = id_persona;
        this.fecha = fecha;
    }
    
    public String getNum_historia() {
        return num_historia;
    }

    public void setNum_historia(String num_historia) {
        this.num_historia = num_historia;
    }

    public String getCodigo_causa() {
        return codigo_causa;
    }

    public void setCodigo_causa(String codigo_causa) {
        this.codigo_causa = codigo_causa;
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
