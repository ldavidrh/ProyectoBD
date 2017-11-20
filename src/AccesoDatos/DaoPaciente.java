/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

/**
 *
 * @author invitado
 */
import Modelo.Paciente;
import java.sql.*;

public class DaoPaciente {
    FachadaBD fachada;
    public DaoPaciente(){
        fachada= new FachadaBD();
    }
    
    public String guardarPaciente(Paciente pac){
        String sql_guardar;
        sql_guardar="INSERT INTO paciente(id_persona,num_historia,seguridad_social,fecha_nacimiento,actividad_economica) VALUES ('" +
                pac.getId_persona() + "', '" + pac.getNum_historia() +  "', '" +
                pac.getSeguridad_social() + "', '"  + pac.getFecha_nacimiento() +  "', '" +
                pac.getActividad_economica() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)>0){
                return "Paciente creado correctamente";
            }else{
                return "No se realizó la acción: 0 filas afectadas";
            } 
        }
        catch(SQLException e){
            System.out.println(e);
            return "Ya existe un paciente con ese id registrado en el hospital";
        }
        catch(Exception e){ 
            System.out.println(e); 
            return "Ha ocurrido un error al crear el paciente";
        }        
    }

    public ResultSet consultarPaciente(String id){        
        String sql_select;
        sql_select="SELECT * FROM paciente WHERE id_persona = '" + id +  "'";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);            
            return tabla;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public String modificarPaciente(Paciente pac){
        String sql_update;
        sql_update="UPDATE paciente SET "
                + "num_historia='" + pac.getNum_historia() + "', seguridad_social='" 
                + pac.getSeguridad_social() + "', fecha_nacimiento='" + pac.getFecha_nacimiento()
                + "', actividad_economica='" + pac.getActividad_economica() + 
                "' WHERE id_persona = '" + pac.getId_persona() + "'";
                
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_update)>0){
                return "Paciente modificado exitosamente";
            }else{
                return "No existe un paciente con ese id";
            }            
        }catch(Exception e){
            System.out.println(e);
            return "Ha ocurrido un error al modificar el paciente";
        }
    }    
   
    public String eliminarPaciente(String id){
        String sql_borrar;
        sql_borrar="DELETE FROM paciente WHERE id_persona = '" + id +  "'";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_borrar)>0){
                return "Paciente eliminado exitosamente";
            }else{
                return "No se eliminó el paciente";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar el paciente";
        }                             
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }    
}