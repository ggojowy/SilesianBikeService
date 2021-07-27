package pl.edu.wszib.jwd.silesianbikeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:db.properties")

public class SilesianBikeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SilesianBikeServiceApplication.class, args);

    }
DbInit dbInit = new DbInit();
}
