package main;

import response.Book;

import java.util.ArrayList;

import java.util.List;


public class Storage {
    private static ArrayList<Book> books;


    public int addBook(Book book){
        int id = books.size();
        books.add(book);


    public static List<Book> getAllBooks()
    {
        return books;
    }

    public static int addBook(Book book){
        int id = books.size() + 1;
        book.setId(id);
        books.add(book);

        return id;

    }
}
