//import model.Course;
//port model.Student;

import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Subselect("SELECT s.id student_id, c.id course_id, pu.price price, subscription_date " +
        "FROM PurchaseList pu " +
        "JOIN Students s ON student_name = s.name " +
        "JOIN Courses c ON course_name = c.name")
@Synchronize({"LinkedPurchaseList", "Students", "Courses"})
public class Purchase {
    @EmbeddedId
    private PurchaseID id;

    @Column(name = "price")
    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Purchase(Student student, Course course, float price, Date subscriptionsDate) {
    }

    public PurchaseID getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }
}

//  SELECT Students.id student_id,
//		student_name student,
//		Courses.id course_id,
//		course_name course,
//		registration_date
//  FROM PurchaseList
//  JOIN Students ON student_name = Students.name
//  JOIN Courses ON course_name = Courses.name;
