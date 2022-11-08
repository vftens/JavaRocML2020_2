package fesva.com;

import fesva.com.response.Book;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
// This class is used for Book creation from Scratch.

public class Storage {
    private static int currentId = 1;
    private static int currentcourseId = 1;
    private static HashMap<Integer, Book> books = new HashMap<Integer, Book>();
    private static HashMap<Integer, Courses> courses = new HashMap<Integer, Courses>();

    public static List<Book> getAllBooks() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.addAll(books.values());
        //List<Book> books = Storage.books;
        return bookList;  // ВОЗВРАЩАЕТ список КОЛ-ВО КНИГ???
    }

    public static int addBook(Book book) {
        int id = currentId++; //books.size() + 1;
        book.setId(id);
        books.put(id, book);

        return id;
    }

    public static Book getBook(int bookId){
        if(books.containsKey(bookId)){
            return books.get(bookId);
        }
        return null;
    }

    public static Courses getCourse(int courseId) {
        if(courses.containsKey(courseId)){
            return courses.get((courseId));
        }
        return null;
    }

    public static int addCourse(Courses course) {
        int id=currentcourseId++;
        course.setId(id);
        courses.put(id, course);
        return id;
    }

    public static void deleteById(Integer id) {
        //TODO: process DELETE request

    }

    public static void deleteAllBooks() {
        //TODO: process DELETE request
        books.clear();

    }

    public static void deleteBookById(int id) {
        //TODO: process DELETE request
        books.remove(id);
    }

    public static Book getBookById(int id) {
        return books.get(id);
    }

    public static void updateBook(Book currentBook) {
        books.put(currentBook.getId(), currentBook);
        //TODO: process PUT request
    }
}
