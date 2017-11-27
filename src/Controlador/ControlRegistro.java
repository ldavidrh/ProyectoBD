/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoRegistro;
import Modelo.Registro;

/**
 *
 * @author juandavid
 */
public class ControlRegistro {
    
        DaoRegistro daoRegistro;

    public ControlRegistro(){
        daoRegistro = new DaoRegistro();
    }
    
    public String insertarRegistro(String num_historia, String codigo_causa, String id_persona, String fecha){
        Registro r = new Registro(num_historia, codigo_causa, id_persona, fecha);
        return daoRegistro.guardarRegistro(r);
    }
    
    public String[] consultarRegistro(String id_persona){       
        return daoRegistro.consultarRegistro(id_persona);
    }
     
    public String eliminarRegistro(String num_historia, String codigo_causa, String id_persona, String fecha){
        Registro r = new Registro(num_historia, codigo_causa, id_persona, fecha);
        return daoRegistro.eliminarRegistro(r);
    }
    
    public void cerrarConexionBD(){
        daoRegistro.cerrarConexionBD();
    }
    
}
