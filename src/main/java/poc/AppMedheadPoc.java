package poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppMedheadPoc{

    public static void main(String[] args) {
        SpringApplication.run(AppMedheadPoc.class, args);
    }

    public void run(String... args) {
        System.out.println("Coucou!!!");
    }
}