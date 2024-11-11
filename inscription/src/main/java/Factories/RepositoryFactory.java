package Factories;

import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.InscripcionRepository;

public abstract class RepositoryFactory {
    public static final int POSTGRESQL = 1;

    public abstract EstudianteRepository getEstudianteRepository();
    public abstract InscripcionRepository getInscripcionRepository();
    public abstract CarreraRepository getCarreraRepository();

    public RepositoryFactory getRepositoryFactory(int opcion) throws IllegalArgumentException {
        switch (opcion) {
            case POSTGRESQL: return JPARepositoryFactory.getInstance();
            default: throw new IllegalArgumentException("Opcion invalida");
        }
    }
}
