package com.example.demo.order;

import com.example.demo.Customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/order")
@CrossOrigin(origins = "http://localhost:3000")

public class OrderController {

    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService ) {
       this.orderService = orderService;
    }

    @GetMapping("/orders")

    public List<Orders> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/orders/{customerId}")
    public Optional<Orders> getOrdersOfCustomer(
            @PathVariable("customerId")  String customerId
    ){

        return orderService.getOrdersOfCustomer(customerId);
    }

    @PostMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable("orderId") long id){
        orderService.deleteOrder(id);

    }

    @PostMapping("/create")
    public void createOrder(@RequestParam String customerId, @RequestParam List<Long>  bookId, @RequestParam Integer quantity){

        System.out.println(customerId);
        Customer customer = orderService.getCustomer(customerId);



        System.out.println(bookId);

//        List<Long> books = bookId.get("bookId");


            orderService.createOrder(bookId,quantity,customer);



    }

}
