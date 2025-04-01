package pl.kurs.onetomanyunidirectional.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.kurs.onetomanyunidirectional.entity.*;

import java.util.Set;

@Repository
@RequiredArgsConstructor
@Transactional
public class CustomerDao {
    private final EntityManager entityManager;

    public void save(Customer customer) {
        Set<ShoppingCart> shoppingCarts = customer.getShoppingCarts();
        for (ShoppingCart cart : shoppingCarts) {
            if (cart != null && cart.getId() == null) {
                entityManager.persist(cart);
            }
        }
        entityManager.persist(customer);
    }

    public Customer get(Long id) {
        return entityManager.find(Customer.class, id);
    }

    public void addShoppingCartsToCustomer(Customer customer, ShoppingCart... shoppingCarts) {
        customer = entityManager.merge(customer);

        if (customer != null) {
            for (ShoppingCart cart : shoppingCarts) {
                cart = entityManager.merge(cart);
                customer.getShoppingCarts().add(cart);
            }
        }
    }
}
