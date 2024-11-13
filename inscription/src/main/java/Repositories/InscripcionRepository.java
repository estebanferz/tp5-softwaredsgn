package Repositories;

import Helpers.Carrera;
import Helpers.CriterioBusqueda;
import Helpers.Estudiante;
import Modelos.Inscripcion;

import java.util.List;
import java.util.Date;
import Helpers.CriterioOrdenamiento;

public interface InscripcionRepository extends GenericRepository<Inscripcion, Integer> {
    void matricular(Estudiante estudiante, Carrera carrera);
    void matricular(int id_estudiante, Carrera carrera);
    void setFechaGraduacion(Estudiante estudiante, Carrera carrera, Date fecha_graduacion);
    Inscripcion findById(int id_carrera, int id_estudiante);
    List<Inscripcion> getAllCarrerasOrdenadas(CriterioOrdenamiento crit);
    List<Inscripcion> findByCriterio(CriterioBusqueda criterioBusqueda);
}
