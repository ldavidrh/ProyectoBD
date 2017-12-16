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
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Historia clínica creada correctamente";
            }else{
                return "Error: No se insertó la historia médica";
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
    
    public String[] consultarHistoria(String num){
        String sql_select;       
        String consulta[] = new String[2];
        sql_select = "SELECT * FROM historia_clinica WHERE num_historia = '" + num + "'";
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
    
    public String modificarHistoria(HistoriaClinica h){
        String sql_modificar;
        sql_modificar = "UPDATE historia_clinica SET fecha_apertura = '" + h.getFecha_apertura() +
                        "' WHERE num_historia = '" + h.getNum_historia() + "'";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_modificar)==1){
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
            if(sentencia.executeUpdate(sql_delete)==1){
                return "Historia clínica eliminada exitosamente";
            }else{
                return "No se eliminó la historia clínica";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar la historia clínica";
        }                             
    }
    
    public String obtenerCausas(String codigo_registro){
        String sql_consultar;
        String causas = "";
        sql_consultar = "SELECT codigo_causa FROM causas_registro WHERE id_registro = '" + codigo_registro + "';";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            while(tabla.next()){
                causas =  causas +
                        (String)tabla.getString(1) + ", ";
            }
            System.out.println(causas);
            return causas;
            
        
        } catch (SQLException e) {
            System.out.print(e);
            return null;
        }
    }
    
        public String listarRegistros(String num_historia){
            String sql_listar;
            String listar = "";
            sql_listar = "SELECT * FROM registro WHERE num_historia='"+ num_historia +"';" ;
            try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_listar);

            
            while (tabla.next()) {
               listar = listar +
                       "Registro: " + tabla.getString(1) + "\n"+
                       "Historia Clinica : " + tabla.getString(2) + "\n"+
                       "Cedula medico: " + tabla.getString(3) + "\n"+
                       "Fecha: " + tabla.getString(4) + "\n" +
                       "Causas: " + obtenerCausas((String)tabla.getString(1)) + "\n" + 
                       "*****************************" + "\n";
            }
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            return listar;
        }
        
        
        
        
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
}