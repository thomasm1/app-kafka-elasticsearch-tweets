package xyz.cryptomaven.client_mapl.rest.services;

import lombok.Data;

@Data
public class RegisterServiceRequest {
    private String name;

    public RegisterServiceRequest() {}

    public RegisterServiceRequest(String name) {
        this.name = name;
    }

}
