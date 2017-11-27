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

    public DaoAgenda() {
        fachada = new FachadaBD();
    }

    public String guardarAgenda(Agenda agenda) {
        String sql_guardar;
        sql_guardar = "INSERT INTO agenda VALUES('" + agenda.getId_medico()+ "', '" + agenda.getFecha() + "', '" + agenda.getHora() + "', '" + agenda.getDisponibilidad() + "');";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.execute(sql_guardar)) {
                return "Agenda guardada exitosamente";
            } else {
                return "No se pudo guardar la agenda";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgenda.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al guardar la agenda";
        }catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al crear la agenda";
        } 
    }

    public String[] consultarAgenda(String id_medico) {
        String sql_consultar;
        String[] consulta = new String[4];

        sql_consultar = "SELECT * FROM agenda WHERE num_agenda = '" + id_medico + "';";

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

    public String modificarAgenda(Agenda a) {
        String sql_modificar;
        sql_modificar = "UPDATE agenda SET fecha ='" + a.getFecha() + "', hora ='"
                + a.getHora() + "', disponibilidad = '" + a.getDisponibilidad() + "';";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if (sentencia.execute(sql_modificar)) {
                return "Agenda modificada exitosamente";
            } else {
                return "No existe una agenda con ese numero";
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return "Ha ocurrido un error al modificar la agenda";
        }

    }

    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }

}
