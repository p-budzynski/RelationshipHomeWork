package pl.kurs.taskfrommail.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.kurs.taskfrommail.entity.BookCategory;
import pl.kurs.taskfrommail.entity.User;

@Repository
@RequiredArgsConstructor
@Transactional
public class BookCategoryDao {
    private final EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }

    public BookCategory get(Long id) {
        return entityManager.find(BookCategory.class, id);
    }


}
