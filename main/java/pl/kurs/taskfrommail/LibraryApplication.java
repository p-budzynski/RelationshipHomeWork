package pl.kurs.taskfrommail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.taskfrommail.dao.AuthorDao;
import pl.kurs.taskfrommail.dao.RegistryDao;
import pl.kurs.taskfrommail.dao.UserDao;
import pl.kurs.taskfrommail.entity.*;

import java.time.LocalDateTime;

@SpringBootApplication
public class LibraryApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(LibraryApplication.class, args);

        AuthorDao authorDao = ctx.getBean(AuthorDao.class);
        UserDao userDao = ctx.getBean(UserDao.class);
        RegistryDao registryDao = ctx.getBean(RegistryDao.class);

        Author author1 = new Author("Isaac", "Asimov", "12345678901");
        Author author2 = new Author("J.R.R.", "Tolkien", "23456789012");
        Author author3 = new Author("Agatha", "Christie", "34567890123");
        Author author4 = new Author("Stephen", "King", "45678901234");

        Book book1 = new Book("Foundation", 1951, BookCategory.SCIENCE_FICTION, author1);
        Book book2 = new Book("The Maze Runner", 2009, BookCategory.ADVENTURE, author1);

        author1.getBookSet().add(book1);
        author1.getBookSet().add(book2);
        authorDao.save(author1);

        Book book3 = new Book("The Hobbit", 1937, BookCategory.FANTASY, author2);
        Book book4 = new Book("The Lord of the Rings", 1954, BookCategory.FANTASY, author2);

        author2.getBookSet().add(book3);
        author2.getBookSet().add(book4);
        authorDao.save(author2);

        Book book5 = new Book("Murder on the Orient Express", 1934, BookCategory.MYSTERY, author3);

        author3.getBookSet().add(book5);
        authorDao.save(author3);

        Book book6 = new Book("And Then There Were None", 1939, BookCategory.MYSTERY, author3);
        Book book7 = new Book("The Shining", 1977, BookCategory.HORROR, author4);
        Book book8 = new Book("Carrie", 1974, BookCategory.THRILLER, author4);
        Book book9 = new Book("It", 1986, BookCategory.HORROR, author4);
        Book book10 = new Book("The Dark Tower", 1982, BookCategory.ADVENTURE, author4);

        author4.getBookSet().add(book6);
        author4.getBookSet().add(book7);
        author4.getBookSet().add(book8);
        author4.getBookSet().add(book9);
        author4.getBookSet().add(book10);
        authorDao.save(author4);

        User user1 = new User("Alice", "Williams", "alice@example.com");
        Opinion opinion1User1 = new Opinion(user1, book1, "A thrilling start to a mind-bending series!");
        Opinion opinion2User1 = new Opinion(user1, book2, "A magical journey through Middle-earth.");
        Opinion opinion3User1 = new Opinion(user1, book3, "A fascinating mystery with an unexpected twist.");

        user1.getOpinionList().add(opinion1User1);
        user1.getOpinionList().add(opinion2User1);
        user1.getOpinionList().add(opinion3User1);
        userDao.save(user1);

        User user2 = new User("Bob", "Johnson", "bob@example.com");
        Opinion opinion1User2 = new Opinion(user2, book4, "A terrifying journey into madness!");
        Opinion opinion2User2 = new Opinion(user2, book5, "A brilliant fantasy epic, truly legendary.");
        Opinion opinion3User2 = new Opinion(user2, book7, "Gripping and suspenseful; a true thriller.");

        user2.getOpinionList().add(opinion1User2);
        user2.getOpinionList().add(opinion2User2);
        user2.getOpinionList().add(opinion3User2);
        userDao.save(user2);

        Registry registry1 = new Registry(book1, user1);
        registry1.setReturnDate(LocalDateTime.now().plusDays(7));
        registryDao.save(registry1);

        Registry registry2 = new Registry(book2, user1);
        registry2.setReturnDate(LocalDateTime.now().plusDays(14));
        registryDao.save(registry2);

        Registry registry3 = new Registry(book3, user1);
        registry3.setReturnDate(LocalDateTime.now().plusDays(10));
        registryDao.save(registry3);

        Registry registry4 = new Registry(book4, user2);
        registryDao.save(registry4);

        Registry registry5 = new Registry(book5, user2);
        registry5.setReturnDate(LocalDateTime.now().plusDays(7));
        registryDao.save(registry5);

        Registry registry6 = new Registry(book6, user2);
        registryDao.save(registry6);

    }
}
