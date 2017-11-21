/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoAgenda;
import Modelo.Agenda;
import java.sql.ResultSet;

/**
 *
 * @author Luis
 */
public class ControlAgenda {
    DaoAgenda daoAgenda;
    
    public ControlAgenda(){
        daoAgenda = new DaoAgenda();
    }
    
     public String insertarAgenda(String num_agenda, String fecha, String hora, String disponibilidad){
        Agenda a  = new Agenda(num_agenda, fecha, hora, disponibilidad);
        return daoAgenda.guardarAgenda(a);
    }
    
    public String[] consultarAgenda(String num_agenda){
        return daoAgenda.consultarAgenda(num_agenda);
    }
    
    public String modificarAgenda(String num_agenda, String fecha, String hora, String disponibilidad){
        Agenda a = new Agenda(num_agenda, fecha, hora, disponibilidad);
        return daoAgenda.modificarAgenda(a);
    }
    
    public String eliminarAgenda(String num_agenda){
        return daoAgenda.eliminarAgenda(num_agenda);
    }
    
    public void cerrarConexionBD(){
        daoAgenda.cerrarConexionBD();
    }
    
}
