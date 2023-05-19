package com.example.demo.order;

import com.example.demo.book.Book;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")

public class OrderItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")

    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "book_id")
//    @JsonManagedReference(value = "orderitem")
    private Book book;

    public OrderItem(){}
    public OrderItem(int quantity, Book book, Orders orders) {
        this.quantity = quantity;
        this.orders = orders;
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonBackReference(value = "order1")
    public Orders getOrder() {
        return orders;
    }

    public void setOrder(Orders orders) {
        this.orders = orders;
    }
    @JsonBackReference(value = "book")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


}
