package com.example.demo.order;

import com.example.demo.Customer.Customer;
import com.example.demo.Customer.CustomerRepository;
import com.example.demo.OrderItemRepository;
import com.example.demo.book.Book;
import com.example.demo.book.BookRepository;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping(path = "api/v1/order")
@Service
public class OrderService {
    private final OrdersRepository orderRepository;

    private final CustomerRepository customerRepository;

    private final OrderItemRepository  orderItemRepository;

    private final BookRepository bookRepository;

    @Autowired
    public OrderService(OrdersRepository orderRepository,CustomerRepository customerRepository, OrderItemRepository  orderItemRepository, BookRepository bookRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.orderItemRepository = orderItemRepository;
        this.bookRepository = bookRepository;

    }


//    @GetMapping("/orders")

    public List<Orders> getOrders(){
        return orderRepository.findAll();
    }

//    @GetMapping("/orders/{customerId}")
    public Optional<Orders> getOrdersOfCustomer(
//            @PathVariable("customerId")
           String customerId
           ){

        Customer customer = customerRepository.findStudentById(customerId);
        System.out.println(customer);
        return orderRepository.findCustomerByCustomerId(customerId);
    }

    public Customer getCustomer (String id){
        return customerRepository.findStudentById(id);
    }

    public void createOrder(List<Long> bookId, int quantity, Customer customer){

        Orders order = new Orders(new Date(),new Date(),customer, customer.getAddress());
        List<OrderItem> items = new ArrayList<OrderItem>();

        int count = 0;
        for (Long item : bookId){
            System.out.println(count);
            count++;
            Book book = bookRepository.findBooktById(item);


            OrderItem orderItem = new OrderItem(quantity,book,order);

            items.add(orderItem);

            order.setOrderItems(items);


        }


        orderRepository.save(order);
        orderItemRepository.saveAll(items);
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
