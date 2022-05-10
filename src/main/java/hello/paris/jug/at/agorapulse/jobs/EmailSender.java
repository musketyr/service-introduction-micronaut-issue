package hello.paris.jug.at.agorapulse.jobs;

import jakarta.inject.Singleton;

@Singleton
public class EmailSender {

    public void sendEmail(String to, String body) {
        System.out.println("Email to " + to + " with body " + body);
    }

}
