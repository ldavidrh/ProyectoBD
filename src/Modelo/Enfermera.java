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
public class Enfermera {
    String id_persona;
    int anios_exp;

    public Enfermera(String id_persona, int anios_exp) {
        this.id_persona = id_persona;
        this.anios_exp = anios_exp;
    }   
    
    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public int getAnios_exp() {
        return anios_exp;
    }

    public void setAnios_exp(int anios_exp) {
        this.anios_exp = anios_exp;
    }
    
}
