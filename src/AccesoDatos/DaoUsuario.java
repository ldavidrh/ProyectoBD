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

    public String[] consultarUsuario(String id_persona) {
        String[] resultado = new String[3];
        String sql_select;        
        sql_select = "SELECT * FROM usuario WHERE id_persona = '" + id_persona + "';";
        try{
            Connection conn = fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);            
            if(tabla.next()){
                resultado[0]=tabla.getString(1);
                resultado[1]=tabla.getString(2);
                resultado[2]=tabla.getString(3);
            }else{
                resultado = null;
            }
            return resultado;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
}
