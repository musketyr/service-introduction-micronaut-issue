package hello.paris.jug.at.agorapulse;

import com.agorapulse.gru.Gru;
import com.agorapulse.gru.HttpStatusShortcuts;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static com.agorapulse.gru.HttpStatusShortcuts.UNAUTHORIZED;

@MicronautTest
class MessageControllerTest {

    @Inject
    Gru gru;

    @Test
    void testGetAllMessages() throws Throwable {
        gru.verify(test -> test
                .get("/message")
                .expect(resp -> resp.json("listMessages.json"))
        );
    }

    @Test
    void testCreateMessage() throws Throwable {
        gru.verify(test -> test
                .post("/message", req -> req.json("createMessageRequest.json").header("x-user", "vlad"))
                .expect(resp -> resp.json("createMessageResponse.json"))
        );
    }

    @Test
    void testCreateMessageNoUser() throws Throwable {
        gru.verify(test -> test
                .post("/message", req -> req.json("createMessageRequest.json"))
                .expect(resp -> resp.status(UNAUTHORIZED))
        );
    }

}