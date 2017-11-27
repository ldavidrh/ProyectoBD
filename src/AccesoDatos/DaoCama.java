/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Cama;
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
public class DaoCama {
    FachadaBD fachada;

    public DaoCama() {
        fachada = new FachadaBD();
    }

    public String guardarCama(Cama cama) {
        String sql_guardar;
        sql_guardar = "INSERT INTO cama VALUES('" + cama.getNum_cama() + "', '" + cama.getDescripcion() + "', '" 
                + cama.getCodigo_area() + "', '" + cama.getEstado() + "');";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.execute(sql_guardar)) {
                return "Cama guardada exitosamente";
            } else {
                return "No se pudo guardar la cama";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgenda.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al guardar la cama";
        }catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al crear la cama";
        }
    }
    
    
    
    
    public String[] consultarCama(String num_cama) {
        String sql_consultar;
        String[] consulta = new String[4];

        sql_consultar = "SELECT * FROM cama WHERE num_cama = '" + num_cama + "';";

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

    public String eliminarCama(String num_cama) {
        String sql_eliminar;
        sql_eliminar = "DELETE FROM cama WHERE num_cama = '" + num_cama + "';";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.execute(sql_eliminar)) {
                return "Cama eliminada existosa";
            } else {
                return "No existe una cama con el numero: " + num_cama;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgenda.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al eliminar cama";
        }
    }

    public String modificarCama(Cama cama) {
        String sql_modificar;
        sql_modificar = "UPDATE cama SET descripcion ='" + cama.getDescripcion() + "', codigo_area ='"
                + cama.getCodigo_area() + "', estado='" + cama.getEstado() + "' WHERE num_cama = '" + cama.getNum_cama() + "';";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if (sentencia.execute(sql_modificar)) {
                return "Cama modificada exitosamente";
            } else {
                return "No existe una cama con ese numero";
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return "Ha ocurrido un error al modificar la cama";
        }

    }

    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
    
}
