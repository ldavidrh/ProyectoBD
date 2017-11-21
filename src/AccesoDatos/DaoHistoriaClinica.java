/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import java.sql.*;
import Modelo.HistoriaClinica;
/**
 *
 * @author User
 */
public class DaoHistoriaClinica {
    FachadaBD fachada;

    public DaoHistoriaClinica() {
        fachada = new FachadaBD();
    }
    
    public String guardarHistoria(HistoriaClinica h){
        String sql_guardar;
        sql_guardar = "INSERT INTO historia_clinica VALUES('" + h.getNum_historia() +
                      "', '" + h.getFecha_apertura() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)>0){
                return "Historia clínica creada correctamente";
            }else{
                return "No se realizó la acción: 0 filas afectadas";
            }
        }
        catch(SQLException e){
            System.out.println(e);
            return "Ya existe una historia clínica con ese número en el hospital";
        }
        catch(Exception e){ 
            System.out.println(e); 
            return "Ha ocurrido un error al crear la historia clínica";
        }        
    }
    
    public ResultSet consultarHistoria(String num){
        String sql_select;        
        sql_select = "SELECT * FROM historia_clinica WHERE num_historia = '" + num + "'";
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
    
    public String modificarHistoria(HistoriaClinica h){
        String sql_modificar;
        sql_modificar = "UPDATE historia_clinica SET fecha_apertura = '" + h.getFecha_apertura() +
                        "' WHERE num_historia = '" + h.getNum_historia() + "'";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_modificar)>0){
                return "Historia clínica modificada exitosamente";
            }else{
                return "No existe una historia clínica con ese número";
            }            
        }catch(Exception e){
            System.out.println(e);
            return "Ha ocurrido un error al modificar la historia clínica";
        }
    }
    
    public String eliminarHistoria(String num){
        String sql_delete;
        sql_delete = "DELETE FROM historia_clinica WHERE num_historia = '" + num + "'";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_delete)>0){
                return "Historia clínica eliminada exitosamente";
            }else{
                return "No se eliminó la historia clínica";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar la historia clínica";
        }                             
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
}