/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Cita;
import java.sql.*;
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
    
    public String consultarCita(String id_medico, String id_paciente, String fecha){
        String sql_select;       
        String consulta = "";        
        sql_select = "SELECT * FROM cita WHERE id_medico = '" + id_medico + "' AND id_paciente ='"
                      + id_paciente + "' AND fecha ='" + fecha + "'";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);   
            
            while(tabla.next()){                
                consulta += "Fecha: " + tabla.getString(3);
                consulta += "\nHora: " + tabla.getString(4);
                consulta += "\nPrecio: " + tabla.getString(5);  
                consulta += "\n";
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
    
    
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
}
