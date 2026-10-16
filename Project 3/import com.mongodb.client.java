import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import org.bson.Document;

public class IndexTypesExample {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("schoolDB");
            MongoCollection<Document> collection = database.getCollection("students");

            collection.createIndex(Indexes.ascending("age"));

            collection.createIndex(Indexes.compoundIndex(
                Indexes.ascending("department"), 
                Indexes.descending("cgpa")
            ));

            collection.createIndex(Indexes.ascending("skills"));

            System.out.println("All index types created successfully!");
        }
    }
}