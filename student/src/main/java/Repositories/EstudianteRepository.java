package Repositories;

import Helpers.CriterioBusqueda;
import Helpers.CriterioOrdenamiento;
import Modelos.Estudiante;

import java.util.List;

public interface EstudianteRepository extends GenericRepository<Estudiante, Integer> {
    
    List<Estudiante> find();
    List<Estudiante> findByCriterio(CriterioBusqueda criterioBusqueda);
    List<Estudiante> findOrdenadoByCriterio(CriterioOrdenamiento criterioOrdenamiento);
    public void postEstudiante(Estudiante estudiante);

}
