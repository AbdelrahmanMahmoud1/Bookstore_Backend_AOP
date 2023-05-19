package com.example.demo.book;

import com.example.demo.order.OrderItem;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")

public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String bookName;
    private String selfLink;
    private int stockNumber;
    private double price;
    private String image;

    @OneToMany(mappedBy = "book")
    private List<OrderItem> orderBooks;

    public String getImage() {
        return image;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public Book(String bookName, String selfLink, int stockNumber, double price) {
        this.bookName = bookName;
        this.selfLink = selfLink;
        this.stockNumber = stockNumber;
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Book(String bookName, int stockNumber, double price, String image) {
        this.bookName = bookName;
        this.stockNumber = stockNumber;
        this.price = price;
        this.image = image;
    }


    public Book(long id, String bookName, int stockNumber, double price, String image) {
        this.id = id;
        this.bookName = bookName;
        this.stockNumber = stockNumber;
        this.price = price;
        this.image = image;
    }

    public Book(){

    }

//    public Book(String bookName, int stockNumber, double price, List<OrderItem> orderBooks) {
//        this.bookName = bookName;
//        this.stockNumber = stockNumber;
//        this.price = price;
//        this.orderBooks = orderBooks;
//    }


    public List<OrderItem> getOrderBooks() {
        return orderBooks;
    }

    public void setOrderBooks(List<OrderItem> orderBooks) {
        this.orderBooks = orderBooks;
    }

    public Book(String bookName, int stockNumber, double price) {
        this.bookName = bookName;
        this.stockNumber = stockNumber;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", stockNumber=" + stockNumber +
                ", price=" + price +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
