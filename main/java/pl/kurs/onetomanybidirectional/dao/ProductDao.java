package pl.kurs.onetomanybidirectional.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.kurs.onetomanybidirectional.entity.Product;

@Repository
@RequiredArgsConstructor
@Transactional
public class ProductDao {
    private final EntityManager entityManager;

    public void save(Product product) {
        entityManager.persist(product);
    }

    public Product get(Long id) {
        return entityManager.find(Product.class, id);
    }

}
