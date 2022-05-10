package hello.paris.jug.at.agorapulse.auth;

import com.agorapulse.permissions.PermissionAdvisor;
import com.agorapulse.permissions.PermissionCheckResult;
import hello.paris.jug.at.agorapulse.Message;
import io.micronaut.core.type.Argument;
import jakarta.inject.Singleton;

@Singleton
public class MessagePermissionAdvisor implements PermissionAdvisor<Message> {

    private final UserProvider userProvider;

    public MessagePermissionAdvisor(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    public Argument<Message> argumentType() {
        return Argument.of(Message.class);
    }

    @Override
    public PermissionCheckResult checkPermissions(String permissionDefinition, Message value, Argument<Message> argument) {
        return userProvider.getCurrentUser().map(user -> {
            if ("create".equals(permissionDefinition)) {
                if (user.getUsername().equals(value.getAuthor())) {
                    return PermissionCheckResult.ALLOW;
                }
                return PermissionCheckResult.DENY;
            }
            return PermissionCheckResult.UNKNOWN;
        }).orElse(PermissionCheckResult.UNKNOWN);
    }
}
