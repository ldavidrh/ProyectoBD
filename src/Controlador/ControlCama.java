/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoCama;
import Modelo.Cama;

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
    
    public String modificarCama(String num_cama, String descripcion, String codigo_area, String estado){
        Cama cama = new Cama(num_cama, descripcion, codigo_area, estado);
        return daoCama.modificarCama(cama);
    }
    
    public String eliminarCama(String num_cama){
        return daoCama.eliminarCama(num_cama);
    }
    
    public void cerrarConexionBD(){
        daoCama.cerrarConexionBD();
    }
}
