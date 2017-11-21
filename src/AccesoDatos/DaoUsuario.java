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

    public String[] consultarDatos(String id_persona) {
        String sql_consultar;
        String[] resultado = new String[3];
        ResultSet tabla;
        sql_consultar = "SELECT * FROM usuario WHERE id_persona = '" + id_persona + "';";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            tabla = sentencia.executeQuery(sql_consultar);
            if(tabla.next()){
                resultado[0] = tabla.getString(1);
                resultado[1] = tabla.getString(2);
                resultado[2] = tabla.getString(3);
                return resultado;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
