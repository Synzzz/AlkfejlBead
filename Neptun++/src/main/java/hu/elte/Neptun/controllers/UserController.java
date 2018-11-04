package hu.elte.Neptun.controllers;

import hu.elte.Neptun.entities.Course;
import hu.elte.Neptun.entities.Subject;
import hu.elte.Neptun.entities.User;
import hu.elte.Neptun.repositories.CourseRepository;
import hu.elte.Neptun.repositories.UserRepository;
import hu.elte.Neptun.entities.SubjectRegistration;
import hu.elte.Neptun.repositories.SubjectRegistrationRepository;
import hu.elte.Neptun.repositories.SubjectRepository;
import java.util.List;
import java.util.Objects;
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
    SubjectRepository subjectRepository;
    
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
    //@Secured({ "ROLE_ADMIN", "ROLE_USER" })
    public ResponseEntity<User> login(@RequestBody User user) {
        Optional<User> oUser = userRepository.findByName(user.getName());
        
        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oUser.get());
    }
    
    //tárgyfelvétel usernek
    @PostMapping("/{id}/takeCourse")
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })//ROLE_ADMIN CSAK TESZTELÉSHEZ KELL
    public ResponseEntity<SubjectRegistration> takeCourse(@RequestBody Course course, @PathVariable Integer id) {
        Optional<User> oStudent = userRepository.findById(id);
        Optional<Course> oCourse = courseRepository.findById(course.getId());
        
        if(!oStudent.isPresent() || !oCourse.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        if(Objects.equals(oCourse.get().getStudentCount(), oCourse.get().getStudentLimit())){
            return ResponseEntity.badRequest().build();
        }
        
        List<Course> courses = oStudent.get().getCourses();
        
        if(courses.contains(oCourse.get())){
            return ResponseEntity.badRequest().build();
        }
        
        oCourse.get().setStudentCount(oCourse.get().getStudentCount() + 1);
        
        courses.add(oCourse.get());
        oStudent.get().setCourses(courses);
        
        SubjectRegistration reg = new SubjectRegistration();
        reg.setCourse(oCourse.get());
        reg.setStudent(oStudent.get());
        
        List<User> students = oCourse.get().getStudents();
        students.add(oStudent.get());
        oCourse.get().setStudents(students);
        
        userRepository.save(oStudent.get());
        courseRepository.save(oCourse.get());
        subjectRegistratorRepository.save(reg);
        
        return ResponseEntity.ok(reg);
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
        
        Course course = oRegistration.get().getCourse();
        List<User> students = course.getStudents();
        students.remove(oUser.get());
        course.setStudents(students);
        course.setStudentCount(course.getStudentCount() - 1);
        
        List<Course> courses = oUser.get().getCourses();
        courses.remove(course);
        oUser.get().setCourses(courses);
        
        courseRepository.save(course);
        userRepository.save(oUser.get());
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
        System.out.println(course);
        Optional<User> oTeacher = userRepository.findById(id);
        Optional<Subject> oSubject = subjectRepository.findById(course.getSubject().getId());//valamiért a subject null, nem olvassa be json-ből nálam
        
        if(!oTeacher.isPresent() || !oSubject.isPresent()) {
            return ResponseEntity.notFound().build();  
        }
        
        course.setTeacher(oTeacher.get());
        courseRepository.save(course);
        List<Course> courses = oSubject.get().getCourses();
        courses.add(course);
        oSubject.get().setCourses(courses);
        subjectRepository.save(oSubject.get());
        
        return ResponseEntity.ok(course);
    }
    
    @GetMapping("")
    @Secured({ "ROLE_ADMIN" })
    public ResponseEntity<Iterable<User>> getAll() {
        Iterable<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
    
}
