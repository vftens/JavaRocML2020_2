import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Subscriptions")
public class LinkedPurchaseList implements Serializable {

    public LinkedPurchaseList() {
    }

    @Column(name = "student_id", insertable = false, updatable = false)
    private int student_id;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int course_id;

    public LinkedPurchaseList(int student_id, int course_id) {
        super();
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public int getstudent_id() {
        return student_id;
    }

    public void setstudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getcourse_id() {
        return course_id;
    }

    public void setcourse_id(int course_id) {
        this.course_id = course_id;
    }

    @EmbeddedId
    private Subscription.SubscriptionPK key;

    @Column(name = "subscription_date")
    private Date subscriptionsDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    protected Course course; // model.

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    protected Student student; // model.

    public Subscription.SubscriptionPK getKey() {
        return key;
    }

    public Date getSubscriptionsDate() {
        return subscriptionsDate;
    }

    public void setSubscriptionsDate(Date subscriptionsDate) {
        this.subscriptionsDate = subscriptionsDate;
    }

    public Course getCourse() {
        return course;
    } // model.

    public Student getStudent() {
        return student;
    } // model.



    /*
    public Date getSubscriptionsDate() {
        return subscriptionsDate;
    }

    public void setSubscriptionsDate(Date subscriptionsDate) {
        this.subscriptionsDate = subscriptionsDate;
    }



    public Course getCourse() {
        return course;
    } // model.

    public Student getStudent() {
        return student;
    } // model.


     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + course_id;
        result = prime * result + student_id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LinkedPurchaseList other = (LinkedPurchaseList) obj;
        if (course_id != other.course_id)
            return false;
        if (student_id != other.student_id)
            return false;
        return true;
    }
}

