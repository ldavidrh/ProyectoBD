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
public class HistoriaClinica {
    String num_historia;
    String fecha_apertura;

    public HistoriaClinica(String num_historia, String fecha_apertura) {
        this.num_historia = num_historia;
        this.fecha_apertura = fecha_apertura;
    }    

    public String getNum_historia() {
        return num_historia;
    }

    public void setNum_historia(String num_historia) {
        this.num_historia = num_historia;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }
    
    
}
