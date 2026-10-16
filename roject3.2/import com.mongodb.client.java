import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class IndexValidationExample {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("schoolDB");
            MongoCollection<Document> collection = database.getCollection("students");

            Document result = collection.find(Filters.eq("email", "test@example.com"))
                                        .hint(new Document("email", 1))
                                        .first();

            if (result != null) {
                System.out.println("Found student: " + result.getString("name"));
            } else {
                System.out.println("No document found.");
            }
        }
    }
}