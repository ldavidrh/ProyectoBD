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
public class Formula {    
    String id_formula;
    String id_medico;
    String id_paciente;
    String fecha;

    public Formula(String id_formula, String id_medico, String id_paciente, String fecha) {
        this.id_formula = id_formula;       
        this.id_medico = id_medico;
        this.id_paciente = id_paciente;
        this.fecha = fecha;
    }

    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }

    public String getId_formula() {
        return id_formula;
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_formula(String id_formula) {
        this.id_formula = id_formula;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }    

    public String getFecha() {
        return fecha;
    }
}
