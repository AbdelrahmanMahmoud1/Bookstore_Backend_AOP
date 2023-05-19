package com.example.demo.book;

import com.example.demo.Customer.Customer;
import com.example.demo.RequestBook;
import com.example.demo.RequestBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/book")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    private final BookService bookService;
    private final RequestBookRepo Rbr;

    @Autowired
    public BookController(BookService bookService,RequestBookRepo Rbr) {
        this.bookService = bookService;
        this.Rbr = Rbr;
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping("/saveBook")
    public void saveBook(@RequestBody Book book){
        bookService.saveBooks(book);
    }
    @PostMapping("/saveBooks")
    public void saveBooks(@RequestBody List<Book> books){
        bookService.saveManyBooks(books);
    }

    @PostMapping("/request/{bookName}")
    public void requestBook(@PathVariable("bookName") String bookName){

        Rbr.save(new RequestBook(bookName));
    }

    @DeleteMapping(path ="/delete/{bookId}" )
    public void deleteBook(@PathVariable("bookId") long bookId){
        bookService.deleteBook(bookId);
    }


}
