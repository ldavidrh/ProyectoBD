/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoCampana;
import Modelo.Campana;

/**
 *
 * @author juandavid
 */
public class ControlCampana {
    DaoCampana daoCampana;
    
    public ControlCampana(){
        daoCampana = new DaoCampana();
    }
    
    public String insertarCampana(String codigo_campana, String nombre, String objetivo, String fecha, String id_persona){
        Campana c = new Campana(codigo_campana, nombre, objetivo, fecha, id_persona);
        return daoCampana.guardarCampana(c);
    }
    
    public String[] consultarCampana(String id){
        return daoCampana.consultarCampana(id); 
    }
    
    public String modificarCampana(String codigo_campana, String nombre, String objetivo, String fecha, String id_persona){
        Campana c = new Campana(codigo_campana, nombre, objetivo, fecha, id_persona);      
       return daoCampana.modificarCampana(c);
    }
    
    public String eliminarCampana(String id){
        return daoCampana.eliminarCampana(id);    
    }
    
    public void cerrarConexionBD(){
        daoCampana.cerrarConexionBD();
    }   
}
