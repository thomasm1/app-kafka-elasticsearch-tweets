package xyz.cryptomaven.client_mapl_rest;

import lombok.Data;

import java.util.UUID;

@Data
public class RegisterServiceRequest {
    private UUID id;
    private String name;
    ;
    public RegisterServiceRequest(String name) {
        this.id = UUID.randomUUID();
    }

}
