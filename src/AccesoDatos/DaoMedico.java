/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Medico;
import java.sql.*;
/**
 *
 * @author User
 */
public class DaoMedico {
    FachadaBD fachada;
    public DaoMedico(){
        fachada= new FachadaBD();
    }
    
    public String guardarMedico(Medico m){
        String sql_guardar;
        sql_guardar = "INSERT INTO medico VALUES('" + m.getId_persona() + "', '" +
                      m.getEspecialidad()+ "', '" + m.getNum_licencia() + "', '" + m.getUniversidad() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.execute(sql_guardar)){
                return "Médico creado correctamente";
            }else{
                return "Error: No se insertó el médico";
            }
        }catch(SQLException ex){
            System.out.println(ex);
            return "Ha ocurrido un error: " + ex.getMessage();
        }
        catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al crear el médico";
        }        
    }
    
    public String[] consultarMedico(String id){
        String sql_select;     
        String consulta[] = new String[4];
        sql_select = "SELECT * FROM medico WHERE id_persona = '" + id + "'";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);            
            if(tabla.next()){
                consulta[0] = tabla.getString(1);
                consulta[1] = tabla.getString(2);
                consulta[2] = tabla.getString(3);
                consulta[3] = tabla.getString(4);                                       
            }else{
                consulta = null;
            }
            return consulta;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }        
    }
    
    public String modificarMedico(Medico m){
        String sql_modificar;
        sql_modificar = "UPDATE medico SET especialidad ='" + m.getEspecialidad() + "', num_licencia ='" +
                        m.getNum_licencia()+ "', universidad = '" + m.getUniversidad() + 
                        "' WHERE id_persona = '" + m.getId_persona() + "'";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.execute(sql_modificar)){
                return "Médico modificado exitosamente";
            }else{
                return "No existe un Médico con ese id";
            }            
        }catch(Exception ex){
            System.out.println(ex);
            return "Ha ocurrido un error al modificar el médico";
        }
    }
    
    public String eliminarMedico(String id){
        String sql_delete;
        sql_delete = "DELETE FROM medico WHERE id_persona = '" + id + "'";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.execute(sql_delete)){
                return "Médico eliminado exitosamente";
            }else{
                return "No se eliminó el médico";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar el médico";
        }                             
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
}
