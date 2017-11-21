/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import java.sql.*;
import Modelo.Enfermera;
/**
 *
 * @author User
 */
public class DaoEnfermera {
    FachadaBD fachada;
    
    public DaoEnfermera(){
        fachada = new FachadaBD();
    }
    
    public String guardarEnfermera(Enfermera e){
        String sql_guardar;
        sql_guardar = "INSERT INTO enfermera VALUES('" + e.getId_persona() + "', '" +
                      e.getAnios_exp() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.execute(sql_guardar)){
                return "Enfermera creada correctamente";
            }else{
                return "Error: No se insertó la enfermera";
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
            return "Ya existe una enfermera con ese id, registrada en el hospital";
        }
        catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al crear la enfermera";
        }        
    }
    
    public String[] consultarEnfermera(String id){
        String sql_select;  
        String consulta[] = new String[2];
        sql_select = "SELECT * FROM enfermera WHERE id_persona = '" + id + "'";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);            
            if(tabla.next()){
                consulta[0] = tabla.getString(1);
                consulta[1] = tabla.getString(2);                
            }else{
                consulta = null;
            }
            return consulta;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public String modificarEnfermera(Enfermera e){
        String sql_modificar;
        sql_modificar = "UPDATE enfermera SET anios_exp ='" + e.getAnios_exp() +
                        "' WHERE id_persona = '" + e.getId_persona() + "'";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.execute(sql_modificar)){
                return "Enfermera modificada exitosamente";
            }else{
                return "No existe una enfermera con ese id";
            }            
        }catch(Exception ex){
            System.out.println(e);
            return "Ha ocurrido un error al modificar la enfermera";
        }
    }
    
    public String eliminarEnfermera(String id){
        String sql_delete;
        sql_delete = "DELETE FROM enfermera WHERE id_persona = '" + id + "'";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.execute(sql_delete)){
                return "Enfermera eliminada exitosamente";
            }else{
                return "No se eliminó la enfermera";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar la enfermera";
        }                             
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }    
    
}
