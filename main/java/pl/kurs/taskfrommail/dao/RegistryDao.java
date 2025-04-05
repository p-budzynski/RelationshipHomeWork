package pl.kurs.taskfrommail.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.kurs.taskfrommail.entity.Registry;

@Repository
@RequiredArgsConstructor
@Transactional
public class RegistryDao {
    private final EntityManager entityManager;

    public void save(Registry registry) {
        entityManager.persist(registry);
    }

    public Registry get(Long id) {
        return entityManager.find(Registry.class, id);
    }

    public void update(Registry registry) {
        if (registry.getId() != null) {
            entityManager.merge(registry);
        }
    }
}
