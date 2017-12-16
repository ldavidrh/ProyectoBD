/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Registro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juandavid
 */
public class DaoRegistro {
    
    FachadaBD fachada;

    public DaoRegistro() {
        fachada = new FachadaBD();
    }

    public String guardarRegistro(Registro r) {
        String sql_guardar;        
        sql_guardar = "INSERT INTO registro VALUES('" + r.getCodigo_registro() + "', '" +
                r.getNum_historia() + "', '" + r.getId_persona() + "', '" 
                + r.getFecha() + "');";
        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.executeUpdate(sql_guardar)==1) {
                return "Registro guardado exitosamente";
            } else {
                return "No se pudo guardar el Registro";
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Ya se creó un registro para esta cita";
        }catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al crear el Registro";
        }
    }
    
    
    
    
    public String[] consultarRegistro(String id_persona) {
        String sql_consultar;
        String[] consulta = new String[4];

        sql_consultar = "SELECT * FROM registro WHERE id_persona = '" + id_persona + "';";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);

            if (tabla.next()) {
                consulta[0] = tabla.getString(1);
                consulta[1] = tabla.getString(2);
                consulta[2] = tabla.getString(3);
                consulta[3] = tabla.getString(4);
            } else {
                consulta = null;
            }
            return consulta;
        } catch (SQLException e) {
            System.out.print(e);
            return null;
        }
    }
    
    public String guardarCausas(String codigo_registro, String codigo_causa){
        String sql_guardar;
        sql_guardar = "INSERT INTO causas_registro VALUES('" + codigo_registro
                      + "', '" + codigo_causa + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Causa guardada correctamente";
            }else{
                return "Error: No se insertó la causa";
            }
        }catch(SQLException ex){
            System.out.println(ex);
            return "Ya se agregó esa causa al registro";
        }
        catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al guardar la causa";
        }        
    }
    
    
    

    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
    
}
