package hu.elte.Neptun.controllers;
import hu.elte.Neptun.entities.Message;
import hu.elte.Neptun.entities.User;
import hu.elte.Neptun.repositories.MessageRepository;
import hu.elte.Neptun.repositories.UserRepository;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserRepository userRepository;
    
    
    @GetMapping("")
    @Secured({ "ROLE_ADMIN" })
    public ResponseEntity<Iterable<Message>> getAll() {
        return ResponseEntity.ok(messageRepository.findAll());
    }
    
    @GetMapping("/{id}/sender")
    public ResponseEntity<User> getSender(@PathVariable Integer id) {
        Optional<Message> oMessage = messageRepository.findById(id);
        if (!oMessage.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oMessage.get().getSender());
    }
    
    @GetMapping("/{id}/recipient")
    public ResponseEntity<User> getRecipient(@PathVariable Integer id) {
        Optional<Message> oMessage = messageRepository.findById(id);
        if (!oMessage.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(oMessage.get().getRecipient());
    }
    
    @PostMapping("/{idSend}/{idRec}/postMessage/")
    @Secured({ "ROLE_ADMIN","ROLE_USER" })
    public ResponseEntity<Message> addCourse(@RequestBody Message message, @PathVariable Integer idSend,@PathVariable Integer idRec ) {
        //itt menjen, username vagy id? mindkettő egyedi úgyis
        Optional<User> oSender = userRepository.findById(idSend);
        Optional<User> oRecipient = userRepository.findById(idRec);
        
        if(!oRecipient.isPresent() || !oSender.isPresent() ) {
            return ResponseEntity.notFound().build();  
        }
        
        message.setSender(oSender.get());
        message.setRecipient(oRecipient.get());
        messageRepository.save(message);

        return ResponseEntity.ok(message);
    }
    

}
