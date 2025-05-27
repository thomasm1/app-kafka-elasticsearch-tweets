package xyz.cryptomaven.vectordb.mapl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;


@Tag(
        name = "CRUD REST APIs for Topicr Resource",
        description = "CRUD REST APIs - Create Topicr, Update Topic, Get Topic, Get All Topics, Delete Topic"
)
@RequestMapping(value="ai")
@CrossOrigin(origins = "*")
@RestController
public class MaplTopicController {

    private final ChatClient maplClient;

    private final MaplRepository maplRepository;


    public MaplTopicController(ChatClient.Builder maplClient, MaplRepository maplRepository) {
        super();
        this.maplClient = maplClient.build();
        this.maplRepository = maplRepository;
    }


    @Operation(
            summary = "makeNewMaplTopic",
            description = " makeNewMaplTopic & save to database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 SUCCESS"
    )
    @PostMapping("/mapl-topic")
    ResponseEntity<MaplTopic> makeNewMaplTopic(@RequestBody MaplTopic makeNewMaplTopic) {

        MaplTopic newMaplTopic = MaplTopic.makeMaplTopic(makeNewMaplTopic.getTopic());

        this.maplRepository.save(newMaplTopic);

        URI newMaplTopicLocation = maplTopicUri( newMaplTopic.getId() );


        return ResponseEntity
                .created( newMaplTopicLocation )
                .body( newMaplTopic );
    }

    URI maplTopicUri(UUID id) {
        return  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
    @Operation(
            summary = "Get All mapl-topic-string REST API",
            description = "Get All mapl-topic-string"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
@GetMapping("/mapl-topic/{id}")
MaplTopic getMaplTopicById(@NotNull @PathVariable UUID id)  {
    Optional<MaplTopic> maplTopic = Optional.ofNullable(this.maplRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return maplTopic.get();
}
    @Operation(
            summary = "Get All mapl-topic-string REST API",
            description = "Get All mapl-topic-string"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS; "
    )
    @GetMapping("/mapl-topics")
    public Flux<String> getMaplTopics() {
        return maplClient.prompt()
                .user("I am going to Paris and and Valenciennes, what are 10 places I should see first in each place: \n EXPECTED RESPONSE - ")
                .stream()   // StreamResponseSpec
                .content();
    }
    @Operation(
            summary = "Get All mapl-topic-string REST API",
            description = "Get All mapl-topic-string"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/mapl-topic-string")
    public String maplTopicString(String topic) {

        return  maplClient.prompt()
                .user(u -> {
                    u.text("Tell me a fact about {topic}");
                    u.param("topic", topic);
                })
                .call()
                .content();
    }

    @GetMapping("/mapl")
    public String inquire()    {
        return maplClient.prompt()   // ChatClientRequest
                .user("Tell me fact about the world")
                .call()   // CallResponseSpec
                .content();
    }

    @GetMapping("/test")
    public String test() {
        return "Test";
    }
}
