package pl.kurs.onetomanyunidirectional.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer")
    private Set<ShoppingCart> shoppingCarts = new HashSet<>();

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", shoppingCarts=" + shoppingCarts +
               '}';
    }
}
