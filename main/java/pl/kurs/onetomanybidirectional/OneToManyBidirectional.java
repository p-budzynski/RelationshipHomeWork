package pl.kurs.onetomanybidirectional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.onetomanybidirectional.dao.Customer2Dao;
import pl.kurs.onetomanybidirectional.dao.ProductDao;
import pl.kurs.onetomanybidirectional.dao.ShoppingCartDao;
import pl.kurs.onetomanybidirectional.entity.Customer2;
import pl.kurs.onetomanybidirectional.entity.Product;
import pl.kurs.onetomanybidirectional.entity.ShoppingCart;

@SpringBootApplication
public class OneToManyBidirectional {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(OneToManyBidirectional.class, args);

        ProductDao productDao = ctx.getBean(ProductDao.class);
        ShoppingCartDao shoppingCartDao = ctx.getBean(ShoppingCartDao.class);
        Customer2Dao customer2Dao = ctx.getBean(Customer2Dao.class);

        Product prod1 = new Product("Karbonowy Splitter", 1500D, "Splitter dokładany do zderzaka");
        Product prod2 = new Product("Komplet opon Toyo R888", 3600D, "245/40 R18 i 265/40 R18.");

        productDao.save(prod1);
        productDao.save(prod2);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCartDao.addProductsToShoppingCart(shoppingCart, prod1, prod2);

        Customer2 customer = new Customer2("Łukasz", "Czegoszukasz");

        shoppingCart = shoppingCartDao.get(1L);

        customer2Dao.addShoppingCartsToCustomer(customer, shoppingCart);

        System.out.println(shoppingCartDao.get(1L));
        System.out.println("-----------------------------");

        System.out.println(customer2Dao.get(1L));

    }
}
