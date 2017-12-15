/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.*;
import Modelo.Area;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DaoArea {

    FachadaBD fachada;

    public DaoArea() {
        fachada = new FachadaBD();
    }

    public String guardarArea(Area a) {
        String sql_guardar;
        sql_guardar = "INSERT INTO area VALUES('" + a.getCodigo_area() + "', '"
                + a.getNombre() + "', '" + a.getDescripcion() + "')";
        try {
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            if (sentencia.executeUpdate(sql_guardar) == 1) {
                return "Área creada correctamente";
            } else {
                return "Error: No se insertó el área";
            }
        } catch (SQLException e) {
            System.out.println(e);
            return "Ya existe un área con ese código";
        } catch (Exception e) {
            System.out.println(e);
            return "Ha ocurrido un error al crear el área";
        }
    }

    public String[] consultarArea(String codigo) {
        String sql_select;
        String consulta[] = new String[3];
        sql_select = "SELECT * FROM area WHERE codigo_area = '" + codigo + "'";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            if (tabla.next()) {
                consulta[0] = tabla.getString(1);
                consulta[1] = tabla.getString(2);
                consulta[2] = tabla.getString(3);
            } else {
                consulta = null;
            }
            return consulta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String modificarArea(Area a) {
        String sql_modificar;
        sql_modificar = "UPDATE area SET nombre ='" + a.getNombre() + "', descripcion ='"
                + a.getDescripcion() + "' WHERE codigo_area = '" + a.getCodigo_area() + "'";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if (sentencia.executeUpdate(sql_modificar) == 1) {
                return "Área modificada exitosamente";
            } else {
                return "No existe un área con ese código";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "Ha ocurrido un error al modificar el área";
        }
    }

    public String eliminarArea(String codigo) {
        String sql_delete;
        sql_delete = "DELETE FROM area WHERE codigo_area = '" + codigo + "'";

        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if (sentencia.executeUpdate(sql_delete) == 1) {
                return "Área eliminada exitosamente";
            } else {
                return "No existe un área con ese código";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "Ocurrió un problema al eliminar el área";
        }
    }

    public ArrayList consultarEmpleadosPorArea(String codigo) {
        String sql_consultarEmpleadosArea;
        ArrayList consulta = new ArrayList();
        sql_consultarEmpleadosArea = "SELECT persona.id_persona, persona.nombre, area.nombre, cargo, salario FROM persona NATURAL JOIN empleado INNER JOIN area ON empleado.codigo_area = area.codigo_area"
                + " WHERE area.codigo_area = '" + codigo + "';";
        try {
            Connection con = fachada.getConnetion();
            Statement statement = con.createStatement();
            ResultSet tabla = statement.executeQuery(sql_consultarEmpleadosArea);
            if (tabla.next()) {
                consulta.add(tabla.getString(1));
                consulta.add(tabla.getString(2));
                consulta.add(tabla.getString(3));
                consulta.add(tabla.getString(4));
                consulta.add(tabla.getString(5));

                while (tabla.next()) {
                    consulta.add(tabla.getString(1));
                    consulta.add(tabla.getString(2));
                    consulta.add(tabla.getString(3));
                    consulta.add(tabla.getString(4));
                    consulta.add(tabla.getString(5));
                }

            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consulta;
    }

    public ArrayList cargarCodigosAreas() {
        ArrayList consulta = new ArrayList();
        String sql_consultarCodigosAreas;
        sql_consultarCodigosAreas = "SELECT DISTINCT codigo_area FROM area;";

        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultarCodigosAreas);
            if (tabla.next()) {
                consulta.add(tabla.getString(1));

                while (tabla.next()) {
                    consulta.add(tabla.getString(1));
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consulta;
    }

    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
}
