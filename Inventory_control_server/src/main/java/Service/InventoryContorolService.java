package Service;

import DTOs.Order;
import DTOs.Product;
import Util.DbConfig;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public class InventoryContorolService {

    public Map<String, String> createProduct(Product product) {
        MongoDatabase mongoDatabase = DbConfig.getDatabase();
        MongoCollection<Document> collection = mongoDatabase.getCollection("products");
        Document document = new Document();
        document.put("productId", product.getProductId());
        document.put("productName", product.getProductName());
        document.put("count", product.getCount());
        collection.insertOne(document);

        Map<String, String> response = new HashMap<>();
        response.put("status", "200");
        response.put("message", "Item created successfully.");
        return response;
    }

    public synchronized Map<String, String> processOrder(Order order) {
        MongoDatabase database = DbConfig.getDatabase();
        MongoCollection<Document> collection = database.getCollection("products");
        Document query = new Document();
        query.put("productId", order.getItemId());
        Document item = collection.find(query).first();

        if (item != null) {
            Integer itemCount = (Integer) item.get("count");
            if (itemCount >= order.getCount()) {
                itemCount -= order.getCount();

                // Save Item
                collection.updateOne(Filters.eq("productId", order.getItemId()), Updates.set("count", itemCount));
                Map<String, String> response = new HashMap<>();
                response.put("status", "200");
                response.put("message", "Order processed successfully.");
                return response;
            } else {
                // Inventory Not Enough
                Map<String, String> response = new HashMap<>();
                response.put("status", "403");
                response.put("message", "Order processed failed. Inventory not sufficient.");
                return response;
            }
        } else {
            // Invalid product
            Map<String, String> response = new HashMap<>();
            response.put("status", "404");
            response.put("message", "Item not found.");
            return response;
        }
    }

    public synchronized Map<String, String> updateInventory(Product product) {
        MongoDatabase database = DbConfig.getDatabase();
        MongoCollection<Document> collection = database.getCollection("items");
        Document query = new Document();
        query.put("productId", product.getProductId());
        Document dbproduct = collection.find(query).first();

        if (dbproduct != null) {
            // Update Inventory
            Integer productCount = (Integer) dbproduct.get("count");
            productCount += product.getCount();
            collection.updateOne(Filters.eq("productId", product.getProductId()), Updates.set("count", productCount));

            Map<String, String> response = new HashMap<>();
            response.put("status", "200");
            response.put("message", "Inventory updated successfully.");
            return response;
        } else {
            // Invalid product
            Map<String, String> response = new HashMap<>();
            response.put("status", "404");
            response.put("message", "product not found.");
            return response;
        }
    }
}
