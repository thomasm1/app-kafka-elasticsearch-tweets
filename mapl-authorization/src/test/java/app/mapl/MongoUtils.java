package app.mapl;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;


public class MongoUtils {
    private final MongoCollection<Document> collection;
    private static MongoDatabase database;
    private static MongoClient mongoClient;

    public MongoUtils(String url, String db, String col) {
         database = mongoClient.getDatabase(db);
        collection = database.getCollection(col);
        System.out.println("MONGO Coneection");
    }

    // HELPERS

//    protectec

    private void getResultsWithCursor(MongoCursor<Document> cursor, List<Bson> results) {
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            collection.find(doc).into(results);
        }
    }

//    private List<Document> getresultsWithValue(String field, String value) {
//        Document doc = new Document(field, value);
//        collection.find(doc).into(results);
//        return results;
//    }

//    public String fetchRecords (int limit) {
//        Iterable<Document> records = collection.find().limit(limit);
//        for (Document d: records ) {
//            System.out.println(d);
//                    }
//        return JSON.serialize(records);
//    }
}