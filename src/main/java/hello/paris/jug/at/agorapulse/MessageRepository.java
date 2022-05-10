package hello.paris.jug.at.agorapulse;

import com.agorapulse.micronaut.amazon.awssdk.dynamodb.annotation.Service;

import java.util.List;

@Service(Message.class)
public interface MessageRepository {

    Message save(Message message);

    List<Message> findAllByAuthor(String author);

}
