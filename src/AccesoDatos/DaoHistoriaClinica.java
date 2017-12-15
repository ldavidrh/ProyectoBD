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
    
        public String listarRegistros(String num_historia){
            String sql_listarHistoria;
            String sql_listarRegistro;
            String sql_listarCausa;
            String sql_listarMedico;
            String listar = "";
            sql_listarHistoria = "SELECT * FROM historia_clinica WHERE num_historia='"+ num_historia +"';" ;
            sql_listarRegistro = "SELECT codigo_causa,id_persona,fecha FROM registro WHERE num_historia='"+ num_historia +"';" ;
            
            
            try {
                Connection conn = fachada.getConnetion();
                Statement sentencia = conn.createStatement();
                ResultSet tablaHistoria = sentencia.executeQuery(sql_listarHistoria);
                Connection conn1 = fachada.getConnetion();
                Statement sentencia1 = conn1.createStatement();
                ResultSet tablaRegistro = sentencia.executeQuery(sql_listarRegistro);
                sql_listarCausa = "SELECT * FROM causa WHERE codigo_causa='"+ (String)tablaRegistro.getString(1)+"';" ;
                sql_listarMedico = "SELECT * FROM persona WHERE id_persona='"+ (String)tablaRegistro.getString(2)+"';" ;
                Connection conn2 = fachada.getConnetion();
                Statement sentencia2 = conn2.createStatement();
                ResultSet tablaCausa = sentencia.executeQuery(sql_listarCausa);
                Connection conn3 = fachada.getConnetion();
                Statement sentencia3 = conn3.createStatement();
                ResultSet tablaMedico = sentencia.executeQuery(sql_listarMedico);
                tablaHistoria.next();
                
                if(tablaHistoria.next()){
                     listar  = listar +
                           "Historia clinica: " + tablaHistoria.getString(1) + "\n"+
                           "Fecha de apertura: " + tablaHistoria.getString(2);
                }
                


                while (tablaRegistro.next()) {
                    if(tablaCausa.next()){
                        listar  = listar +
                           "Codigo de la causa: " + tablaCausa.getString(1) + "\n"+
                           "Nombre de la causa: " + tablaCausa.getString(2) + "\n"+
                           "Descripción de la causa: " + tablaCausa.getString(3);
                    }
                    if(tablaMedico.next()){
                        listar  = listar +
                           "Codigo del medico: " + tablaMedico.getString(1) + "\n"+
                           "Nombre del medico: " + tablaMedico.getString(2); 
                    }
                    
                   listar  = listar +
                           "Fecha: " + tablaRegistro.getString(3);
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