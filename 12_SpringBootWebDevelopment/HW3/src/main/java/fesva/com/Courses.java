package fesva.com;

import static org.python.bouncycastle.asn1.x500.style.RFC4519Style.c;

// class for handling the events from the application of the books library 
public class Courses {
    private int id;
    private String name;
    private int year;

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

    // public void aVoid() { this.} // ВОЗВРАЩАЕТ список КОЛ-ВО Курсов???
        //public static void main(String[] args) {
        //Courses courses = new Courses();
        //courses.setId(1);
    //
}
