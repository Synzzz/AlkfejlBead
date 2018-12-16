package hu.elte.Neptun.controllers;
import hu.elte.Neptun.entities.Course;
import hu.elte.Neptun.entities.User;
import hu.elte.Neptun.repositories.CourseRepository;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Course>> getAll() {
        return ResponseEntity.ok(courseRepository.findAll());
    }
    
    @GetMapping("/{id}/teacher")
    public ResponseEntity<User> getTeacher(@PathVariable Integer id) {
        Optional<Course> oCourse = courseRepository.findById(id);
        if (!oCourse.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oCourse.get().getTeacher());
    }
    
    @GetMapping("/{id}/studentCount")
    public ResponseEntity<Integer> getStudentCount(@PathVariable Integer id) {
        Optional<Course> oCourse = courseRepository.findById(id);
        if (!oCourse.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oCourse.get().getStudentCount());
    }
    
    @GetMapping("/{id}/studentLimit")
    public ResponseEntity<Integer> getStudentLimit(@PathVariable Integer id) {
        Optional<Course> oCourse = courseRepository.findById(id);
        if (!oCourse.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oCourse.get().getStudentLimit());
    }
    

}
