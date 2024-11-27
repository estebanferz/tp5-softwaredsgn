package Repositories.JPAImplementation;

import Helpers.Carrera;
import Helpers.CriterioBusqueda;
import Helpers.Estudiante;
import Modelos.Inscripcion;
import Repositories.InscripcionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


import java.util.Date;
import java.util.List;
import java.util.Map;

import Helpers.CriterioOrdenamiento;

public class JPAInscripcionRepository extends JPABaseRepository<Inscripcion, Integer> implements InscripcionRepository {
    public JPAInscripcionRepository(EntityManager em) {
        super(em, Inscripcion.class, Integer.class);
    }

    public void matricular(Estudiante estudiante, Carrera carrera){
        em.getTransaction().begin();

        String jqpl = "INSERT INTO Inscripcion (inscripcion_id_estudiante, inscripcion_id_carrera, fecha_inscripcion, fecha_graduacion) VALUES (?1, ?2, ?3, ?4)";

        try {
            em.createQuery(jqpl).setParameter(1,  estudiante.getId()).setParameter(2, carrera.getId()).setParameter(3, new Date()).setParameter(4, null).executeUpdate();
        } catch (Exception e) {
            System.out.println(estudiante.getNombre() + " ya esta matriculado en " + carrera.getNombre());
        }

        em.getTransaction().commit();
    }

    public void setFechaGraduacion(Estudiante estudiante, Carrera carrera, Date fecha_graduacion) {
        em.getTransaction().begin();

        String jqpl = "UPDATE Inscripcion i SET i.fecha_graduacion = :fecha_graduacion WHERE i.inscripcion_id_estudiante = :id_estudiante and i.inscripcion_id_carrera = :id_carrera";

        em.createQuery(jqpl).setParameter("id_estudiante",  estudiante.getId()).setParameter("id_carrera", carrera.getId()).setParameter("fecha_graduacion", fecha_graduacion).executeUpdate();

        em.getTransaction().commit();
    }

    public Inscripcion findById(int id_carrera, int id_estudiante){
        
        em.getTransaction().begin();
        String q = "SELECT i FROM Inscripcion i WHERE :id_carrera = i.inscripcion_id_carrera AND :id_estudiante = i.inscripcion_id_estudiante";
        TypedQuery<Inscripcion> result = em.createQuery(q, this.entityClass).setParameter("id_carrera", id_carrera).setParameter("id_estudiante", id_estudiante);
        em.getTransaction().commit();
        return result.getSingleResult();
    }

    public List<Inscripcion> getAllCarrerasOrdenadas(CriterioOrdenamiento crit){
        String q = "SELECT i FROM Inscripcion i ORDER BY " + crit.getCriterioOrdenamiento();
        TypedQuery<Inscripcion> result = em.createQuery(q, this.entityClass);
        return result.getResultList();
    }

    public List<Inscripcion> findByCriterio(CriterioBusqueda criterioBusqueda){
        String jqpl = "select i from Inscripcion i where " + criterioBusqueda.getCriterioBusqueda();

        TypedQuery<Inscripcion> query = em.createQuery(jqpl, this.entityClass);

        return query.getResultList();
    }

    @Override
    public void deleteByCriterio(CriterioBusqueda criterioBusqueda) {
        em.getTransaction().begin();
        String jqpl = "delete from Inscripcion i where " + criterioBusqueda.getCriterioBusqueda();
        Query query = em.createQuery(jqpl);
        query.executeUpdate();
        em.getTransaction().commit();
    }
}
