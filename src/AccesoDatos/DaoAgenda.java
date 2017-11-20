/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Agenda;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luis
 */
public class DaoAgenda {
    FachadaBD fachada;
    public DaoAgenda(){
        fachada = new FachadaBD();
    }
    
    public int guardarAgenda(Agenda agenda){
        String sql_guardar;
        sql_guardar = "INSERT INTO agenda VALUES('"+agenda.getNum_agenda()+"', '"+agenda.getFecha()+"', '"+agenda.getHora()+"', '"+agenda.getDisponibilidad()+"');";
        
        try{
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            return numFilas;
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public ResultSet consultarAgenda(String num_agenda) throws SQLException{
        String sql_consultar;
        sql_consultar = "SELECT * FROM agenda WHERE num_agenda = '" + num_agenda+"';";
        
        try{
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            ResultSet query = sentencia.executeQuery(sql_consultar);
            return query;
        }catch(Exception e){
            System.out.print(e);
        }
        return null;
    }
}
