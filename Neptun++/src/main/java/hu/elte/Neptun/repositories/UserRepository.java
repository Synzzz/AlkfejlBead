package hu.elte.Neptun.repositories;

import hu.elte.Neptun.entities.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public Optional<User> findByName(String name);
    public Optional<User> findByUsername(String username);
}

