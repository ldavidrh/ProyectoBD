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
    
    public String insertarRegistro(String codigo_registro, String num_historia, String id_persona, String fecha){
        Registro r = new Registro(codigo_registro, num_historia, id_persona, fecha);
        return daoRegistro.guardarRegistro(r);
    }
    
    public String[] consultarRegistro(String id_persona){       
        return daoRegistro.consultarRegistro(id_persona);
    }
    
    public String insertarCausas(String codigo_registro, String codigo_causa){
        return daoRegistro.guardarCausas(codigo_registro, codigo_causa);
    }
    
    public void cerrarConexionBD(){
        daoRegistro.cerrarConexionBD();
    }
    
}
