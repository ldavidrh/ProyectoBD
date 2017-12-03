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
import java.util.ArrayList;
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
            if (sentencia.executeUpdate(sql_guardar) == 1) {
                return "Cama guardada exitosamente";
            } else {
                return "No se pudo guardar la cama";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            if (verificarExistencia(cama.getNum_cama())) {
                return "Ya existe una cama con ese número";
            }
            return "Error: no existe un área con el código " + cama.getNum_cama() + " en el hospital";
        } catch (Exception ex) {
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
            if (sentencia.executeUpdate(sql_eliminar) == 1) {
                return "Cama eliminada existosamente";
            } else {
                return "No existe una cama con el numero " + num_cama;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "Error al eliminar cama";
        }
    }

    public String modificarCama(String num_cama, String descripcion, String codigo_area) {
        String sql_modificar;
        sql_modificar = "UPDATE cama SET descripcion ='" + descripcion + "', codigo_area ='"
                       + codigo_area + "' WHERE num_cama = '" + num_cama + "';";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if (sentencia.executeUpdate(sql_modificar) == 1) {
                return "Cama modificada exitosamente";
            } else {
                return "No existe una cama con ese numero";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return "Error: no existe un área con ese código en el hospital";
        } catch (Exception ex) {
            System.out.println(ex);
            return "Ha ocurrido un error al modificar la cama";
        }
    }

    public boolean verificarExistencia(String num) {
        String sql_select;
        sql_select = "SELECT * FROM cama WHERE num_cama = '" + num + "'";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            return tabla.next();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public void eliminarArea(String cod) {
        String sql = "UPDATE cama SET codigo_area = NULL WHERE codigo_area = '" + cod + "'";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            sentencia.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void modificarEstado(String num_cama, String estado){
        String sql = "UPDATE cama SET estado = '" + estado + "' WHERE num_cama = '" + num_cama + "'";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            sentencia.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    //-recibe un arraylist con los números de las camas que quedan libres hoy para
    //-llamar al método modificarEstado que las setée de ocupadas a libres. SE
    //-LLAMA DESDE HiloCamas
    public void camasHilo(ArrayList camas_libres_hoy) {
        for (int i = 0; i < camas_libres_hoy.size(); i++) {
            this.modificarEstado((String) camas_libres_hoy.get(i), "Libre");
        }
    }
            
    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }

}
