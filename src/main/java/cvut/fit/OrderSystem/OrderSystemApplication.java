package cvut.fit.ordersystem;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
        exclude = {org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration.class})
public class OrderSystemApplication {
    private static final Logger log = LoggerFactory.getLogger(OrderSystemApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrderSystemApplication.class, args);

    }
}
