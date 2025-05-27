package xyz.cryptomaven.vectordb.mapl;

import lombok.Data;

@Data
public class MaplTopicRequest {
    private String topic;

    public MaplTopicRequest() {}

    public MaplTopicRequest(String topic) {
        this.topic = topic;
    }

}
