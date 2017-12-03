/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoCama;
import Modelo.Cama;
import java.util.ArrayList;

/**
 *
 * @author juandavid
 */
public class ControlCama {
     DaoCama daoCama;
    
    public ControlCama(){
        daoCama = new DaoCama();
    }
    
     public String insertarCama(String num_cama, String descripcion, String codigo_area, String estado){
        Cama c  = new Cama(num_cama, descripcion, codigo_area, estado);
        return daoCama.guardarCama(c);
    }
    
    public String[] consultarCama(String num_cama){
        return daoCama.consultarCama(num_cama);
    }
    
    public String modificarCama(String num_cama, String descripcion, String codigo_area){        
        return daoCama.modificarCama(num_cama, descripcion, codigo_area);
    }
    
    public String eliminarCama(String num_cama){
        return daoCama.eliminarCama(num_cama);
    }
    
    public void eliminarArea(String cod){
        daoCama.eliminarArea(cod);
    }
    
    public boolean verificarExistencia(String num){
        return daoCama.verificarExistencia(num);
    }
    
    public void modificarEstado(String num_cama, String estado){
        daoCama.modificarEstado(num_cama, estado);
    }
    
    public void camasHilo(ArrayList camas_libres_hoy){
        daoCama.camasHilo(camas_libres_hoy);
    }
    
    public void cerrarConexionBD(){
        daoCama.cerrarConexionBD();
    }
}
