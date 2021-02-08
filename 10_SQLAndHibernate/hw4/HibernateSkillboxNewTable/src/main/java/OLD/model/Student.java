package model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Students")
public class Student { // <mapping class="model.Student"></mapping> ???
    // org.hibernate.AnnotationException: Use of @OneToMany or @ManyToMany targeting an unmapped class: model.Student.coursesList[model.Course]

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @Column(name = "registration_date")
 //   private String dateTime;
    private LocalDateTime dateTime;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "Subscriptions",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    List<Course> coursesList=new ArrayList<>();

    public Student(List<Course> courses) {
        this.coursesList = courses;
    }

    public List<Course> getCourses() {
        return coursesList;
    }

    public void setCourses(List<Course> courses) {
        this.coursesList = courses;
    }

    public Student() {
    }

    public Student(String name, int age, LocalDateTime dateTime) {
        this.name = name;
        this.age = age;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dateTime=" + dateTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
