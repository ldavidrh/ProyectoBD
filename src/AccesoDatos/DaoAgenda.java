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

    public String consultarAgendaLibres(String id_medico, String fecha) {
        ArrayList horasLibres = this.consultarAgenda(id_medico, fecha);
        ArrayList horasDeTrabajo = this.horasDisponibles();
        horasDeTrabajo.add("17:00:00");       
        String msj = "";
        for (int i = 0; i < 16; i++) {
            msj += "\n" + (String) horasDeTrabajo.get(i) + " - " + (String) horasDeTrabajo.get(i + 1);
            for(int j=0; j<horasLibres.size(); j++){
                if(horasDeTrabajo.get(i).equals(horasLibres.get(j))){
                    msj += ": Libre";
                } 
            }           
        }        
        return msj;
    }
    
    public String consultaAgendaMensual(String id_medico, String fecha){
        String libres = this.consultarAgendaLibres(id_medico, fecha);
        String[] linea = libres.split("\n");
        String mensaje = "";
        
        for(int i=1; i<17; i++){
            if(!linea[i].contains("Libre")){                
                linea[i] += ": Ocupado";
            }            
            mensaje += "\n" + linea[i];
        } 
        return mensaje;        
    }
    
    public String eliminarCita(String id_medico, String fecha, String hora){
        String sql_delete;
        sql_delete = "DELETE FROM agenda WHERE id_medico = '" + id_medico + "' AND fecha = '" + fecha + 
                     "' AND hora_inicio = '" + hora + "'";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if (sentencia.executeUpdate(sql_delete) == 1) {
                return "Cita eliminada exitosamente de agenda médico";
            } else {
                return "No existe ese registro en la agenda del médico";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "Ocurrió un problema al eliminar la cita en la agenda del médico";
        }
    }

    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }

}
