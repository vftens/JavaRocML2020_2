package com.fesva;

//import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class SubscriptionsId implements Serializable {
    public SubscriptionsId(){}

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    //@Column
    @ManyToOne
    private Student student;

    //@Column
    @ManyToOne
    private Course course;

    // Добавьте еще геттеры/сеттеры и конструктор
}