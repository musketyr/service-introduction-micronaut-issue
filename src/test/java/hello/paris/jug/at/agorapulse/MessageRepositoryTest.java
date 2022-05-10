package hello.paris.jug.at.agorapulse;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class MessageRepositoryTest {

    @Inject MessageRepository messageRepository;

    @Test
    void testSaveAndList() {
        Message message = Message.create("vlad", "Salut, Paris!");

        assertNotNull(messageRepository.save(message));

        List<Message> messages = messageRepository.findAllByAuthor("vlad");

        assertNotNull(messages);
        assertEquals(1, messages.size());

        assertEquals("Salut, Paris!", messages.iterator().next().getBody());
    }

}