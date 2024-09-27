function mongoSetup(host, dbName, collection) {
    var MongoConfig = Java.type('utils.MongoUtils');
    var mongoInstance = new MongoConfig(host, dbName, collection);
    return mongoInstance;
}