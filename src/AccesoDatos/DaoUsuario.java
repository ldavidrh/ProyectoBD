/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Usuario;
import java.sql.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class DaoUsuario {

    FachadaBD fachada;

    public DaoUsuario() {
        fachada = new FachadaBD();
    }

    public Usuario consultarDatos(String id_persona) {
        String sql_consultar;
        ResultSet resultado = null;
        sql_consultar = "SELECT * FROM usuario WHERE id = '" + id_persona + "';";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            resultado = sentencia.executeQuery(sql_consultar);
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        Usuario usuario = new Usuario();
        try {
            while (resultado.next()) {
                usuario.setPersona_id(resultado.getString(1));
                usuario.setContraseña(resultado.getString(2));
                usuario.setTipo_u(resultado.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }
}
