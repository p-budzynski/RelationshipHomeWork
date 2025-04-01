package pl.kurs.onetomanyunidirectional.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.kurs.onetomanyunidirectional.entity.Product;
import pl.kurs.onetomanyunidirectional.entity.ShoppingCart;

@Repository
@RequiredArgsConstructor
@Transactional
public class ShoppingCartsDao {
    private final EntityManager entityManager;

    public void save(ShoppingCart shoppingCart) {
        entityManager.persist(shoppingCart);
    }

    public ShoppingCart get(Long id) {
        return entityManager.find(ShoppingCart.class, id);
    }

    public void addProductsToShoppingCart(ShoppingCart shoppingCart, Product... products) {
        shoppingCart = entityManager.merge(shoppingCart);

        if (shoppingCart != null) {
            for (Product product : products) {
                product = entityManager.merge(product);
                shoppingCart.getProducts().add(product);
            }
        }
    }

}
