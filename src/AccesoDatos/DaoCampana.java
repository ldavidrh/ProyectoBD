/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Campana;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juandavid
 */
public class DaoCampana {
    FachadaBD fachada;
    public DaoCampana(){
        fachada= new FachadaBD();
    }
    
    public String guardarPaciente(Campana c){
        String sql_guardar;
        sql_guardar="INSERT INTO campana VALUES ('" + c.getCodigo_campana() + "', '" + c.getNombre() +  "', '" +
                c.getObjetivo() + "', '"  + c.getFecha() +  "', '" + c.getId_persona() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Campaña creada correctamente";
            }else{
                return "Error: No se insertó la campaña";
            } 
        }
        catch(SQLException e){
            System.out.println(e);
            return "Ya existe una campaña con ese id registrado en el hospital";
        }
        catch(Exception e){ 
            System.out.println(e); 
            return "Ha ocurrido un error al crear la campaña";
        }        
    }

    public String[] consultarCampaña(String id){        
        String sql_select;
        String consulta[] = new String[5];
        sql_select="SELECT * FROM campana WHERE codigo_campana = '" + id +  "'";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);            
            if(tabla.next()){
                consulta[0] = tabla.getString(1);
                consulta[1] = tabla.getString(2);
                consulta[2] = tabla.getString(3);
                consulta[3] = tabla.getString(4);
                consulta[4] = tabla.getString(5);            
            }else{
                consulta = null;
            }
            return consulta;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public String modificarCampana(Campana c){
        String sql_update;
        sql_update="UPDATE campana SET "
                + "nombre='" + c.getNombre() + "', objetivo='" 
                + c.getObjetivo() + "', fecha='" + c.getFecha()
                + "', id_persona='" + c.getId_persona() + 
                "' WHERE codigo_campana = '" + c.getCodigo_campana() + "'";
                
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_update)==1){
                return "Campaña modificada exitosamente";
            }else{
                return "No existe una campaña con ese id";
            }            
        }catch(Exception e){
            System.out.println(e);
            return "Ha ocurrido un error al modificar la campaña";
        }
    }    
   
    public String eliminarCampana(String id){
        String sql_borrar;
        sql_borrar="DELETE FROM campana WHERE codigo_campana = '" + id +  "'";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_borrar)==1){
                return "Campaña eliminada exitosamente";
            }else{
                return "No se eliminó campaña";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar la campaña";
        }                             
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
}
