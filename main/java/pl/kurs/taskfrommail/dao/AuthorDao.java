package pl.kurs.taskfrommail.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.kurs.taskfrommail.entity.Author;

@Repository
@RequiredArgsConstructor
@Transactional
public class AuthorDao {
    private final EntityManager entityManager;

    public void save(Author author) {
        entityManager.persist(author);
    }

    public Author get(Long id) {
        return entityManager.find(Author.class, id);
    }
}
