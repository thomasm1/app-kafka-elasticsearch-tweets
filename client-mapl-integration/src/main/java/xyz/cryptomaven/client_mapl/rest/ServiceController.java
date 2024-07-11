package xyz.cryptomaven.client_mapl.rest;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;


@RestController
public class ServiceController {

    final private ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        super();
        this.serviceRepository = serviceRepository;
    }

    @PostMapping("/services")
    ResponseEntity<Service> registerNewService(@RequestBody Service registerServiceRequest) {

        Service newService = Service.register(registerServiceRequest.getName());

        URI newServiceLocation = serviceUri( newService.getId() );


        return ResponseEntity
                .created( newServiceLocation )
                .body( newService );

    }

    private URI serviceUri(UUID id) {
      return  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }

    @Contract(" -> new")
    @NotNull
    public static Service register() {
        return new Service(UUID.randomUUID());
    }

    @GetMapping("/services/{id}")
    Service getService(@NotNull @PathVariable UUID id) {
        Service service = this.serviceRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return service;
    }
}
