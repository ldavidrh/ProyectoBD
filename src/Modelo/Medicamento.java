/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author juandavid
 */
public class Medicamento {
    String codigo_medicamento;
    String nombre;
    String descripcion;
    float costo;
    char existe;

    public Medicamento(String codigo_medicamento, String nombre, String descripcion, float costo, char existe) {
        this.codigo_medicamento = codigo_medicamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.existe = existe;
    }

    public String getCodigo_medicamento() {
        return codigo_medicamento;
    }

    public void setCodigo_medicamento(String codigo_medicamento) {
        this.codigo_medicamento = codigo_medicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public char getExiste() {
        return existe;
    }
}
