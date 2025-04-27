package pl.kurs.taskfrommail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.taskfrommail.service.RunService;

@SpringBootApplication
public class LibraryApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(LibraryApplication.class, args);

        RunService runService = ctx.getBean(RunService.class);
        runService.run();

    }
}
