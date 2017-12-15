/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoAgenda;
import Modelo.Agenda;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class ControlAgenda {
    DaoAgenda daoAgenda;
    
    public ControlAgenda(){
        daoAgenda = new DaoAgenda();
    }
    
     public String actualizarAgenda(String id_medico, String fecha, String hora_inicio){
        Agenda a  = new Agenda(id_medico, fecha, hora_inicio);
        return daoAgenda.actualizarAgenda(a);
    }
    
    public ArrayList consultarAgenda(String id_medico, String fecha){
        return daoAgenda.consultarAgenda(id_medico, fecha);
    }    
    
    public String consultarAgendaMensual(String id_medico, String fecha){
        return daoAgenda.consultaAgendaMensual(id_medico, fecha);      
    }
    
    public String eliminarCita(String id_medico, String fecha, String hora){
        return daoAgenda.eliminarCita(id_medico, fecha, hora);
    }
    
    public void cerrarConexionBD(){
        daoAgenda.cerrarConexionBD();
    }
    
}
