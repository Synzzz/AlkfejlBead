package hu.elte.Neptun.controllers;

import hu.elte.Neptun.entities.Course;
import hu.elte.Neptun.entities.SubjectRegistration;
import hu.elte.Neptun.repositories.SubjectRegistrationRepository;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subjectRegistration")
public class SubjectRegistrationController {
    SubjectRegistrationRepository subjectRegistratorRepository;
}
