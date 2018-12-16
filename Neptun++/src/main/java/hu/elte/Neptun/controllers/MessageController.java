package hu.elte.Neptun.controllers;
import hu.elte.Neptun.entities.Message;
import hu.elte.Neptun.entities.User;
import hu.elte.Neptun.repositories.MessageRepository;
import hu.elte.Neptun.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
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
    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    public ResponseEntity<Iterable<Message>> getSender(@PathVariable Integer id) {
        Optional<User> oUser = userRepository.findById(id);
        
        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        Optional<Iterable<Message>> oMessages = messageRepository.findAllBySender(oUser.get());
        
         if (!oMessages.isPresent()) {
            return ResponseEntity.ok(new ArrayList<>());
        }
        
        return ResponseEntity.ok(oMessages.get());
    }
    
    @GetMapping("/{id}/addressee")
    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    public ResponseEntity<Iterable<Message>> getAdressee(@PathVariable Integer id) {
        Optional<User> oUser = userRepository.findById(id);
        
        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        Optional<Iterable<Message>> oMessages = messageRepository.findAllByAddressee(oUser.get());
        
        if (!oMessages.isPresent()) {
            return ResponseEntity.ok(new ArrayList<>());
        }
        
        return ResponseEntity.ok(oMessages.get());
    }
    
    @PostMapping("/sendMessage")
    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        //itt menjen, username vagy id? mindkettő egyedi úgyis
        System.out.println(message.getMessage());
        System.out.println(message.getSender() == null);
        System.out.println(message.getAddressee() == null);
        
        Optional<User> oSender = userRepository.findByUsername(message.getSender().getUsername());
        Optional<User> oAddressee = userRepository.findByUsername(message.getAddressee().getUsername());
        
        if(!oAddressee.isPresent() || !oSender.isPresent() ) {
            return ResponseEntity.notFound().build();  
        }
        
        System.out.println(oSender.get().getName() + " " + oAddressee.get().getName());
        
        message.setSender(oSender.get());
        message.setAddressee(oAddressee.get());
        messageRepository.save(message);

        return ResponseEntity.ok(message);
    }
}
