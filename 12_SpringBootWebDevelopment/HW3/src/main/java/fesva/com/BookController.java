package fesva.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fesva.com.response.Book;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private final BookRepository bookRepository;

    public BookController() {
        bookRepository = null;
    }

    @RequestMapping(value = "/books/", method = RequestMethod.GET)
    public List<Book> list() {
        return Storage.getAllBooks();
    }

    @RequestMapping(value = "/books/", method = RequestMethod.POST)
    public int add(Book book) {
        return Storage.addBook(book);
    }

    @DeleteMapping("/delete")
    public void deleteDocument(@RequestParam(value="id") Integer id){
        Storage.deleteById(id);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Book book = Storage.getBook(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(book, HttpStatus.OK);
    }


}

// tHIS method definition example for /delete in controller bookstore
//

