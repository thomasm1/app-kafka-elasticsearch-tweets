package app.mapl.rest.mcp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostTopicTools {

  private List<PostTopic> postTopics = new ArrayList<>();

  public PostTopicTools() {
    var topic = new PostTopic();
  }

  public List<PostTopic> getPostTopics() {
    if (postTopics.isEmpty()) {
      postTopics.add(new PostTopic("JavaOne 2023", "Exploring new features & latest in Java", "https://javaone.com/2023", 250801));
      postTopics.add(new PostTopic("MCP Protocol", "Understanding Model Context Protocol", "https://mcp.io/docs", 250521));
      postTopics.add(new PostTopic("Vector Databases", "The future of data storage", "https://vectordb.com", 250507));
    }
    return postTopics;
  }

  public List<PostTopic> getPostTopicsByDid(int did) {
    return (List<PostTopic>) postTopics.stream()
        .map(p -> {
          Map<String, Object> postMap = new HashMap<>();
          postMap.put("title", p.getTitle());
          postMap.put("post", p.getPost());
          postMap.put("url", p.getUrl());
          postMap.put("did", p.getDid());
          return postMap;
        });
  }
}
