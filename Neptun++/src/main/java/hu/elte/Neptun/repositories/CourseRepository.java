package hu.elte.Neptun.repositories;

import hu.elte.Neptun.entities.Course;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Nem tudom kell e ide meg valami

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    public Optional<Course> findByTeacher(String teacher);

}
