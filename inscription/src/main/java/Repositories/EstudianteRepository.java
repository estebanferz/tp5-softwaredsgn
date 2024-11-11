package Repositories;

import Helpers.CriterioBusqueda;
import Helpers.CriterioOrdenamiento;
import Modelos.Estudiante;

import java.util.List;

public interface EstudianteRepository extends GenericRepository<Estudiante, Integer> {
    List<Estudiante> findByCriterio(CriterioBusqueda criterioBusqueda);
    List<Estudiante> findOrdenadoByCriterio(CriterioOrdenamiento criterioOrdenamiento);

}
