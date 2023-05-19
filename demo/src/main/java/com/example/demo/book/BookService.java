package com.example.demo.book;


import com.example.demo.Customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void saveBooks(Book book){
        bookRepository.save(book);

    }

    public void saveManyBooks(List <Book> books){
        bookRepository.saveAll(books);

    }

    public void deleteBook(long bookId) {
        boolean exits = bookRepository.existsById(bookId);
        if(!exits){
            throw new IllegalStateException("doesnt exits");

        }else{
            bookRepository.deleteById(bookId);
        }

    }
}
