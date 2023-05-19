package com.example.demo.book;

import com.example.demo.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends
        JpaRepository<Book,Long> {

    Book findBooktById(long id);

}
