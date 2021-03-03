package fesva.com;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import fesva.com.response.Book;

import java.util.List;

import static fesva.com.Storage.*;

@RestController
public class BookController {


//    public List<Book> list() {
  //      return Storage.getAllBooks();
    //}

    //@Controller
    //public int add(Book book) {


    @RequestMapping(value = "/books/", method = RequestMethod.GET)
    public List<Book> list() {
        return getAllBooks();

    }

    @RequestMapping(value = "/books/", method = RequestMethod.POST)
    public int add(Book book) {
        return Storage.addBook(book);
    }

}
