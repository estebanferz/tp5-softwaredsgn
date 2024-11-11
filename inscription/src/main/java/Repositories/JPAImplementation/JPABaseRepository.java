package Repositories.JPAImplementation;

import Repositories.GenericRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;

public class JPABaseRepository<Entity, Id extends Serializable> implements GenericRepository<Entity, Id> {
    EntityManager em;
    Class<Entity> entityClass;
    Class<Id> idClass;

    public JPABaseRepository(EntityManager em, Class<Entity> entityClass, Class<Id> idClass) {
        this.em = em;
        this.entityClass = entityClass;
        this.idClass = idClass;
    }

    @Override
    public Entity getById(Id id) {
        return em.find(entityClass, id);
    }

    @Override
    public void persist(Entity entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Entity entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Id id) {
        em.getTransaction().begin();
        Entity entity = em.find(entityClass, id);
        if (entity != null) {
            em.remove(entity);
        }
        em.getTransaction().commit();
    }

    @Override
    public List<Entity> findAll() {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        TypedQuery<Entity> query = em.createQuery(jpql, entityClass);
        return query.getResultList();
    }


}
