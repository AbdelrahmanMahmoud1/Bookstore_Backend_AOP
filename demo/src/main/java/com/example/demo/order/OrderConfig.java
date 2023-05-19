//
//package com.example.demo.order;
//import com.example.demo.Customer.Customer;
//import com.example.demo.Customer.CustomerRepository;
//import com.example.demo.OrderItemRepository;
//import com.example.demo.book.Book;
//import com.example.demo.book.BookRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//
//@Configuration
//public class OrderConfig {
//
//    CustomerRepository customerRepository;
//    BookRepository bookRepository;
//    OrderItemRepository orderItemRepository;
//
//
//    private Customer c ;
//    private Book b ;
//    private OrderItem i ;
//
//    @Autowired
//    public OrderConfig(OrderItemRepository orderItemRepository, CustomerRepository customerRepository,BookRepository  bookRepository) {
//        this.orderItemRepository = orderItemRepository;
//        c = customerRepository.findStudentById("123");
//        b = bookRepository.findBooktById(9);
//
//    }
//
//
//    private List<OrderItem> orders = new ArrayList<OrderItem>();
//
//    @Bean
//    CommandLineRunner commandLineRunner3(
//            OrdersRepository repository
//
//
//
//    ){
//        return args -> {
//
//            System.out.println(c);
//
//
//            Orders book1 = new Orders(
//                    new Date(),
//                    new Date(),
//                    c,
//                    orders,
//                    "asd"
//            );
//            i = new OrderItem(12,b,book1);
//            orders.add(i);
//            book1.setOrderItems(orders);
//
//            repository.saveAll(
//                    List.of(book1)
//
//            );
//            orderItemRepository.save(i);
//
//        };
//    }
//
//
//}
