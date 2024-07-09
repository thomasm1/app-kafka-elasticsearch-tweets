package xyz.cryptomaven.client_mapl_rest;

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
}