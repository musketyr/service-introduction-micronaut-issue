package hello.paris.jug.at.agorapulse;

import com.agorapulse.permissions.RequiresPermission;

public interface MessageService {

    @RequiresPermission("create")
    Message create(Message newMessage);

}
