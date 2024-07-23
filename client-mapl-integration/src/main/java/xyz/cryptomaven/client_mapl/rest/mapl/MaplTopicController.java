package xyz.cryptomaven.client_mapl.rest.mapl;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
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

@CrossOrigin(origins = "*")
@RequestMapping("/ai")
@RestController
public class MaplTopicController {

    private final ChatClient maplClient;

    private final MaplRepository maplRepository;


    public MaplTopicController(ChatClient.Builder maplClient, MaplRepository maplRepository) {
        super();
        this.maplClient = maplClient.build();
        this.maplRepository = maplRepository;
    }


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
//    @GetMapping("/mapl-topic/{topic}")
//    public ResponseEntity<String> maplTopic(@PathVariable("topic")  @NotNull String topic) {
//        String answer = null;
//        answer = maplClient.prompt()
//                .user(u -> {
//                    u.text("Tell me a fact about {topic}");
//                    u.param("topic", topic);
//                })
//                .call()
//                .content();
//
//    return new ResponseEntity<>(answer, HttpStatus.OK);
//    }

//    @Contract(" -> new")
//    @NotNull
//    public static MaplTopic makeMaplTopic(String topic) {
//        return MaplTopic.makeMaplTopic(topic);
//    }
@GetMapping("/mapl-topic/{id}")
MaplTopic getMaplTopicById(@NotNull @PathVariable UUID id)  {
    Optional<MaplTopic> maplTopic = Optional.ofNullable(this.maplRepository.getMaplTopic(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return maplTopic.get();
}

    @GetMapping("/mapl-topics")
    public Flux<String> getMaplTopics() {
        return maplClient.prompt()
                .user("I am going to Paris and and Valenciennes, what are 10 places I should see first in each place")
                .stream()   // StreamResponseSpec
                .content();
    }

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
