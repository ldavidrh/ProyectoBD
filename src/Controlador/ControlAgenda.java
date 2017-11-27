/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoAgenda;
import Modelo.Agenda;

/**
 *
 * @author Luis
 */
public class ControlAgenda {
    DaoAgenda daoAgenda;
    
    public ControlAgenda(){
        daoAgenda = new DaoAgenda();
    }
    
     public String insertarAgenda(String id_medico, String fecha, String hora, String disponibilidad){
        Agenda a  = new Agenda(id_medico, fecha, hora, disponibilidad);
        return daoAgenda.guardarAgenda(a);
    }
    
    public String[] consultarAgenda(String id_medico){
        return daoAgenda.consultarAgenda(id_medico);
    }
    
    public String modificarAgenda(String id_medico, String fecha, String hora, String disponibilidad){
        Agenda a = new Agenda(id_medico, fecha, hora, disponibilidad);
        return daoAgenda.modificarAgenda(a);
    }
    
    public void cerrarConexionBD(){
        daoAgenda.cerrarConexionBD();
    }
    
}
