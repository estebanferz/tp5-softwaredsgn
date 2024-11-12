package Helpers;

import jakarta.persistence.*;

import java.util.Set;

public class Estudiante {
    
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private char genero;
    private int dni;
    private String ciudad;
    private int libreta;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, int edad, char genero, int dni, String ciudad, int libreta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.ciudad = ciudad;
        this.libreta = libreta;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getLibreta() {
        return libreta;
    }

    public void setLibreta(int libreta) {
        this.libreta = libreta;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero=" + genero +
                ", dni=" + dni +
                ", ciudad='" + ciudad + '\'' +
                ", libreta=" + libreta +
                "}\n";
    }
}
