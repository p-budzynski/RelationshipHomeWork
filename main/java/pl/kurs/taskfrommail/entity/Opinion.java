package pl.kurs.taskfrommail.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "opinions")
@NoArgsConstructor
@Getter
@Setter
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "opinion_date", nullable = false)
    private LocalDateTime opinionDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "content", nullable = false)
    private String content;

    public Opinion(User user, Book book, String content) {
        this.opinionDate = LocalDateTime.now();
        this.content = content;
        this.book = book;
        this.user = user;
    }
}
