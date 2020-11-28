package com.fesva;

import javax.persistence.*;

@Entity
@Table(name = "PurchaseList")
public class Purchases {

    public Purchases(){}

    @Column(name = "course_name")
    private String courseName;

    //@OneToMany(mappedBy = "PurchaseList")
    @Column(name = "student_name")
    private String studentName;



    @Column(name = "price")
    private float price;
    @Column(name = "subscription_date")
    private String subscriptionDate;

    public Purchases(String courseName, String studentName, float price, String subscriptionDate) {
        this.courseName = courseName;
        this.studentName = studentName;
        this.price = price;
        this.subscriptionDate = subscriptionDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(String subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @PrePersist
    void prePersist() {
    }

    @PreUpdate
    void preUpdate() {
    }

    @PreRemove
    void preRemove() {
    }

    @PostLoad
    void postLoad() {
    }

    @PostRemove
    void postRemove() {
    }

    @PostUpdate
    void postUpdate() {
    }

    @PostPersist
    void postPersist() {
    }
}
