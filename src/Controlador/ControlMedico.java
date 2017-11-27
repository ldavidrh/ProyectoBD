/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Medico;
import AccesoDatos.*;
/**
 *
 * @author User
 */
public class ControlMedico {
    DaoMedico daoMedico;

    public ControlMedico(){
        daoMedico = new DaoMedico();
    }
    
    public String insertarMedico(String id_persona, String especialidad, String num_licencia, String universidad){
        Medico m = new Medico(id_persona, especialidad, num_licencia, universidad);
        return daoMedico.guardarMedico(m);
    }
    
    public String[] consultarMedico(String id){
        return daoMedico.consultarMedico(id);
    }
    
    public String modificarMedico(String id_persona, String especialidad, String num_licencia, String universidad){
        Medico m = new Medico(id_persona, especialidad, num_licencia, universidad);
        return daoMedico.modificarMedico(m);
    }
    
    public String eliminarMedico(String id){
        return daoMedico.eliminarMedico(id);
    }
    
    public void cerrarConexionBD(){
        daoMedico.cerrarConexionBD();
    }
}
