/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControlAsignada;
import Controlador.ControlCama;
import static java.lang.Thread.sleep;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class HiloCamas extends Thread {
    private ControlAsignada controlAsignada;
    private ControlCama controlCama;
    
    public HiloCamas(ControlAsignada controlAsignada, ControlCama controlCama){
        this.controlAsignada = controlAsignada;
        this.controlCama = controlCama;
    }
    
    @Override
    public void run(){
        do{
            try{                
                ArrayList camas_libres_hoy = controlAsignada.verficarFechaSalida();
                if(camas_libres_hoy!=null){
                    controlCama.camasHilo(camas_libres_hoy);
                }
                System.out.println("hilo ejecutándose");
                sleep(24*3600000);
                //sleep(60000);
            }catch (InterruptedException ex) {
                System.out.println("Error en la ejecución del HiloCamas encargado de revisar la fecha de salida de los pacientes");
            }
        }while(isAlive());
    }
}