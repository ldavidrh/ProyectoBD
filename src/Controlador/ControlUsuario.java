/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class ControlUsuario {

    DaoUsuario daousuario;

    public ControlUsuario() {
        daousuario = new DaoUsuario();
    }

    public boolean consultarDatos(String cedula, String password, String tipo) {
        String[] resultado = daousuario.consultarDatos(cedula);
        if (resultado == null) {
            return false;
        } else {
            if (resultado[1].equals(password) && resultado[2].equals(tipo)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
