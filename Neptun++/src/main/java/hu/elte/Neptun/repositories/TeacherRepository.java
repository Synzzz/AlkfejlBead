package hu.elte.Neptun.repositories;

import hu.elte.Neptun.entities.Teacher;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    public Optional<Teacher> findByName(String name);
}
