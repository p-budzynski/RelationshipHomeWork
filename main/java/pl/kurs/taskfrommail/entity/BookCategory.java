package pl.kurs.taskfrommail.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "book_category")
@NoArgsConstructor
@Getter
@Setter
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book_category")
    private Long id;

    @Column(name = "book_category", nullable = false, unique = true)
    private String bookCategory;

    @OneToMany(mappedBy = "bookCategory", fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public BookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        BookCategory that = (BookCategory) object;
        return Objects.equals(bookCategory, that.bookCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookCategory);
    }
}
