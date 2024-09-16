package app.mapl.rest.mapl;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class MaplTopicResponse {
    private UUID id;
    private String topic;

    MaplTopicResponse() {
    }

    MaplTopicResponse(UUID id) {
        super();
        setId(id);
    }
    public static MaplTopicResponse demoResponse() {
        return new MaplTopicResponse(UUID.randomUUID());
    }
}