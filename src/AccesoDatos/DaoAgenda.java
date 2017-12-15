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

            while (tabla.next()) {
                for (int i = 0; i < consulta.size(); i++) {
                    if (consulta.get(i).equals(tabla.getString(1))) {
                        consulta.remove(i);
                    }
                }
            }
            return consulta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList horasDisponibles() {
        ArrayList horas = new ArrayList();

        horas.add("07:00:00");
        horas.add("07:30:00");
        horas.add("08:00:00");
        horas.add("08:30:00");
        horas.add("09:00:00");
        horas.add("09:30:00");
        horas.add("10:00:00");
        horas.add("10:30:00");
        horas.add("11:00:00");
        horas.add("11:30:00");
        horas.add("14:00:00");
        horas.add("14:30:00");
        horas.add("15:00:00");
        horas.add("15:30:00");
        horas.add("16:00:00");
        horas.add("16:30:00");

        return horas;
    }
/*
    public void consultarAgendaMensual(String id_medico, String fecha) {
        ArrayList horasOcupadas = this.consultarAgenda(id_medico, fecha);
        ArrayList horasDisponibles = this.horasDisponibles();
        String mensaje = "";
        for(int i=0; i<horasDisponibles.size(); i++){
           mensaje += (String)horasDisponibles.get(i) + (String)horasDisponibles.get(i+1);
           if((horasDisponibles.get(i).equals(i)))
        }
    }*/
        
    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }

}
