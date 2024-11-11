package Modelos;

import java.io.Serializable;
import java.util.Objects;

public class InscripcionId implements Serializable {
    private int inscripcion_id_estudiante;
    private int inscripcion_id_carrera;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscripcionId that = (InscripcionId) o;
        return Objects.equals(this.inscripcion_id_estudiante, that.getInscripcion_id_estudiante()) &&
                Objects.equals(this.inscripcion_id_carrera, that.getInscripcion_id_estudiante());
    }

    public int hashCode(){
        return Objects.hash(this.inscripcion_id_carrera, this.inscripcion_id_estudiante);
    }
    public int getInscripcion_id_estudiante() {
        return inscripcion_id_estudiante;
    }

    public int getInscripcion_id_carrera() {
        return inscripcion_id_carrera;
    }
}
