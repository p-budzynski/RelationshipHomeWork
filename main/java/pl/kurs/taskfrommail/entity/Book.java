package pl.kurs.taskfrommail.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books")
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "year_of_publication", nullable = false)
    private Integer yearOfPublication;

    @Column(name = "book_category", nullable = false)
    @Enumerated(EnumType.STRING)
    private BookCategory bookCategory;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Opinion> opinionList = new ArrayList<>();

    public Book(String title, Integer yearOfPublication, BookCategory bookCategory, Author author) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.bookCategory = bookCategory;
        this.author = author;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return Objects.equals(title, book.title) && Objects.equals(yearOfPublication, book.yearOfPublication) && bookCategory == book.bookCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, yearOfPublication, bookCategory);
    }
}
