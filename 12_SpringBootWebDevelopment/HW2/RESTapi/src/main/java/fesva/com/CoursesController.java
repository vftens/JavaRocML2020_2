package fesva.com;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class CoursesController {
    @GetMapping("/courses")
    public String index() {
        return (new Date()).toString();
    }

    public ResponseEntity getCourse(int id) {
        Courses course = Storage.getCourse(id);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(course, HttpStatus.OK);
    }

    @PostMapping("/courses")
    public int add(Courses course) {
        return Storage.addCourse(course);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Courses course = Storage.getCourse(id);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(course, HttpStatus.OK);
    }

}
