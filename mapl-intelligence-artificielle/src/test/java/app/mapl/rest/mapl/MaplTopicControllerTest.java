 package app.mapl.rest.mapl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MaplTopicControllerTest {

    @Autowired
    MaplTopicTester maplTopicTester;

//    @Test
    public void givenIAmAMaplTopic_WhenICreate() {
        MaplTopicRequest request = new MaplTopicRequest("Test Topic");
        WebTestClient.ResponseSpec response = maplTopicTester.makeMaplTopic(request);

        itShouldCreateMaplTopic(response);
        MaplTopicResponse newTopic = maplTopicTester.getMaplFromResponse(response);
        itShouldAllocateANewId(newTopic);
//        itShouldConfirmTopicDetails(request, newTopic);
    }

    private void itShouldCreateMaplTopic(WebTestClient.ResponseSpec response) {
        response.expectStatus().isCreated();
    }

    private void itShouldAllocateANewId(MaplTopicResponse response) {
        assertThat(response.getId()).isNotEqualTo(new UUID(0, 0));
        assertThat(response.getId()).isNotNull();
    }

    private void itShouldConfirmTopicDetails(MaplTopicRequest request, MaplTopicResponse response) {
        assertThat(response.getTopic()).isEqualTo(request.getTopic());
    }
}