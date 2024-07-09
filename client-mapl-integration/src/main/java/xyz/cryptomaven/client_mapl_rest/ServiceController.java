package xyz.cryptomaven.client_mapl_rest;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;


@RestController
public class ServiceController {
    @PostMapping("/services")
    ResponseEntity<Service> registerNewService(@RequestBody Service registerServiceRequest) {

        Service newService = Service.register(registerServiceRequest.getName());

        URI newServiceLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newService.getId())
                .toUri();


        return ResponseEntity.created(newServiceLocation).body(newService);

    }

    @Contract(" -> new")
    @NotNull
    public static Service register() {
        return new Service(UUID.randomUUID());
    }

    @GetMapping("/services/{id}")
    void getService(@NotNull @PathVariable UUID id) {}
}
