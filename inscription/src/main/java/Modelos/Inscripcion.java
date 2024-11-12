package Modelos;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "inscripcion")
@IdClass(InscripcionId.class)
public class Inscripcion {
    @Id
    @Column(name = "inscripcion_id_estudiante")
    private int inscripcion_id_estudiante;

    @Id
    @Column(name = "inscripcion_id_carrera")
    private int inscripcion_id_carrera;

    @Column(name = "fecha_inscripcion", nullable = false)
    private Date fecha_inscripcion;

    @Column(name = "fecha_graduacion", nullable = true)
    private Date fecha_graduacion;

    public Date getInscripcion(){
        return fecha_inscripcion;
    }

    public Date getGraduacion(){
        return fecha_graduacion;
    }

    public int getIdEstudiante(){
        return this.inscripcion_id_estudiante;
    }

    public int getIdCarrera(){
        return this.inscripcion_id_carrera;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "inscripcion_id_estudiante=" + inscripcion_id_estudiante +
                ", inscripcion_id_carrera=" + inscripcion_id_carrera +
                ", fecha_inscripcion=" + fecha_inscripcion +
                ", fecha_graduacion=" + fecha_graduacion +
                '}';
    }
}
