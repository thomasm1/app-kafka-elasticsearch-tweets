module xyz.cryptomaven.maplmq {

    requires xyz.cryptomaven.mq.maplmq.TopicTwo;

    exports app.mapl.cli.models.User to  xyz.cryptomaven.mq.maplmq.MessageTypes;
}