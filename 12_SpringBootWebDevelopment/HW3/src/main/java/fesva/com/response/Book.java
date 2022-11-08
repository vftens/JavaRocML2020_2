package fesva.com.response;

public class Book {
    private int id;
    private String name;
    private int year;
    private Object isRead;
    private Object priority; // can be null
    private Object author;  // can be null

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Object getIsRead() {
        return isRead;
        //return isRead;
    }

    public void setIsRead(Object isRead) {
        this.isRead = isRead;
        //this.isRead = isRead;
    }

    public Object getPriority() {
        return priority;
    }

    public void setPriority(Object priority) {
        this.priority = priority;
        //this.priority = priority;
    }

    public Object getAuthor() {
        return author;
        //
    }

    public void setAuthor(Object author) {
        this.author = author;
        //this.author = author; // can be null?
    }

    public Object getTitle() {
        return name; // can be null?
    }

    public void setTitle(Object title) {
        this.name = name;
        //this.title = title; // can be null?
    }
}
