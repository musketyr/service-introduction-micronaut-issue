package hello.paris.jug.at.agorapulse;

import jakarta.inject.Singleton;

@Singleton
public class DefaultMessageService implements MessageService {

    @Override
    public Message create(Message newMessage) {
        return newMessage;
    }

}
