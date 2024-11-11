package Repositories;

import Modelos.Carrera;
import Modelos.Estudiante;
import Modelos.Inscripcion;

import java.util.List;
import java.util.Date;
import Helpers.CriterioOrdenamiento;

public interface InscripcionRepository extends GenericRepository<Inscripcion, Integer> {
    void matricular(Estudiante estudiante, Carrera carrera);
    void setFechaGrauacion(Estudiante estudiante, Carrera carrera, Date fecha_graduacion);
    Inscripcion findById(int id_carrera, int id_estudiante);
    List<Inscripcion> getAllCarrerasOrdenadas(CriterioOrdenamiento crit);



}
