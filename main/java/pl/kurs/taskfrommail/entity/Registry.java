package pl.kurs.taskfrommail.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "registry")
@NoArgsConstructor
@Getter
@Setter
public class Registry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "borrow_date", nullable = false)
    private LocalDateTime borrowDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Registry(Book book, User user) {
        this.borrowDate = LocalDateTime.now();
        this.book = book;
        this.user = user;
    }

}
