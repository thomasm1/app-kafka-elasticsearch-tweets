package app.mapl.rest.mapl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class MaplTopic {
    @Id
    private UUID id;

    private String topic;

    public MaplTopic(UUID id) {
        this.id = id;
    }

    public MaplTopic(UUID id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    public MaplTopic cloneTopic() {
        return new MaplTopic(id, topic);
    }

    public static MaplTopic makeMaplTopic(String topic) {
        return new MaplTopic(UUID.randomUUID(), topic);
    }
}
