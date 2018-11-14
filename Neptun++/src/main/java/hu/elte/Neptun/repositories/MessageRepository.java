package hu.elte.Neptun.repositories;

import hu.elte.Neptun.entities.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Nem tudom kell e ide meg valami

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
    public Optional<Message> findBySender(String sender);
    public Optional<Message> findByRecipient(String recipient);

}
