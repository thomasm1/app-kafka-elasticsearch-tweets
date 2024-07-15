package xyz.cryptomaven.client_mapl.rest;

import lombok.Data;

import java.util.UUID;

@Data
public class RegisterServiceRequest {
    private String name;

    public RegisterServiceRequest() {}

    public RegisterServiceRequest(String name) {
        this.name = name;
    }

}
