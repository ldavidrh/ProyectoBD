/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Habilidades;
import AccesoDatos.*;
/**
 *
 * @author User
 */
public class ControlHabilidades {
    DaoHabilidades daoHabilidades;

    public ControlHabilidades(){
        daoHabilidades = new DaoHabilidades();
    }
    
    public String insertarHabilidades(String id_persona, String habilidad){
        Habilidades h = new Habilidades(id_persona, habilidad);
        return daoHabilidades.guardarHabilidades(h);
    }
    
    public String consultarHabilidades(String id){       
        return daoHabilidades.consultarHabilidades(id);
    }
     
    public String eliminarHabilidades(String id, String habilidad){
        Habilidades h = new Habilidades(id, habilidad);
        return daoHabilidades.eliminarHabilidad(h);
    }
    
    public void cerrarConexionBD(){
        daoHabilidades.cerrarConexionBD();
    }
}
