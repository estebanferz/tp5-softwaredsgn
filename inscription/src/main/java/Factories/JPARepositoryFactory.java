package Factories;

import Repositories.InscripcionRepository;
import Repositories.JPAImplementation.JPAInscripcionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPARepositoryFactory extends RepositoryFactory {
    private static JPARepositoryFactory instance;
    private EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();

    private JPARepositoryFactory() {
        instance = this;
    }

    public static JPARepositoryFactory getInstance() {
        if (instance == null) {
            new JPARepositoryFactory();
        }

        return instance;
    }

    @Override
    public InscripcionRepository getInscripcionRepository() {
        return new JPAInscripcionRepository(em);
    }
}
