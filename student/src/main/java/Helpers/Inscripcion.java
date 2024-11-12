package Helpers;

import jakarta.persistence.*;

import java.util.Date;

public class Inscripcion {

    private Date fecha_inscripcion;
    private Date fecha_graduacion;
    private int inscripcion_id_estudiante;
    private int inscripcion_id_carrera;

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
