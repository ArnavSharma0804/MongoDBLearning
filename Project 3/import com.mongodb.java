import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import org.bson.Document;

public class IndexErrorHandler {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("schoolDB");
            MongoCollection<Document> collection = database.getCollection("students");

            IndexOptions options = new IndexOptions().unique(true);

            try {
                collection.createIndex(Indexes.ascending("email"), options);
                System.out.println("Unique index created successfully!");
            } catch (MongoCommandException e) {
                System.err.println("Error creating index: " + e.getErrorMessage());
            }
        }
    }
}