package Repositories.JPAImplementation;

import Helpers.CriterioBusqueda;
import Helpers.CriterioOrdenamiento;
import Modelos.Estudiante;
import Repositories.EstudianteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JPAEstudianteRepository extends JPABaseRepository<Estudiante, Integer> implements EstudianteRepository {
    public JPAEstudianteRepository(EntityManager em) {
        super(em, Estudiante.class, Integer.class);
    }

    public List<Estudiante> findByCriterio(CriterioBusqueda criterioBusqueda) {
        String jqpl = "select e from Estudiante e where " + criterioBusqueda.getCriterioBusqueda();

        TypedQuery<Estudiante> query = em.createQuery(jqpl, this.entityClass);

        return query.getResultList();
    }

    @Override
    public List<Estudiante> findOrdenadoByCriterio(CriterioOrdenamiento criterioOrdenamiento) {
        String jqpl = "select e from Estudiante e order by " + criterioOrdenamiento.getCriterioOrdenamiento();

        TypedQuery<Estudiante> query = em.createQuery(jqpl, this.entityClass);

        return query.getResultList();
    }
}
