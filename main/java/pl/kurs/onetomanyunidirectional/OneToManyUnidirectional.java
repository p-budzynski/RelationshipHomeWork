package pl.kurs.onetomanyunidirectional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.onetomanyunidirectional.dao.CustomerDao;
import pl.kurs.onetomanyunidirectional.dao.ProductDao;
import pl.kurs.onetomanyunidirectional.dao.ShoppingCartsDao;
import pl.kurs.onetomanyunidirectional.entity.Product;
import pl.kurs.onetomanyunidirectional.entity.ShoppingCart;
import pl.kurs.onetomanyunidirectional.entity.Customer;

@SpringBootApplication
public class OneToManyUnidirectional {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(OneToManyUnidirectional.class, args);

        ProductDao productDao = ctx.getBean(ProductDao.class);
        ShoppingCartsDao shoppingCartsDao = ctx.getBean(ShoppingCartsDao.class);
        CustomerDao customerDao = ctx.getBean(CustomerDao.class);

        Product prod1 = new Product("Karbonowy Splitter", 1500D, "Splitter dokładany do zderzaka");
        Product prod2 = new Product("Komplet opon Toyo R888", 3600D, "245/40 R18 i 265/40 R18.");

        productDao.save(prod1);
        productDao.save(prod2);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCartsDao.addProductsToShoppingCart(shoppingCart, prod1, prod2);

        Customer customer = new Customer("Łukasz", "Czegoszukasz");

        shoppingCart = shoppingCartsDao.get(1L);

        customerDao.addShoppingCartsToCustomer(customer, shoppingCart);

        System.out.println(customerDao.get(1L));
        System.out.println("---------------------------");
        System.out.println(shoppingCartsDao.get(1L));
    }
}
