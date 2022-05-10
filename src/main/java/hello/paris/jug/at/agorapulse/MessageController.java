package hello.paris.jug.at.agorapulse;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.Collections;
import java.util.List;

@Controller("/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Get("/")
    public List<Message> getAllMessages() {
        return Collections.singletonList(Message.create("vlad", "Salut, Paris!"));
    }

    @Post("/")
    public Message createMessage(String author, String body) {
        return messageService.create(Message.create(author, body));
    }
}
