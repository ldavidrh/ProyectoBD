/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Cita;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class DaoCita {

    FachadaBD fachada;

    public DaoCita() {
        fachada = new FachadaBD();
    }

    public String guardarCita(Cita c) {
        String sql_guardar;
        sql_guardar = "INSERT INTO cita VALUES('" + c.getId_medico() + "', '"
                + c.getId_paciente() + "', '" + c.getFecha() + "', '" + c.getHora()
                + "', '" + c.getPrecio() + "', '0')";
        try {
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            if (sentencia.executeUpdate(sql_guardar) == 1) {
                return "Cita creada exitosamente";
            } else {
                return "Error: No se creó la cita";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return "Ha ocurrido un error: " + ex.getMessage();
        } catch (Exception ex) {
            System.out.println(ex);
            return "Ha ocurrido un error al crear la cita";
        }
    }

    public String consultarCita(String id_paciente) {
        String sql_select;
        String consulta = "-------------------------------------------------\n";
        sql_select = "SELECT id_medico , fecha , hora, precio, completada FROM cita WHERE id_paciente='" + id_paciente + "';";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
                consulta += "Fecha: " + (String) tabla.getString(2)
                        + "\nMédico: " + (String) tabla.getString(1)
                        + "\nHora: " + (String) tabla.getString(3)
                        + "\nPrecio: " + (String) tabla.getString(4);
                if(tabla.getString(5).equals("0")){
                    consulta += "\nAsistida: no";
                }else{
                    consulta += "\nAsistida: sí";
                }
                consulta += "\n-------------------------------------------------\n\n";
            }
            return consulta;
        } catch (Exception e) {
            System.out.println(e);
            return "Ha ocurido un error al consultar la cita";
        }
    }

    public String modificarCita(String id_fecha_n, String hora_n, String id_fecha_v, String hora_v, String id_paciente) {
        String sql_modificar;
        sql_modificar = "UPDATE cita SET fecha ='" + id_fecha_n + "', hora = '" + hora_n
                + "' WHERE id_paciente = '" + id_paciente + "' and hora='" + hora_v + "' and fecha='" + id_fecha_v + "';";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if (sentencia.executeUpdate(sql_modificar) == 1) {
                return "Cita modificada correctamente";
            } else {
                return "No existe una cita";
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return "Ha ocurrido un error al modificar la cita";
        }
    }

    public ArrayList listarCitasPaciente(String id_paciente) {
        String sql_listar;
        ArrayList listar = new ArrayList();
        sql_listar = "SELECT id_medico , fecha , hora FROM cita WHERE id_paciente='" + id_paciente + "';";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_listar);

            while (tabla.next()) {
                listar.add("ID médico =" + (tabla.getString(1))
                        + ".  fecha =" + (tabla.getString(2))
                        + ".  hora =" + (tabla.getString(3))
                );

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listar;
    }
    
    public ArrayList listarCitasMedico(String id_paciente, String id_medico) {
        String sql_listar;
        ArrayList listar = new ArrayList();
        sql_listar = "SELECT fecha, hora FROM cita WHERE id_paciente= '" + id_paciente + "' AND id_medico= '" + id_medico + "' AND completada = '0'";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_listar);

            while (tabla.next()) {
                listar.add("Fecha: " + (tabla.getString(1))
                        + "; Hora: " + (tabla.getString(2)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listar;
    }

    public String eliminarCita(String id_medico, String id_paciente, String fecha, String hora) {
        String sql_delete;
        sql_delete = "DELETE FROM cita WHERE id_medico ='" + id_medico + "'"
                + " and id_paciente ='" + id_paciente + "'"
                + " and fecha='" + fecha + "'"
                + " and hora='" + hora + "';";

        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if (sentencia.executeUpdate(sql_delete) == 1) {
                return "Cita eliminada exitosamente";
            } else {
                return "No se eliminó la cita";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "Ocurrió un problema al eliminar la cita";
        }
    }

    public boolean registrarAsistencia(String id_medico, String id_paciente, String fecha, String hora) {
        String sql_modificar;
        sql_modificar = "UPDATE cita SET completada ='1' WHERE id_medico = '" + id_medico
                + "' AND id_paciente = '" + id_paciente + "' AND fecha = '" + fecha + "' AND hora = '" + hora + "';";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if (sentencia.executeUpdate(sql_modificar) == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
}
