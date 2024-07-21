package xyz.cryptomaven.client_mapl.rest.maplAi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@CrossOrigin(origins = "*")
@RequestMapping("/ai")
@RestController
public class MaplController {
    private final ChatClient maplClient;

    public MaplController(ChatClient.Builder maplClient) {
        this.maplClient = maplClient.build();
    }

    @GetMapping("/mapl-topic/{topic}")
    public ResponseEntity<String> maplTopic(@PathVariable("topic") String topic) {
        String answer = null;
        answer = maplClient.prompt()
                .user(u -> {
                    u.text("Tell me a fact about {topic}");
                    u.param("topic", topic);
                })
                .call()
                .content();

    return new ResponseEntity<>(answer, HttpStatus.OK);
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
