package xyz.cryptomaven.client_mapl.rest.services;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class ServiceResponse {
    private UUID id;
    private String name;

    ServiceResponse() {
    }

    ServiceResponse(UUID id) {
        super();
        setId(id);
    }
    public static ServiceResponse fakeStudent() {
        return new ServiceResponse(UUID.randomUUID());
    }
}