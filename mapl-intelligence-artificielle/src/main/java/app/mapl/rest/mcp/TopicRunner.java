package app.mapl.rest.mcp;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpServerFeatures.SyncToolSpecification;
import io.modelcontextprotocol.server.McpSyncServer;
import io.modelcontextprotocol.server.McpSyncServerExchange;
import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TopicRunner {

  private static PostTopicTools postTopicTools = new PostTopicTools();

  public static void topicRunner(String[] args) {

    // Stdio Server Transport
    var transportProvider = new StdioServerTransportProvider(new ObjectMapper());
    // Sync Tool specification
    var syncToolSpecification = getSyncToolSpecification();
    System.out.println("Running TopicRunner...");

    McpSyncServer syncServer = McpServer.sync(transportProvider)
        .serverInfo("javaone-mcp-server", "0.0.1")
        .capabilities(McpSchema.ServerCapabilities.builder()
            .tools(true)
            .logging()
              .build())
        .tools(syncToolSpecification)
        .build();

  }
  private static McpServerFeatures.SyncToolSpecification getSyncToolSpecification() {
    // This method should return the specification for the sync tool
      var schema = """
        {
          "type": "object",
          "id": "urn:jsonschema:Operation",
          "properties": {
          "operation": {
              "type": "string"
            }
          }
        }
        """;

      McpServerFeatures.SyncToolSpecification syncToolSpecification = new McpServerFeatures.SyncToolSpecification(
          new McpSchema.Tool("get_topics",   "Retrieves a list of topics from Javaone", schema),
          (McpSyncServerExchange exchange, Map<String, Object> arguments) -> {
            // Handle the tool invocation
            System.out.println("Tool invoked with arguments: " + arguments);
            List<PostTopic> postTopics = postTopicTools.getPostTopics();
            List<McpSchema.Content> contents = new ArrayList<>();
            for (PostTopic topic : postTopics) {
              contents.add(new McpSchema.TextContent(topic.toString()));
            }
              return new McpSchema.CallToolResult(contents, false);
          }
      );
      return syncToolSpecification;
  }
}
