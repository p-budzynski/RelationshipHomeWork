package pl.kurs.onetomanybidirectional.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.kurs.onetomanybidirectional.entity.Customer2;
import pl.kurs.onetomanybidirectional.entity.ShoppingCart;

@Repository
@RequiredArgsConstructor
@Transactional
public class Customer2Dao {
    private final EntityManager entityManager;

    public void save(Customer2 customer) {
        entityManager.persist(customer);
    }

    public Customer2 get(Long id) {
        return entityManager.find(Customer2.class, id);
    }

    public void addShoppingCartsToCustomer(Customer2 customer, ShoppingCart... shoppingCarts) {
        customer = entityManager.merge(customer);

        if (customer != null) {
            for (ShoppingCart cart : shoppingCarts) {
                cart = entityManager.merge(cart);
                cart.setCustomer(customer);
                customer.getShoppingCarts().add(cart);
            }
        }
    }
}
