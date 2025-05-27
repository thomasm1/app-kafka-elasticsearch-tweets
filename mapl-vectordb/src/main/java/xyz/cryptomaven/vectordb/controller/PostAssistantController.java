package xyz.cryptomaven.vectordb.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class PostAssistantController {

  private final ChatClient ai;

  public PostAssistantController(ChatClient.Builder builder) {
    this.ai = builder.build();
  }


  @GetMapping("/{user}/inquire")
  public String inquire(String user, String question) {
    return this.ai
        .prompt()
        .user(question)
        .call()
        .content();
  }

  @PostMapping("/{user}/inquire")
  public String inquirePost(String user, String question) {
    return this.ai
             .prompt()
             .user(question)
             .call()
             .content();
  }
}
