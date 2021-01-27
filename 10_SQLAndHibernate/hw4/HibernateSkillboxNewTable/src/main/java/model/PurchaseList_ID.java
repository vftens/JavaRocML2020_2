package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "PurchaseList_ID")
public class PurchaseList_ID {
    @Id
    @GeneratedValue
    private Long id;
    private String student_name;
    private String course_name;
    private String price;
    private LocalDateTime subscription_data;

    public PurchaseList_ID() {

    }

    public PurchaseList_ID(String student_name, String course_name, String price, LocalDateTime subscription_data) {
        this.student_name = student_name;
        this.course_name = course_name;
        this.price = price;
        this.subscription_data = subscription_data;
    }

    @Override
    public String toString() {
        return "PurchaseList_ID{" +
                "id=" + id +
                ", student_name='" + student_name + '\'' +
                ", course_name='" + course_name + '\'' +
                ", price=" + price +
                ", subscription_data=" + subscription_data +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public LocalDateTime getSubscription_data() {
        return subscription_data;
    }

    public void setSubscription_data(LocalDateTime subscription_data) {
        this.subscription_data = subscription_data;
    }
}
