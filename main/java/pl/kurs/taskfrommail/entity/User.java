package pl.kurs.taskfrommail.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "e_mail", nullable = false, unique = true)
    @Email
    private String mail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Opinion> opinions = new ArrayList<>();

    public User(String firstName, String lastName, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
    }
}
