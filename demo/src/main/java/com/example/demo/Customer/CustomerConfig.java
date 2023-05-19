package com.example.demo.Customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;


@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            CustomerRepository repository
    ){
        return args -> {
            Customer mariam = new Customer(
                    "12",
                    "Mariam",
                    "mohamed",
                    "82 gamal",
                    "012213123",
                    "ma@gmail.com"

            );
            Customer alex = new Customer(
                    "123",
                    "alex",
                    "mohamed",
                    "82 gamal",
                    "012213123",
                    "alex@gmail.com"

            );
            repository.saveAll(
                    List.of(mariam,alex)
            );
        };
    }
}
