package hu.elte.Neptun.controllers;

import hu.elte.Neptun.entities.Subject;
import hu.elte.Neptun.repositories.SubjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    SubjectRepository subjectRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Subject>> getAll() {
        return ResponseEntity.ok(subjectRepository.findAll());
    }
}
