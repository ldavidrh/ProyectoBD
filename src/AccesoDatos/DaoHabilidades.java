/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import java.sql.*;
import Modelo.Habilidades;
/**
 *
 * @author User
 */
public class DaoHabilidades {    
    FachadaBD fachada;
    
    public DaoHabilidades(){
        fachada = new FachadaBD();
    }
    
    public String guardarHabilidades(Habilidades h){
        String sql_guardar;
        sql_guardar = "INSERT INTO habilidades VALUES('" + h.getId_persona() + "', '" +
                      h.getHabilidad()+ "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Habilidad registrada correctamente";
            }else{
                return "Error: No se insertó la habilidad";
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
            return "La enfermera ya tiene esa habilidad registrada";
        }
        catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al registrar la habilidad";
        }        
    }
    
    public String consultarHabilidades(String id){
        String sql_select;          
        String consulta = "";
        sql_select = "SELECT * FROM habilidades WHERE id_persona = '" + id + "'";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);            
           
            while(tabla.next()){
                consulta += "-" + tabla.getString(2);
                consulta += "\n";
            }           
            return consulta;
        }catch(Exception e){
            System.out.println(e);
            return "Ha ocurido un error al consultar las habilidades de la enfermera";
        }
    }
         
    public String eliminarHabilidad(Habilidades h){
        String sql_delete;
        sql_delete = "DELETE FROM habilidades WHERE id_persona = '" + h.getId_persona() +
                     "' AND habilidad ='" + h.getHabilidad() + "'";        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_delete)==1){
                return "Habilidad eliminada exitosamente";
            }else{
                return "No se eliminó la habilidad";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar la habilidad";
        }                             
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
}
