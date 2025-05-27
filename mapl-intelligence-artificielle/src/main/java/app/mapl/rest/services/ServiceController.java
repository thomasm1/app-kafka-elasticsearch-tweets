package app.mapl.rest.services;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
 import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@Tag(
        name = "POST API for Resource",
        description = "Creates a new Resource"
)
@CrossOrigin(origins = "*")
@RequestMapping("/pods")
@RestController
public class ServiceController {

    final private ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        super();
        this.serviceRepository = serviceRepository;
    }


    @Operation(
            summary = "makeNew Resource",
            description = " makeNew Resource; pass Name //    {  \"name\":\"any-name\"   } save to database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 SUCCESS",
            content = @Content(mediaType = "id:6a81b3c3-c0c3-4bc6-8bb7-7f80eca45812,name:any-name")
    )
    @PostMapping("/services")
    ResponseEntity<Service> registerNewService(@RequestBody Service registerServiceRequest) {

        Service newService = Service.register(registerServiceRequest.getName());

        this.serviceRepository.save(newService);

        URI newServiceLocation = serviceUri( newService.getId() );


        return ResponseEntity
                .created( newServiceLocation )
                .body( newService );
    }

    URI serviceUri(UUID id) {
      return  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }


    @GetMapping("/services/{id}")
    Service getService( @PathVariable UUID id) {
        Service service = this.serviceRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return service;
    }
}
