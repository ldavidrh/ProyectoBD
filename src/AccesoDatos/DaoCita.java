/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Cita;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class DaoCita {
    FachadaBD fachada;
    public DaoCita(){
        fachada= new FachadaBD();
    }
    
    public String guardarCita(Cita c){
        String sql_guardar;
        sql_guardar = "INSERT INTO cita VALUES('" + c.getId_medico()+ "', '" +
                      c.getId_paciente() + "', '" + c.getFecha() + "', '" + c.getHora() + 
                      "', '" + c.getPrecio() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Cita creada exitosamente";
            }else{
                return "Error: No se creó la cita";
            }
        }catch(SQLException ex){
            System.out.println(ex);
            return "Ha ocurrido un error: " + ex.getMessage();
        }
        catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al crear la cita";
        }        
    }
    
    public String consultarCita(String id_paciente){
        String sql_select;       
        String consulta = "";        
        sql_select ="SELECT id_medico , fecha , hora, precio FROM cita WHERE id_paciente='"+id_paciente+"';";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);   
            
            while(tabla.next()){                
                consulta += "Fecha: " + (String)tabla.getString(2)+
                 "   Médico: " + (String)tabla.getString(1) +
                 "   Hora: " + (String)tabla.getString(3)+
                 "   Precio: " + (String)tabla.getString(4) +
                 "\n";
            }           
            return consulta;            
        }catch(Exception e){
            System.out.println(e);
            return "Ha ocurido un error al consultar la cita";
        }
    }
    
    public String modificarCita(Cita c){
        String sql_modificar;
        sql_modificar = "UPDATE cita SET id_medico ='" + c.getId_medico()+ "', fecha ='" +
                        c.getFecha() + "', hora = '" + c.getHora() + "', precio ='" +
                        c.getPrecio() + "' WHERE id_paciente = '" + c.getId_medico()+ "'";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_modificar)==1){
                return "Empleado modificado exitosamente";
            }else{
                return "No existe un empleado con ese id";
            }            
        }catch(Exception ex){
            System.out.println(ex);
            return "Ha ocurrido un error al modificar el empleado";
        }
    }
    
    
    public ArrayList listarCitasPaciente(String id_paciente){
    String sql_listar;
        ArrayList listar = new ArrayList();
        sql_listar = "SELECT id_medico , fecha , hora FROM cita WHERE id_paciente='"+id_paciente+"';" ;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_listar);

            
            while (tabla.next()) {
                listar.add("ID médico =" + (tabla.getString(1)) +
                ".  fecha =" + (tabla.getString(2)) +
                ".  hora =" + (tabla.getString(3))
                );
                
            }
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            return listar; 
    }
    
    public String eliminarCita(String id_medico,String id_paciente,String fecha,String hora){
        String sql_delete;
        sql_delete = "DELETE FROM cita WHERE id_medico ='" + id_medico + "'"+
                        " and id_paciente ='" + id_paciente + "'" +
                        " and fecha='" + fecha + "'" +
                        " and hora='" + hora + "';";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_delete)==1){
                return "Cita eliminada exitosamente";
            }else{
                return "No se eliminó la cita";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar la cita";
        } 
    }
    
    
    
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
}
