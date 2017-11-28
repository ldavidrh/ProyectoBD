/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Asignada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juandavid
 */
public class DaoAsignada {
    FachadaBD fachada;

    public DaoAsignada() {
        fachada = new FachadaBD();
    }

    public String guardarAsignada(Asignada asignada) {
        String sql_guardar;
        sql_guardar = "INSERT INTO asignada VALUES('" + asignada.getId_persona() + "', '" + asignada.getNum_cama() + "', '" 
                + asignada.getFecha_asignacion() + "', '" + asignada.getFecha_finalizacion() + "');";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.execute(sql_guardar)) {
                return "Asignación exitosa";
            } else {
                return "No se pudo asignar";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgenda.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al asignar";
        }catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al asignar";
        }
    }
    
    
    
    
    public String[] consultarAsignada(String num_cama) {
        String sql_consultar;
        String[] consulta = new String[4];

        sql_consultar = "SELECT * FROM asignada WHERE num_cama = '" + num_cama + "';";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);

            if (tabla.next()) {
                consulta[0] = tabla.getString(1);
                consulta[1] = tabla.getString(2);
                consulta[2] = tabla.getString(3);
                consulta[3] = tabla.getString(4);
            } else {
                consulta = null;
            }
            return consulta;
        } catch (SQLException e) {
            System.out.print(e);
            return null;
        }

    }

    public String eliminarAsignada(String num_cama) {
        String sql_eliminar;
        sql_eliminar = "DELETE FROM asignada WHERE num_cama = '" + num_cama + "';";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.execute(sql_eliminar)) {
                return "asignada eliminada existosa";
            } else {
                return "No existe una cama asiganada con el numero: " + num_cama;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgenda.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al eliminar asignada";
        }
    }

    public String modificarAsignada(Asignada asignada) {
        String sql_modificar;
        sql_modificar = "UPDATE asignada SET id_persona ='" + asignada.getId_persona() + "', fecha_entrada ='"
                + asignada.getFecha_asignacion() + "', fecha_salida='" + asignada.getFecha_finalizacion() + "' WHERE num_cama = '" + asignada.getNum_cama() + "';";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if (sentencia.execute(sql_modificar)) {
                return "asignada modificada exitosamente";
            } else {
                return "No existe una cama asiganada con el numero: " + asignada.getNum_cama();
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return "Ha ocurrido un error al modificar la asignada";
        }

    }

    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
}
