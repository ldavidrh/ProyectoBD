/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Medicamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
/**
 *
 * @author Luis
 */
public class DaoMedicamento {
    FachadaBD fachada;
    public DaoMedicamento(){
        fachada = new FachadaBD();
    }
    
    public String guardarMedicamento(Medicamento m) {
        String sql_guardar;
        sql_guardar = "INSERT INTO medicamento VALUES('" + m.getCodigo_medicamento() + "', '" + 
                       m.getNombre() + "', '" + m.getDescripcion() + "', '" + m.getCosto() + "', '1');";
        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.executeUpdate(sql_guardar)==1) {
                return "Medicamento guardado exitosamente";
            } else {
                return "No se pudo guardar el medicamento";
            }
        } catch(SQLException ex){
            System.out.println(ex);
            return "Ya existe un medicamento con ese código";
        }
        catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al registrar el medicamento";
        }     
    }

    public String[] consultarMedicamento(String codigo_medicamento) {
        String sql_consultar;
        String[] consulta = new String[5];

        sql_consultar = "SELECT * FROM medicamento WHERE codigo_medicamento = '" + 
                        codigo_medicamento + "';";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);

            if (tabla.next()) {
                consulta[0] = tabla.getString(1);
                consulta[1] = tabla.getString(2);
                consulta[2] = tabla.getString(3);
                consulta[3] = tabla.getString(4);
                consulta[4] = "";
                
                if(tabla.getString(5).equals("0")){
                    consulta[4] = "\nMedicamento descontinuado";
                }
            } else {
                consulta = null;
            }
            return consulta;
        } catch (SQLException e) {
            System.out.print(e);
            return null;
        }

    }

    public String modificarMedicamento(Medicamento m) {
        String sql_modificar;
        sql_modificar = "UPDATE medicamento SET nombre='" + m.getNombre() + "', descripcion ='"
                + m.getDescripcion() + "', costo = '" + m.getCosto() + "', existe = '" + m.getExiste() + "'"
                + " WHERE codigo_medicamento = '" + m.getCodigo_medicamento() + "'";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if (sentencia.executeUpdate(sql_modificar)==1) {
                return "Medicamento modificado exitosamente";
            } else {
                return "No existe un Medicamento con ese codigo";
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return "Ha ocurrido un error al modificar el Medicamento";
        }
    }
    
    public ArrayList listarMedicamentos(){
     String sql_listar;
        ArrayList listar = new ArrayList();
        sql_listar = "SELECT codigo_medicamento FROM medicamento;" ;
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_listar);

            
            while (tabla.next()) {
                listar.add(tabla.getString(1));
                System.out.println((String)tabla.getString(1));
            }
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            return listar; 
    }

    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
    
    
}
