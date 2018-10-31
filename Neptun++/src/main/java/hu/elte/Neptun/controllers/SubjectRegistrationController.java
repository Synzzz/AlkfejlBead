package hu.elte.Neptun.controllers;

import hu.elte.Neptun.repositories.SubjectRegistrationRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subjectRegistration")
public class SubjectRegistrationController {
    SubjectRegistrationRepository subjectRegistratorRepository;
    
    //IDE KÉNE MÉG A TANTÁRGY HOZZÁADÁSA(TANÁR) + TANTÁRGY FELVÉTELE/LEADÁSA(DIÁK)
}
