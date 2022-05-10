package hello.paris.jug.at.agorapulse.auth;

import java.util.Optional;

public interface UserProvider {

    Optional<User> getCurrentUser();

}
