module xyz.cryptomaven.maplmq {

    requires xyz.cryptomaven.cli;

    exports xyz.cryptomaven.mq.maplmq.TopicTwo to xyz.cryptomaven.cli;
    opens xyz.cryptomaven.mq.maplmq.TopicTwo to xyz.cryptomaven.cli-mongo-app;
}