package xyz.cryptomaven.client_mapl.rest.mapl;

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

    public MaplTopic(UUID id) {}
    public MaplTopic(UUID id, String topic) {}



    public static MaplTopic makeMaplTopic(String topic) {
        return new MaplTopic(UUID.randomUUID(), topic);
    }

}
