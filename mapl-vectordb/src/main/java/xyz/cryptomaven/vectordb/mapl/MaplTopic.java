package xyz.cryptomaven.vectordb.mapl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Setter
@Getter
@Entity
public class MaplTopic {
    @Id
    private UUID id;

    private String topic;

    public MaplTopic() {}

    public MaplTopic(UUID id) {
        this.id = id;
    }
    public MaplTopic(UUID id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    public  MaplTopic getMaplTopic() {
        return new MaplTopic(id, topic);
    }

    public static MaplTopic makeMaplTopic(String topic) {

        return new MaplTopic(UUID.randomUUID(), topic);
    }

}
