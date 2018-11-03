package hu.elte.Neptun.controllers;

import hu.elte.Neptun.entities.Course;
import hu.elte.Neptun.entities.Student;
import hu.elte.Neptun.entities.SubjectRegistration;
import hu.elte.Neptun.repositories.StudentRepository;
import hu.elte.Neptun.repositories.SubjectRegistrationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    
    @Autowired
    SubjectRegistrationRepository subjectRegistratorRepository;
    
    @PostMapping("/register")
    public ResponseEntity<Student> register(@RequestBody Student student) {
        //CSAK HA TANÁR VAGY
        /*Optional<Student> oStudent = studentRepository.findById(student.getId());//ha a JSON-ből nem jön id itt kiakad null miatt
        
        if (oStudent.isPresent()) {
            return ResponseEntity.badRequest().build();
        }*/
        
        return ResponseEntity.ok(studentRepository.save(student));
    }
    
    @PostMapping("/login")
    public ResponseEntity<Student> login(@RequestBody Student student) {
        //MÉG NINCS KÉSZ
        return ResponseEntity.badRequest().build();
    }
    
    @PostMapping("/{id}/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course, @PathVariable Integer id) {
        Optional<Student> oStudent = studentRepository.findById(id);
        
        if(!oStudent.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        List<Course> courses = oStudent.get().getCourses();
        
        if(courses.contains(course)){
            return ResponseEntity.badRequest().build();
        }
        
        SubjectRegistration reg = new SubjectRegistration();
        reg.setCourse(course);
        reg.setStudent(oStudent.get());
        
        subjectRegistratorRepository.save(reg);
        
        return ResponseEntity.ok(course);
    }
    
    @DeleteMapping("/{id}/{registrationID}")
    public ResponseEntity deleteCourse(@PathVariable Integer id, @PathVariable Integer registrationID) {
        Optional<Student> oStudent = studentRepository.findById(id);
        Optional<SubjectRegistration> oRegistration = subjectRegistratorRepository.findById(registrationID);
        
        if (!oStudent.isPresent() || !oRegistration.isPresent()) {
            return ResponseEntity.notFound().build();   
        }
        
        subjectRegistratorRepository.deleteById(registrationID);
        
        return ResponseEntity.ok().build();
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
