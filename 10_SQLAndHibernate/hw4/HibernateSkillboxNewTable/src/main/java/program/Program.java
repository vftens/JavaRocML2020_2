package program;

import dao.DAO;
import model.Course;
import model.Student;
import model.Teacher;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;

public class Program {
    public static void main(String args) { //
        Student student = (Student)DAO.getObjectById(11L, Student.class);
        System.out.println(student);
        Teacher teacher = (Teacher) DAO.getObjectById(1L, Teacher.class);
        System.out.println(teacher);
        List<Course> courses = teacher.getCourses();
        Hibernate.initialize(courses);
        System.out.println(courses);
        List<Course> courses1 = student.getCourses();
        System.out.println(courses1);
        Course course=(Course) DAO.getObjectById(21L,Course.class);
        System.out.println(course);
        List<Student> students = course.getList();
        System.out.println(students);
        LocalDateTime data = student.getDateTime();
        System.out.println(data);
        DAO.closeOpenedSession();
    }
}
