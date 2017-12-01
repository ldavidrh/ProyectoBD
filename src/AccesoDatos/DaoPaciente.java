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
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Paciente creado correctamente";
            }else{
                return "Error: No se insertó el paciente";
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

    public String[] consultarPaciente(String id){        
        String sql_select;
        String consulta[] = new String[5];
        sql_select="SELECT * FROM paciente WHERE id_persona = '" + id +  "'";
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
    
    public String modificarPaciente(String id, String seguridad_social, String actividad_economica){
        String sql_update;
        sql_update="UPDATE paciente SET "
                + " seguridad_social='" + seguridad_social 
                + "', actividad_economica='" + actividad_economica + 
                "' WHERE id_persona = '" + id + "'";
                
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_update)==1){
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
            if(sentencia.executeUpdate(sql_borrar)==1){
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
