package app.mapl.models;

import jdk.jfr.Event;
import lombok.Data;

import java.util.Map;

@Data
public class UserEvent {
    private UserProfile user;
    private EventType type;
    private Map<?, ?> data;

    public int getType(EventType type) {
    return type.ordinal();
    }
}
