/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoCausa;
import Modelo.Causa;

/**
 *
 * @author juandavid
 */
public class ControlCausa {
    
    DaoCausa daoCausa;
    
    public ControlCausa(){
        daoCausa = new DaoCausa();
    }
    
     public String insertarCausa(String codigo_causa, String nombre, String descripcion){
        Causa c  = new Causa(codigo_causa, nombre, descripcion);
        return daoCausa.guardarCausa(c);
    }
    
    public String[] consultarCausa(String codigo_causa){
        return daoCausa.consultarCausa(codigo_causa);
    }
    
    public String modificarCausa(String codigo_causa, String nombre, String descripcion){
        Causa causa = new Causa(codigo_causa, nombre, descripcion);
        return daoCausa.modificarCausa(causa);
    }
    
    public String eliminarCausa(String codigo_causa){
        return daoCausa.eliminarCausa(codigo_causa);
    }
    
    public void cerrarConexionBD(){
        daoCausa.cerrarConexionBD();
    }
    
}
