package cvut.fit.borrowsystem;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
        exclude = {org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration.class})
public class BorrowSystemApplication {
    private static final Logger log = LoggerFactory.getLogger(BorrowSystemApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BorrowSystemApplication.class, args);

    }
}
