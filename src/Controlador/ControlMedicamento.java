/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoMedicamento;
import Modelo.Medicamento;

/**
 *
 * @author Luis
 */
public class ControlMedicamento {

    DaoMedicamento daoMedicamento;

    public ControlMedicamento() {
        daoMedicamento = new DaoMedicamento();
    }

    public String insertarMedicamento(String codigo_medicamento, String nombre, String descripcion, float costo) {
        Medicamento m = new Medicamento(codigo_medicamento, nombre, descripcion, costo);
        return daoMedicamento.guardarMedicamento(m);
    }

    public String[] consultarMedicamento(String codigo_medicamento) {
        return daoMedicamento.consultarMedicamento(codigo_medicamento);
    }

    public String modificarMedicamento(String codigo_medicamento, String nombre, String descripcion, float costo) {
        Medicamento m = new Medicamento(codigo_medicamento, nombre, descripcion, costo);
        return daoMedicamento.modificarMedicamento(m);
    }

    public String eliminarMedicamento(String num_Medicamento) {
        return daoMedicamento.eliminarMedicamento(num_Medicamento);
    }

    public void cerrarConexionBD() {
        daoMedicamento.cerrarConexionBD();
    }
}
