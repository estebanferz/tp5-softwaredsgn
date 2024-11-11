package Modelos;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @Column(name = "id_estudiante")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "genero", nullable = false)
    private char genero;

    @Column(name = "dni", nullable = false)
    private int dni;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "libreta", nullable = false)
    private int libreta;

    @OneToMany(mappedBy = "estudiante")
    private Set<Inscripcion> inscripciones;

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
