package app.mapl.rest.services;

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
    public static ServiceResponse demoResponse() {
        return new ServiceResponse(UUID.randomUUID());
    }
}