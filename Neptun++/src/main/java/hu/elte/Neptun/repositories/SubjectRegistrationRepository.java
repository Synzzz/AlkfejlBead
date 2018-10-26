package hu.elte.Neptun.repositories;

import hu.elte.Neptun.entities.SubjectRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRegistrationRepository extends CrudRepository<SubjectRegistration, Integer> {
    
}
