package hu.elte.Neptun.controllers;

import hu.elte.Neptun.entities.Course;
import hu.elte.Neptun.entities.User;
import hu.elte.Neptun.repositories.CourseRepository;
import hu.elte.Neptun.repositories.UserRepository;
import hu.elte.Neptun.entities.SubjectRegistration;
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
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    SubjectRegistrationRepository subjectRegistratorRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    @Secured({ "ROLE_ADMIN" })
    public ResponseEntity<User> post(@RequestBody User user) {
        Optional<User> oUser = userRepository.findByUsername(user.getUsername());
        if (oUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        user.setId(null);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.ROLE_USER);
        return ResponseEntity.ok(userRepository.save(user));
    }
        
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User student) {
        //MÉG NINCS KÉSZ
        return ResponseEntity.badRequest().build();
    }
    
    //tárgyfelvétel usernek
    @PostMapping("/{id}/takeCourse")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<Course> takeCourse(@RequestBody Course course, @PathVariable Integer id) {
        Optional<User> oStudent = userRepository.findById(id);
        
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
    
    //tárgyleadás usernek
    @DeleteMapping("/{id}/{registrationID}")
    @Secured({ "ROLE_USER" })
    public ResponseEntity leaveCourse(@PathVariable Integer id, @PathVariable Integer registrationID) {
        Optional<User> oUser = userRepository.findById(id);
        Optional<SubjectRegistration> oRegistration = subjectRegistratorRepository.findById(registrationID);
        
        if (!oUser.isPresent() || !oRegistration.isPresent()) {
            return ResponseEntity.notFound().build();   
        }
        
        subjectRegistratorRepository.deleteById(registrationID);
        
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{id}/courses")
    public ResponseEntity<Iterable<Course>> getCourses(@PathVariable Integer id) {
        Optional<User> oUser = userRepository.findById(id);
        if (!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oUser.get().getCourses());
    }
    
    
    @PostMapping("/{id}/addCourse")
    @Secured({ "ROLE_ADMIN" })
    public ResponseEntity<Course> addCourse(@RequestBody Course course, @PathVariable Integer id) {
        Optional<User> oTeacher = userRepository.findById(id);
        
        if(!oTeacher.isPresent()) {
            return ResponseEntity.notFound().build();  
        }
        
        course.setTeacher(oTeacher.get());
        courseRepository.save(course);
        
        
        return ResponseEntity.ok(course);
    }
    
    @GetMapping("")
    @Secured({ "ROLE_ADMIN" })
    public ResponseEntity<Iterable<User>> getAll() {
        Iterable<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
    
}
