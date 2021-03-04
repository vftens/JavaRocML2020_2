package fesva.com;

import fesva.com.response.Book;

import java.util.ArrayList;

import java.util.List;


public class Storage {
    private static ArrayList<Book> books=new ArrayList<Book>();

    public static List<Book> getAllBooks() {
        List<Book> books = Storage.books;
        return books;  // ВОЗВРАЩАЕТ КОЛ-ВО КНИГ???
    }

    public static int addBook(Book book) {
        int id = books.size() + 1;
        book.setId(id);
        books.add(book);

        return id;
    }
}
