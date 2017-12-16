/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.HistoriaClinica;
import AccesoDatos.*;
/**
 *
 * @author User
 */
public class ControlHistoriaClinica {
    DaoHistoriaClinica daoHistoria;
    
    public ControlHistoriaClinica(){
        daoHistoria = new DaoHistoriaClinica();        
    }
    
    public String insertarHistoria(String num, String fecha){
        HistoriaClinica h = new HistoriaClinica(num, fecha);
        return daoHistoria.guardarHistoria(h);
    }
    
    public String[] consultarHistoria(String num){
        return daoHistoria.consultarHistoria(num);
    }
    
    public String modificarHistoria(String num, String fecha){
        HistoriaClinica h = new HistoriaClinica(num, fecha);
        return daoHistoria.modificarHistoria(h);
    }
    
    public String eliminarHistoria(String num){
        return daoHistoria.eliminarHistoria(num);
    }
    
    public String listarRegistros(String num_historia, String causas){
        return daoHistoria.listarRegistros(num_historia, causas);
    }
    
    public void cerrarConexionBD(){
        daoHistoria.cerrarConexionBD();
    }
}