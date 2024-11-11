package Repositories;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<Entity, Id extends Serializable>{
    Entity getById(Id id);
    void persist(Entity entity);
    void update(Entity entity);
    void delete(Id id);
    List<Entity> findAll();
}
