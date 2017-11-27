/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Empleado;
import java.sql.*;
/**
 *
 * @author User
 */
public class DaoEmpleado {
    FachadaBD fachada;
    public DaoEmpleado(){
        fachada= new FachadaBD();
    }
    
    public String guardarEmpleado(Empleado e){
        String sql_guardar;
        sql_guardar = "INSERT INTO empleado VALUES('" + e.getId_persona() + "', '" +
                      e.getCargo() + "', '" + e.getSalario() + "', '" + e.getEmail() + 
                      "', '" + e.getCodigo_area() + "', '" + e.getId_jefe() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Empleado creado correctamente";
            }else{
                return "Error: No se insertó el empleado";
            }
        }catch(SQLException ex){
            System.out.println(ex);
            return "Ha ocurrido un error: " + ex.getMessage();
        }
        catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al crear el empleado";
        }        
    }
    
    public String[] consultarEmpleado(String id){
        String sql_select;        
        String consulta[] = new String[6];
        sql_select = "SELECT * FROM empleado WHERE id_persona = '" + id + "'";
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
                consulta[5] = tabla.getString(6);                
            }else{
                consulta = null;
            }
            return consulta;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public String modificarEmpleado(Empleado e){
        String sql_modificar;
        sql_modificar = "UPDATE empleado SET cargo ='" + e.getCargo() + "', salario ='" +
                        e.getSalario() + "', email = '" + e.getEmail() + "', codigo_area ='" +
                        e.getCodigo_area() + "', id_jefe ='" + e.getId_jefe() +
                        "' WHERE id_persona = '" + e.getId_persona() + "'";
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
    
    public String eliminarEmpleado(String id){
        String sql_delete;
        sql_delete = "DELETE FROM empleado WHERE id_persona = '" + id + "'";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_delete)==1){
                return "Empleado eliminado exitosamente";
            }else{
                return "No se eliminó el empleado";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar el empleado";
        }                             
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
}