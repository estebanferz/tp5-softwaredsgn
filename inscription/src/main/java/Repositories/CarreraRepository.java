package Repositories;

import Helpers.CriterioOrdenamiento;
import Modelos.Carrera;
import Modelos.JoinEstCarIns;

import java.util.List;


public interface CarreraRepository extends GenericRepository<Carrera, Integer> {
    List<JoinEstCarIns> reporte(CriterioOrdenamiento crit);
    List<Carrera> getCarrrerasConInscriptos();
    List<Carrera> getAllCarrerasOrdenadas(CriterioOrdenamiento crit);

}
