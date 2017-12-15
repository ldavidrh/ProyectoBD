/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoCita;
import Modelo.Cita;

/**
 *
 * @author Luis
 */
public class ControlCita {
    DaoCita daoCita;
    
    public ControlCita(){
        this.daoCita = new DaoCita();
    }
    
    public String insertarCita(String id_medico, String id_paciente, String fecha, String hora, int precio){
        Cita cita = new Cita(id_medico, id_paciente, fecha, hora, precio);
        return daoCita.guardarCita(cita);
    }
    
   
    
}
