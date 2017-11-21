/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Enfermera;
import AccesoDatos.*;
/**
 *
 * @author User
 */
public class ControlEnfermera {
    DaoEnfermera daoEnfermera;

    public ControlEnfermera(){
        daoEnfermera = new DaoEnfermera();
    }
    
    public String insertarEnfermera(String id_persona, int anios_exp){
        Enfermera e = new Enfermera(id_persona, anios_exp);
        return daoEnfermera.guardarEnfermera(e);
    }
    
    public String[] consultarEnfermera(String id){
        return daoEnfermera.consultarEnfermera(id);
    }
    
    public String modificarEnfermera(String id_persona, int anios_exp){
        Enfermera e = new Enfermera(id_persona, anios_exp);
        return daoEnfermera.modificarEnfermera(e);
    }
    
    public String eliminarEnfermera(String id){
        return daoEnfermera.eliminarEnfermera(id);
    }
    
    public void cerrarConexionBD(){
        daoEnfermera.cerrarConexionBD();
    }
}
