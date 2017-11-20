/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import java.sql.*;
import Modelo.Persona;
/**
 *
 * @author User
 */
public class DaoPersona {
    FachadaBD fachada;
    
    public DaoPersona(){
        fachada = new FachadaBD();
    }
    
    public String guardarPersona(Persona p){
        String sql_guardar;
        sql_guardar = "INSERT INTO persona VALUES('" + p.getId_persona() + "', '" +
                      p.getNombre() + "', '" + p.getDireccion() + "', '" + p.getTelefono() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)>0){
                return "Persona insertada correctamente";
            }else{
                return "No se realizó la acción: 0 filas afectadas";
            }
        }
        catch(SQLException e){
            System.out.println(e);
            return "Ya existe una persona con ese id, registrada en el hospital";
        }
        catch(Exception e){ 
            System.out.println(e); 
            return "Ha ocurrido un error al insertar la persona";
        }        
    }
    
    public String[] consultarPersona(String id){
        String sql_select;
        String respuesta[] = new String[4];
        sql_select = "SELECT * FROM persona WHERE id_persona = '" + id + "'";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                respuesta[0] = tabla.getString(1);
                respuesta[1] = tabla.getString(2);
                respuesta[2] = tabla.getString(3);
                respuesta[3] = tabla.getString(4);
            }
            return respuesta;
        }catch(Exception e){
            respuesta[0] = "EXCEPCION";
            respuesta[1] = "Ha ocurrido un error al consultar en la tabla persona:\n";
            respuesta[2]=e.getMessage();
            return respuesta;
        }
    }
    
    public String modificarPersona(Persona p){
        String sql_modificar;
        sql_modificar = "UPDATE persona SET nombre ='" + p.getNombre() + "', direccion ='" +
                        p.getDireccion() + "', telefono = '" + p.getTelefono() + 
                        "' WHERE id_persona = '" + p.getId_persona() + "'";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_modificar)>0){
                return "Persona modificada exitosamente";
            }else{
                return "No existe una persona con ese id";
            }            
        }catch(Exception e){
            System.out.println(e);
            return "Ha ocurrido un error al modificar la persona";
        }
    }
    
    public String borrarPaciente(String id){
        String sql_delete;
        sql_delete = "DELETE FROM persona WHERE id_persona = '" + id + "'";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_delete)>0){
                return "Persona eliminada exitosamente";
            }else{
                return "No se eliminó la persona";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar la persona";
        }                             
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }    
}
