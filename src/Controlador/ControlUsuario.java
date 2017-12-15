/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoUsuario;
import Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class ControlUsuario {

    DaoUsuario daoUsuario;

    public ControlUsuario() {
        daoUsuario = new DaoUsuario();
    }

    public String verificarUsuario(String cedula, String password, String tipo) {
        String[] resultado = daoUsuario.consultarDatos(cedula);
        if (resultado == null) {
            return null;
        } else {
            if (resultado[1].equals(password) && resultado[2].equals(tipo)) {
                return resultado[0];
            } else {
                return null;
            }
        }
    }
    
    public String cambiarPassword(String id_usuario, String passwordAntiguo, String passwordNuevo){
        String[] consulta = consultarUsuario(id_usuario);
        if(consulta[1].equals(passwordAntiguo)){
            return daoUsuario.cambiarPassword(id_usuario, passwordNuevo);
        }else{
            return "La contraseña anterior no coincide";
        }
        
        
    }
    
    public String agregarUsuario (String usuario,String contrasenia,String tipo_u) {
        Usuario u = new Usuario(usuario,contrasenia,tipo_u);
        return daoUsuario.guardarUsuario(u);
    }
    
    public String eliminarUsuario (String usuario){
        return daoUsuario.eliminarUsuario(usuario);
    }
    
    public String[] consultarUsuario(String usuario){
        return daoUsuario.consultarDatos(usuario);
    }
    
    public String modificarUsuario(String usuario,String contrasenia){
        return daoUsuario.modificarUsuario(usuario,contrasenia);
    }
    
    
    
    
    
}
