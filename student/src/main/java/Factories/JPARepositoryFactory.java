package Factories;

import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.InscripcionRepository;
import Repositories.JPAImplementation.JPACarreraRepository;
import Repositories.JPAImplementation.JPAEstudianteRepository;
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
    public EstudianteRepository getEstudianteRepository() {
        return new JPAEstudianteRepository(em);
    }

    @Override
    public InscripcionRepository getInscripcionRepository() {
        return new JPAInscripcionRepository(em);
    }

    @Override
    public CarreraRepository getCarreraRepository() {
        return new JPACarreraRepository(em);
    }
}
