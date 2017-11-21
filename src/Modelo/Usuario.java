/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author invitado
 */
public class Usuario {
    String persona_id;
    String password;
    String tipo_u;
    
    public Usuario(){}
    public String getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(String usuario) {
        this.persona_id = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setContraseña(String contraseña) {
        this.password = contraseña;
    }

    public String getTipo_u() {
        return tipo_u;
    }

    public void setTipo_u(String tipo_u) {
        this.tipo_u = tipo_u;
    }
    
}
