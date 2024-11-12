package Factories;

import Repositories.EstudianteRepository;

public abstract class RepositoryFactory {
    public static final int POSTGRESQL = 1;

    public abstract EstudianteRepository getEstudianteRepository();

    public RepositoryFactory getRepositoryFactory(int opcion) throws IllegalArgumentException {
        switch (opcion) {
            case POSTGRESQL: return JPARepositoryFactory.getInstance();
            default: throw new IllegalArgumentException("Opcion invalida");
        }
    }
}
