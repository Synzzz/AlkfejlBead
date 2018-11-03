package hu.elte.Neptun.repositories;

import hu.elte.Neptun.entities.Subject;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    public Optional<Subject> findByName(String name);

}
