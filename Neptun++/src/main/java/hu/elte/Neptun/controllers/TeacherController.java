package hu.elte.Neptun.controllers;

import hu.elte.Neptun.entities.Course;
import hu.elte.Neptun.entities.Teacher;
import hu.elte.Neptun.repositories.CourseRepository;
import hu.elte.Neptun.repositories.TeacherRepository;
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
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;
    
    @Autowired
    CourseRepository courseRepository;
    
    @PostMapping("/register")
    public ResponseEntity<Teacher> register(@RequestBody Teacher teacher) {
        Optional<Teacher> oTeacher = teacherRepository.findById(teacher.getId());
        
        if (oTeacher.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        
        teacher.setId(null);
        
        return ResponseEntity.ok(teacherRepository.save(teacher));
    }
    
    @PostMapping("/login")
    public ResponseEntity<Teacher> login(@RequestBody Teacher teacher) {
        //MÉG NINCS KÉSZ
        return ResponseEntity.badRequest().build();
    }
    
     @PostMapping("/{id}/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course, @PathVariable Integer id) {
        Optional<Teacher> oTeacher = teacherRepository.findById(id);
        
        if(!oTeacher.isPresent()) {
            return ResponseEntity.notFound().build();  
        }
        
        course.setTeacher(oTeacher.get());
        courseRepository.save(course);
        
        return ResponseEntity.ok(course);
    }
    
    @GetMapping("/{id}/courses")
    public ResponseEntity<Iterable<Course>> getCourses(@PathVariable Integer id) {
        Optional<Teacher> oTeacher = teacherRepository.findById(id);
        
        if (!oTeacher.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oTeacher.get().getCourses());
    }
}
