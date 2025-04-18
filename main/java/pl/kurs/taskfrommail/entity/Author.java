package pl.kurs.taskfrommail.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "pesel", nullable = false)
    @Pattern(regexp = "^[0-9]{11}$")
    private String pesel;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Book> books = new HashSet<>();

    public Author(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }
}
