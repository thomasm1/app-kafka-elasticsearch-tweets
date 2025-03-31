package app.mapl.rest.services;

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
public class Service {
    @Id
    private UUID id;
    private String name;

    public Service() {
    }

    public Service(UUID id, String name) {
        super();
        setId(id);
        setName(name);
    }

    public Service(UUID uuid) {
    }


    public static Service register(String name) {
        return new Service(UUID.randomUUID(), name );

    }

}
