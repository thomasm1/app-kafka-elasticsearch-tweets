package app.mapl.models.auth;

import jdk.jfr.Event;
import lombok.Data;

import java.util.Map;

@Data
public class UserEvent {
    private User user;
    private EventType type;
    private Map<?, ?> data;

    public <S extends Object> UserEvent(S userEntity, EventType registration, Map<String, Object> key) {
    }

    public int getType(EventType type) {
    return type.ordinal();
    }
}
