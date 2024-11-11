package Repositories.JPAImplementation;

import java.util.List;

import Helpers.CriterioOrdenamiento;
import Modelos.Carrera;
import Modelos.JoinEstCarIns;
import Repositories.CarreraRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class JPACarreraRepository extends JPABaseRepository<Carrera, Integer> implements CarreraRepository {
    public JPACarreraRepository(EntityManager em) {
        super(em, Carrera.class, Integer.class);
    }

    public List<JoinEstCarIns> reporte(CriterioOrdenamiento crit){

        String q = "SELECT c, i, e FROM Carrera c LEFT JOIN Inscripcion i ON c.id = i.inscripcion_id_carrera JOIN Estudiante e ON e.id = i.inscripcion_id_estudiante ORDER BY " + crit.getCriterioOrdenamiento();
        List<JoinEstCarIns> result = em.createQuery(q, JoinEstCarIns.class).getResultList();

        System.out.println(result);

        return result;
    }

    public List<Carrera> getCarrrerasConInscriptos() {
         String jqpl = "Select c from Inscripcion i left join Carrera c on i.inscripcion_id_carrera = c.id group by c.id order by count(c) desc ";

        return em.createQuery(jqpl, Carrera.class).getResultList();
    }

    public List<Carrera> getAllCarrerasOrdenadas(CriterioOrdenamiento crit){
        String q = "SELECT c FROM Carrera c ORDER BY " + crit.getCriterioOrdenamiento();
        TypedQuery<Carrera> result = em.createQuery(q, this.entityClass);
        return result.getResultList();
    }
}
