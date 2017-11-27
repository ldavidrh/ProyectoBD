/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Area;
import AccesoDatos.*;
/**
 *
 * @author User
 */
public class ControlArea {
    DaoArea daoArea;

    public ControlArea(){
        daoArea = new DaoArea();
    }
    
    public String insertarArea(String codigo_area, String nombre, String descripcion){
        Area a = new Area(codigo_area, nombre, descripcion);
        return daoArea.guardarArea(a);
    }
    
    public String[] consultarArea(String codigo){
        return daoArea.consultarArea(codigo);
    }
    
    public String modificarArea(String codigo_area, String nombre, String descripcion){
        Area a = new Area(codigo_area, nombre, descripcion);
        return daoArea.modificarArea(a);
    }
    
    public String eliminarArea(String codigo){
        return daoArea.eliminarArea(codigo);
    }
    
    public void cerrarConexionBD(){
        daoArea.cerrarConexionBD();
    }
}
