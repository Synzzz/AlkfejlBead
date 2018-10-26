package hu.elte.Neptun.repositories;

import hu.elte.Neptun.entities.Student;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    public Optional<Student> findByName(String name);
}

