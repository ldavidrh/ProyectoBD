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
    
    public int guardarPaciente(Paciente pac){
        String sql_guardar;
        sql_guardar="INSERT INTO paciente(id_persona,num_historia,seguridad_social,fecha_nacimiento,actividad_economica) VALUES ('" +
                pac.getId_persona() + "', '" + pac.getNum_historia() +  "', '" +
                pac.getSeguridad_social() + "', '"  + pac.getFecha_nacimiento() +  "', '" +
                pac.getActividad_economica() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }//fin guardar

    public Paciente consultarPrograma(String id){
        Paciente pac= new Paciente();
        String sql_select;
        sql_select="SELECT codigo, nombre,nivel, num_creditos FROM  programa WHERE codigo='" + id +  "'";
         try{
            Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                pac.setId_persona(tabla.getString(1));
                pac.setNum_historia(tabla.getString(2));
                pac.setSeguridad_social(tabla.getString(3));
                pac.setFecha_nacimiento(tabla.getString(4));
                pac.setActividad_economica(tabla.getString(5));
              
              System.out.println("ok");
            }
           
            return pac;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public int modificarPaciente(Paciente pac){
        String sql_update;
        sql_update="UPDATE programa SET "
                + "num_historia='" + pac.getNum_historia() + "', seguridad_social='" 
                + pac.getSeguridad_social() + "', fecha_nacimiento='" + pac.getFecha_nacimiento()
                + "', actividad_economica='" + pac.getActividad_economica() + " WHERE codigo='" + pac.getId_persona() +  "'";
        
        System.out.println("sql = " + sql_update);
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            
            int numFilas = sentencia.executeUpdate(sql_update);
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }
    
   
    public boolean borrarPaciente(String id){
        String sql_borrar;
        sql_borrar="DELETE FROM  programa WHERE codigo='" + id +  "'";
        System.out.println("sql = " + sql_borrar);
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            
            int numFilas = sentencia.executeUpdate(sql_borrar);
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        return true;
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
    
}
