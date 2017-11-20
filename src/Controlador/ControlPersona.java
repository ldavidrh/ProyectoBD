/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Persona;
import AccesoDatos.*;
import java.sql.*;
/**
 *
 * @author User
 */
public class ControlPersona {
    DaoPersona daoPersona;

    public ControlPersona(){
        daoPersona = new DaoPersona();
    }
    
    public String insertarPersona(String id_persona, String nombre, String direccion, String telefono){
        Persona p = new Persona(id_persona, nombre, direccion, telefono);
        return daoPersona.guardarPersona(p);
    }
    
    public ResultSet consultarPersona(String id){
        return daoPersona.consultarPersona(id);
    }
    
    public String modificarPersona(String id_persona, String nombre, String direccion, String telefono){
        Persona p = new Persona(id_persona, nombre, direccion, telefono);
        return daoPersona.modificarPersona(p);
    }
    
    public String eliminarPersona(String id){
        return daoPersona.eliminarPaciente(id);
    }
    
    public void cerrarConexionBD(){
        daoPersona.cerrarConexionBD();
    }
}