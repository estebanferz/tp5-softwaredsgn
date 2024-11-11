package Modelos;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "carrera")
public class Carrera {
    @Id
    @Column(name = "id_carrera")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "carrera")
    private Set<Inscripcion> inscripciones;

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
