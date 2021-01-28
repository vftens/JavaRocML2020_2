import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class LinkedPurchaseList implements Serializable {
    public LinkedPurchaseList() {

    }

    private int student_id;
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

