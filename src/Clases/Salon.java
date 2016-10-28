/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jarvs
 */
@XmlRootElement
public class Salon {
    
    private String Descripcion;
    private int Capacidad;
    private int  No;
    private Alumnos[] alumnos;
 

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int No) {
        this.No = No;
    }

    public Alumnos[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumnos[] alumnos) {
        this.alumnos = alumnos;
    }
    
    
    
    
    
}
