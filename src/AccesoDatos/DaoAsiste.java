/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Asiste;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author juandavid
 */
public class DaoAsiste {
    FachadaBD fachada;
    
    public DaoAsiste(){
        fachada = new FachadaBD();
    }
    
    public String guardarAsiste(Asiste a){
        String sql_guardar;
        sql_guardar = "INSERT INTO asiste VALUES('" + a.getId_persona() + "', '" +
                      a.getCodigo_campana() + "', '0')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Asistencia registrada";
            }else{
                return "Error: No se insertó la asistencia";
            }
        }
        catch(SQLException e){
            System.out.println(e);
            return "Ya se registró la asistencia de ese paciente a la campaña";
        }
        catch(Exception e){ 
            System.out.println(e); 
            return "Error: No se insertó la asistencia";
        }        
    }    
    
    public String consultarAsistencia(String cod_campana) {
        String sql_select;
        String consulta = "";
        sql_select = "SELECT id_persona FROM asiste WHERE codigo_campana = '" + cod_campana + "'";
                
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
                consulta += tabla.getString(1);
                consulta += "\n";
            }           
            return consulta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public int generarPrecioCita(String id_paciente){   
        Double precio = 30000 - (0.1 * this.cantidadAsistencias(id_paciente))*30000;
        Integer total = precio.intValue();
        return total;        
    }
    
    public int cantidadAsistencias(String id_paciente){
        String sql_select;     
        int cantidad = 0;
        sql_select = "SELECT COUNT(*) FROM asiste WHERE id_persona = '" + id_paciente + "'";
                
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while(tabla.next()){
                cantidad = Integer.parseInt(tabla.getString(1));                
            }           
            return cantidad;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
}
