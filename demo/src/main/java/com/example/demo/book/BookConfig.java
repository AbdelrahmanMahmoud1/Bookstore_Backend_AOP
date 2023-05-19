//package com.example.demo.book;
//import com.example.demo.Customer.Customer;
//import com.example.demo.Customer.CustomerRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import java.util.List;
//
//
//@Configuration
//public class BookConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner2(
//            BookRepository repository
//    ){
//        return args -> {
//            Book book1 = new Book(
//                    "Harry Potter",
//                    3,
//                    6.5
//
//            );
//            Book book2 = new Book(
//                    "Lord of the rings",
//                    10,
//                    90
//
//            );
//            repository.saveAll(
//                    List.of(book1,book2)
//            );
//        };
//    }
//}
