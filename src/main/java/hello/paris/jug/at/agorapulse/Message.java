package hello.paris.jug.at.agorapulse;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.core.annotation.Introspected;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.time.Instant;

@Introspected
@DynamoDbBean
public class Message {

    public static Message create(String author, String body) {
        Message message = new Message();
        message.setAuthor(author);
        message.setBody(body);
        message.setCreated(Instant.now());
        return message;
    }

    private String author;
    private String body;
    private Instant created;

    @DynamoDbPartitionKey
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @DynamoDbSortKey()
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("author='").append(author).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", created=").append(created);
        sb.append('}');
        return sb.toString();
    }
}
