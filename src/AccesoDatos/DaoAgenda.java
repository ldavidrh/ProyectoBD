/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Agenda;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class DaoAgenda {

    FachadaBD fachada;

    public DaoAgenda() {
        fachada = new FachadaBD();
    }

    public String actualizarAgenda(Agenda agenda) {
        String sql_guardar;
        sql_guardar = "INSERT INTO agenda VALUES('" + agenda.getId_medico() + "', '" + agenda.getFecha() + "', '"
                + agenda.getHora_inicio() + "');";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.executeUpdate(sql_guardar) == 1) {
                return "Agenda actualizada exitosamente";
            } else {
                return "No se pudo actualizar la agenda";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return "El médico no está disponible a esa hora";
        } catch (Exception ex) {
            System.out.println(ex);
            return "Ha ocurrido un error al actualizar la agenda";
        }
    }

    public ArrayList consultarAgenda(String id_medico, String fecha) {
        String sql_select;
        ArrayList consulta = this.horasDisponibles();
        sql_select = "SELECT hora_inicio FROM agenda WHERE id_medico = '" + id_medico
                + "' AND fecha = '" + fecha + "'";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            if (tabla.next()) {
                while (tabla.next()) {
                    if (consulta.contains(tabla.getString(1))) {
                        consulta.remove(tabla.getString(1));
                    }
                }
            }else{
                return null;
            }
            return consulta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList horasDisponibles() {
        ArrayList horas = new ArrayList();

        horas.add("7:00");
        horas.add("7:30");
        horas.add("8:00");
        horas.add("8:30");
        horas.add("9:00");
        horas.add("9:30");
        horas.add("10:00");
        horas.add("10:30");
        horas.add("11:00");
        horas.add("11:30");
        horas.add("14:00");
        horas.add("14:30");
        horas.add("15:00");
        horas.add("15:30");
        horas.add("16:00");
        horas.add("16:30");

        return horas;
    }
    
    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }

}
