package pl.kurs.onetomanybidirectional.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.kurs.onetomanybidirectional.entity.Product;
import pl.kurs.onetomanybidirectional.entity.ShoppingCart;


@Repository
@RequiredArgsConstructor
@Transactional
public class ShoppingCartDao {
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
