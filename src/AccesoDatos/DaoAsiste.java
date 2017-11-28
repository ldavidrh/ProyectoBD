/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Asiste;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juandavid
 */
public class DaoAsiste {
    FachadaBD fachada;
    
    public DaoAsiste(){
        fachada = new FachadaBD();
    }
    
    public String guardarAsiste(Asiste a){
        String sql_guardar;
        sql_guardar = "INSERT INTO asiste VALUES('" + a.getId_persona() + "', '" +
                      a.getCodigo_campana() + "', '" + a.getDescuento() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Asistencia registrada";
            }else{
                return "Error: No se insertó la asistencia";
            }
        }
        catch(SQLException e){
            System.out.println(e);
            return "Error: No se insertó la asistencia";
        }
        catch(Exception e){ 
            System.out.println(e); 
            return "Error: No se insertó la asistencia";
        }        
    }
    
    
    public String[] consultarAsiste(String id_persona, String codigo_campana){
        String sql_select;  
        String consulta[] = new String[3];
        sql_select = "SELECT * FROM asiste WHERE id_persona = '" + id_persona + 
                "' AND codigo_campana='" + codigo_campana + "';";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);            
            if(tabla.next()){
                consulta[0] = tabla.getString(1);
                consulta[1] = tabla.getString(2);
                consulta[2] = tabla.getString(3);              
            }else{
                consulta = null;
            }
            return consulta;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public String modificarAsiste(Asiste a){
        String sql_modificar;
        sql_modificar = "UPDATE asiste SET descuento ='" + a.getDescuento() + 
                        "' WHERE id_persona = '" + a.getId_persona() + "' AND codigo_campana='" + a.getCodigo_campana() + "';";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_modificar)==1){
                return "Asistencia modificada exitosamente";
            }else{
                return "No existe la asistencia";
            }            
        }catch(Exception e){
            System.out.println(e);
            return "Ha ocurrido un error al modificar la asistencia";
        }
    }
    
    public String eliminarAsiste(String id_persona, String codigo_campana){
        String sql_delete;
        sql_delete = "DELETE FROM asiste WHERE id_persona = '" + id_persona +
                "' AND codigo_campana='" + codigo_campana + "';";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_delete)==1){
                return "Asistencia eliminada exitosamente";
            }else{
                return "No se eliminó la asistencia";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar la asistencia";
        }                             
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
}
