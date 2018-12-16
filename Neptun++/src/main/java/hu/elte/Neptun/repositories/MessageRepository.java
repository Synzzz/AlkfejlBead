package hu.elte.Neptun.repositories;

import hu.elte.Neptun.entities.Message;
import hu.elte.Neptun.entities.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Nem tudom kell e ide meg valami

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
    public Optional<Iterable<Message>> findAllBySender(User sender);
    public Optional<Iterable<Message>> findAllByAddressee(User addressee);

}
