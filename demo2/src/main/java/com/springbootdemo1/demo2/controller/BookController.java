package com.springbootdemo1.demo2.controller;

import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo1.demo2.entity.Book;
import com.springbootdemo1.demo2.repository.BookRepository;

@RestController
@RequestMapping("/Book")
public class BookController {

    @Autowired
    BookRepository bookRepository;
    //http://localhost:8080/Book

    /*
     * {
     *       "bookId":1,
     *       "bookName":"java",
     *       "bookAuthor":"ram"   
     *      }
     */

     // save book
    @PostMapping("/Save")
    public String insertBook(@RequestBody Book book)
    {
        bookRepository.save(book);
        System.out.println(book);
        return "Book details saved successfully.";
    }
    //get all books
    @GetMapping("/get")
    public List<Book> getAllBook()
    {
        return bookRepository.findAll();
    }

    // http://localhost:8080/book/get/1  // passing the value into url.
    //Get book by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Book>> getByIdBook(@PathVariable int id)
    {
        Optional<Book> book1 = bookRepository.findById(id);
        return ResponseEntity.ok(book1);
    }

    //update
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@RequestBody Book book, @PathVariable int id )
    {
        Book book1 = bookRepository.findById(id).orElse(null);
        book1.setBookName(book.getBookName());
        book1.setBookAuthor(book.getBookAuthor());
        Book updateBook = bookRepository.save(book1);
        return ResponseEntity.ok(updateBook);
    }

    //delete

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id)
    {
        //Book book1 = bookRepository.findById(id).orElse(null);
        bookRepository.deleteById(id);
        return "Book data has deleted";
    }
    
    
}
