package xyz.cryptomaven.client_mapl_rest;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Setter
@Getter
public class Service {
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
