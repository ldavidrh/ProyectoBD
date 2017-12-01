/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Paciente;
import AccesoDatos.*;
/**
 *
 * @author invitado
 */
public class ControlPaciente {
    DaoPaciente daoPaciente;
    
    public ControlPaciente(){
        daoPaciente = new DaoPaciente();
    }
    
    public String insertarPaciente(String id_persona, String num_historia, String seguridad_social, String fecha_nacimiento, String actividad_economica){
        Paciente pac = new Paciente(id_persona, num_historia, seguridad_social, fecha_nacimiento, actividad_economica);
        return daoPaciente.guardarPaciente(pac);
    }
    
    public String[] consultarPaciente(String id){
        return daoPaciente.consultarPaciente(id); 
    }
    
    public String modificarPaciente(String id_persona, String seguridad_social, String actividad_economica){             
       return daoPaciente.modificarPaciente(id_persona, seguridad_social, actividad_economica);
    }
    
    public String eliminarPaciente(String id){
        return daoPaciente.eliminarPaciente(id);    
    }
    
    public void cerrarConexionBD(){
        daoPaciente.cerrarConexionBD();
    }   
}