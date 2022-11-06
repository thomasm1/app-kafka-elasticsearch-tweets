module xyz.cryptomaven.maplmq {

    requires xyz.cryptomaven.mq.maplmq.TopicTwo;

    exports xyz.cryptomaven.cli.models.User to  xyz.cryptomaven.mq.maplmq.MessageTypes;
}