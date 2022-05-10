package hello.paris.jug.at.agorapulse.jobs;

import com.agorapulse.worker.annotation.Cron;
import com.agorapulse.worker.annotation.FixedRate;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

@Singleton
public class EmailDigestJob {

    private final EmailSender emailSender;
    private final EmailRepository emailRepository;

    public EmailDigestJob(EmailSender emailSender, EmailRepository emailRepository) {
        this.emailSender = emailSender;
        this.emailRepository = emailRepository;
    }

    @Cron("45 6 * * *")
    public Publisher<String> getEmailsForDigest() {
        return Flux.fromIterable(emailRepository.getEmailsForDigest());
    }

    @FixedRate("1h")
    public void sendEmail(String email) {
        emailSender.sendEmail(email, "Bonjour!");
    }


}
