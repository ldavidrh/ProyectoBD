/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoAsignada;
import Modelo.Asignada;
import java.util.ArrayList;

/**
 *
 * @author juandavid
 */
public class ControlAsignada {
     DaoAsignada daoAsignada;
    
    public ControlAsignada(){
        daoAsignada = new DaoAsignada();
    }
    
     public String insertarAsignada(String id_persona, String num_cama, String fecha_asignacion, String fecha_finalizacion){
        Asignada a  = new Asignada(id_persona, num_cama, fecha_asignacion, fecha_finalizacion);
        return daoAsignada.guardarAsignada(a);
    }
    
    public String[] consultarAsignada(String num_cama){
        return daoAsignada.consultarAsignada(num_cama);
    }
    
    public String modificarAsignada(String id_persona, String num_cama, String fecha_asignacion, String fecha_finalizacion){
        Asignada a = new Asignada(id_persona, num_cama, fecha_asignacion, fecha_finalizacion);
        return daoAsignada.modificarAsignada(a);
    }
    
    public String eliminarAsignada(String num_cama){
        return daoAsignada.eliminarAsignada(num_cama);
    }
    
    public ArrayList verficarFechaSalida(){
        return daoAsignada.verificarFechaSalida();
    }
    
    public String historialCama(String num_Cama){
    return daoAsignada.historialCama(num_Cama);
    }
    
    public String historialPaciente(String id_persona){
    return daoAsignada.historialPaciente(id_persona);
    }
    
    public void cerrarConexionBD(){
        daoAsignada.cerrarConexionBD();
    }
}
