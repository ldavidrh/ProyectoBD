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
    
    public String guardarUsuario(Usuario u){
        String sql_guardar;
        sql_guardar = "INSERT INTO usuario VALUES('" + u.getUsuario()+ "', '" +
                      u.getContrasenia()+ "', '" + u.getTipo_u() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Usuario creado correctamente";
            }else{
                return "Error: No se insertó el usuario";
            }
        }
        catch(SQLException e){
            System.out.println(e);
            return "Ya existe un usuario con ese id";
        }
        catch(Exception e){ 
            System.out.println(e); 
            return "Ha ocurrido un error al crear el usuario";
        }        
    }
            
    public String modificarUsuario(String usuario, String contrasenia){
        String sql_modificar;
        sql_modificar = "UPDATE usuario SET password='" + contrasenia + "' WHERE id_persona = '" + usuario + "'";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_modificar)==1){
                return "Usuario modificado exitosamente";
            }else{
                return "No existe un usuario con ese id";
            }            
        }catch(Exception e){
            System.out.println(e);
            return "Ha ocurrido un error al modificar el usuario";
        }
    }
    
    public String eliminarUsuario(String id){
        String sql_delete;
        sql_delete = "DELETE FROM usuario WHERE id_persona = '" + id + "'";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_delete)==1){
                return "Usuario eliminado exitosamente";
            }else{
                return "No se eliminó el usuario";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar el usuario";
        }                             
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
    
     public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }  
}
