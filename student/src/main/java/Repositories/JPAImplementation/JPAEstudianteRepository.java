package Repositories.JPAImplementation;

import Helpers.CriterioBusqueda;
import Helpers.CriterioOrdenamiento;
import Modelos.Estudiante;
import Repositories.EstudianteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

public class JPAEstudianteRepository extends JPABaseRepository<Estudiante, Integer> implements EstudianteRepository {
    public JPAEstudianteRepository(EntityManager em) {
        super(em, Estudiante.class, Integer.class);
    }

    public List<Estudiante> find(){
        String jqpl = "select e from Estudiante e";

        TypedQuery<Estudiante> query = em.createQuery(jqpl, this.entityClass);

        return query.getResultList();
    }

    public void postEstudiante(Estudiante estudiante){
        em.getTransaction().begin();

        String jqpl = "INSERT INTO Estudiante (nombre, apellido, edad, genero, dni, ciudad, libreta) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)";

        try {
            em.createQuery(jqpl).setParameter(1, estudiante.getNombre()).setParameter(2, estudiante.getApellido()).setParameter(3, estudiante.getEdad())
                                .setParameter(4, estudiante.getGenero()).setParameter(5, estudiante.getDni()).setParameter(6, estudiante.getCiudad())
                                .setParameter(7, estudiante.getLibreta())
                                .executeUpdate();
        } catch (Exception e) {
            System.out.println(estudiante.getNombre() + " ya se encuentra en la base de datos");
        }

        em.getTransaction().commit();
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
