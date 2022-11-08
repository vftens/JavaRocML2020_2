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
// Организуйте хранение данных списка дел приложения ToDoList, используя базу данных.
//Должны быть реализованы все запросы: создание дела, удаление дела, обновление дела, получение списка, удаление всего списка.
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

    @PostMapping("/books/{id}")
    public ResponseEntity<Book> update(@PathVariable("id") int id, @RequestBody Book book) {
        LOG.info("Updating book with id {}", id);
        Book currentBook = Storage.getBookById(id);
        if (currentBook == null) {
            LOG.error("Unable to update. Book with id {} not found.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentBook.setTitle(book.getTitle());
        currentBook.setAuthor(book.getAuthor());
        currentBook.setYear(book.getYear());
        currentBook.setPriority(book.getPriority());
        currentBook.setIsRead(book.getIsRead());
        Storage.updateBook(currentBook);
        return new ResponseEntity<>(currentBook, HttpStatus.OK);
    }

    @PostMapping("/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable("id") int id) {
        LOG.info("Fetching & Deleting Book with id {}", id);
        Book book = Storage.getBookById(id);
        if (book == null) {
            LOG.error("Unable to delete. Book with id {} not found.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Storage.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        LOG.info("Creating book: {}", book);
        if (Storage.getBookById(book.getId()) != null) {
            LOG.error("Unable to create. A book with id {} already exist", book.getId());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Storage.addBook(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Book> getLists() {
        LOG.info("Getting all books");
        List<Book> books = Storage.getAllBooks();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> deleteAll() {
        LOG.info("Deleting All Books");
        Storage.deleteAllBooks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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

