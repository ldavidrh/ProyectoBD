/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoUsuario;
import Modelo.Usuario;
import java.sql.ResultSet;

/**
 *
 * @author Luis
 */
public class ControlUsuario {

    DaoUsuario daoUsuario;

    public ControlUsuario() {
        daoUsuario = new DaoUsuario();
    }

    public boolean consultarDatos(String cedula, String password) {
        String[] resultado = daoUsuario.consultarUsuario(cedula);
        if (resultado == null) {
            return false;
        } else {
            if (resultado[1].equals(password)) {
                return true;
            } else {
                return false;
            }

        }
    }

}
