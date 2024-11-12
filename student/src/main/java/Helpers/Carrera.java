package Helpers;

import jakarta.persistence.*;

import java.util.Set;

public class Carrera {

    private int id;
    private String nombre;

    public Carrera() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carrera[" +
                "id=" + id +
                ", nombre='" + nombre +
                "]\n";
    }
}
