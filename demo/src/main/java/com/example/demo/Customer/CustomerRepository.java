package com.example.demo.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends
         JpaRepository<Customer,String> {


    Optional<Customer> findStudentByEmail(String email);
    Customer findStudentById(String id);
}
