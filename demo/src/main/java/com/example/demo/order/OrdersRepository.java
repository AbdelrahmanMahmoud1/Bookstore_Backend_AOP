package com.example.demo.order;

import com.example.demo.Customer.Customer;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OrdersRepository extends
        JpaRepository<Orders, Long> {
    Optional<Orders> findCustomerByCustomerId(String customer);
}

