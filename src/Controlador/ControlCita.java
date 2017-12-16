/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoCita;
import Modelo.Cita;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class ControlCita {

    DaoCita daoCita;

    public ControlCita() {
        this.daoCita = new DaoCita();
    }

    public String insertarCita(String id_medico, String id_paciente, String fecha, String hora, int precio) {
        Cita cita = new Cita(id_medico, id_paciente, fecha, hora, precio, '0');
        return daoCita.guardarCita(cita);
    }

    public ArrayList listarCitasPaciente(String id_paciente) {
        return daoCita.listarCitasPaciente(id_paciente);
    }
    
    public ArrayList listarCitasMedico(String id_paciente, String id_medico){
        return daoCita.listarCitasMedico(id_paciente, id_medico);
    }

    public String eliminarCita(String m, String p, String f, String h) {
        return daoCita.eliminarCita(m, p, f, h);
    }

    public String consultarCita(String id_paciente) {
        return daoCita.consultarCita(id_paciente);
    }

    public boolean registrarAsistencia(String id_medico, String id_paciente, String fecha, String hora) {
        return daoCita.registrarAsistencia(id_medico, id_paciente, fecha, hora);
    }

    public String modificarCita(String id_fecha_n, String hora_n, String id_fecha_v, String hora_v, String id_paciente) {
        return daoCita.modificarCita(id_fecha_n, hora_n, id_fecha_v, hora_v, id_paciente);
    }

}
