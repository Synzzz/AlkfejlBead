package hu.elte.Neptun.controllers;

import hu.elte.Neptun.entities.Course;
import hu.elte.Neptun.entities.Student;
import hu.elte.Neptun.repositories.StudentRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    
    @PostMapping("/register")
    public ResponseEntity<Student> register(@RequestBody Student student) {
        //CSAK HA TANÁR VAGY
        Optional<Student> oStudent = studentRepository.findById(student.getId());
        
        if (oStudent.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        
        student.setId(null);
        
        return ResponseEntity.ok(studentRepository.save(student));
    }
    
    @PostMapping("/login")
    public ResponseEntity<Student> login(@RequestBody Student student) {
        //MÉG NINCS KÉSZ
        return ResponseEntity.badRequest().build();
    }
    
    @GetMapping("/{id}/courses")
    public ResponseEntity<Iterable<Course>> getCourses(@PathVariable Integer id) {
        Optional<Student> oStudent = studentRepository.findById(id);
        if (!oStudent.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oStudent.get().getCourses());
    }
}
