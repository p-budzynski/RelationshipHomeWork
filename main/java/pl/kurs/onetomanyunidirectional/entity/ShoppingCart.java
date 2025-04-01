package pl.kurs.onetomanyunidirectional.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "shopping_carts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shopping_cart")
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "shopping_carts_products",

            joinColumns = {@JoinColumn(name="shopping_cart_id",
                    referencedColumnName="id_shopping_cart")},

            inverseJoinColumns = {@JoinColumn(name="product_id",
                    referencedColumnName="id_product")}
    )
    private List<Product> products = new LinkedList<>();

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

}
