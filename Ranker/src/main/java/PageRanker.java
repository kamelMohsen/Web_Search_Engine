import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PageRanker  {
    private static final String DATABASE_NAME = "CrawlerDB";
    private static final String LINKS_COLLECTION_NAME = "Links"; //write crawler table name here
    private static final String HREFS_COLLECTION_NAME = "hrefs";
    private static final double dampingFactor = 0.85;
    private static final int noOfIterations = 30;
    public static void calculatePageRank(MongoDatabase database) {
        MongoCollection<Document> linksCollection = database.getCollection(LINKS_COLLECTION_NAME);
        MongoCollection<Document> hrefsCollection = database.getCollection(HREFS_COLLECTION_NAME);
        long noOfDocuments = linksCollection.countDocuments();
        BasicDBObject resetQuery = new BasicDBObject();

        BasicDBObject resetDocument = new BasicDBObject();
        resetDocument.put("PageRank", ((float) 1 / noOfDocuments)); // (2)

        BasicDBObject resetObject = new BasicDBObject();
        resetObject.put("$set", resetDocument); // (3)
        linksCollection.updateMany(resetQuery, resetObject);
        for (int i = 0; i < noOfIterations; i++) {
            MongoCursor<Document> linksCur = linksCollection.find(eq("Visited", 1)).cursor();
            int documentCount = 0;
            while (linksCur.hasNext()) {
                ArrayList<URLRank> list = new ArrayList<URLRank>();
                documentCount++;
                Document current = linksCur.next();
                ObjectId id = (ObjectId) current.get("_id");
                String str = id.toString();
                MongoCursor<Document> hrefsCur = hrefsCollection.find(eq("refTo", str)).cursor(); //the links that refer to my link
                while (hrefsCur.hasNext()) {
                    Document hrefsCurrent = hrefsCur.next();
                    String hrefCounter = (String) hrefsCurrent.get("URL"); //get link that referred to my original link
                    MongoCursor<Document> linkCounter = hrefsCollection.find(eq("URL", hrefCounter)).cursor(); //
                    int counter = 0;
                    while (linkCounter.hasNext()) {
                        Document dummy = linkCounter.next();
                        counter++;
                    }
                    MongoCursor<Document> myUrl = linksCollection.find(eq("URL", hrefCounter)).cursor();
                    double pageRank = (double) myUrl.next().get("PageRank");
                    list.add(new URLRank(pageRank, counter));
                }
                double actualRank = 0;
                for (URLRank e : list) {
                    actualRank += e.calculateRankSlice();
                }
                String currentUrl = (String) current.get("URL");

                actualRank = (1 - dampingFactor) + dampingFactor * actualRank;
                BasicDBObject query = new BasicDBObject();
                query.put("URL", currentUrl); // (1)

                BasicDBObject newDocument = new BasicDBObject();
                newDocument.put("PageRank", actualRank); // (2)

                BasicDBObject updateObject = new BasicDBObject();
                updateObject.put("$set", newDocument); // (3)
                linksCollection.updateOne(query, updateObject);
            }
        }
    }





    public static void main(String[] args) {
        MongoClient mongoMan = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoMan.getDatabase(DATABASE_NAME);
        calculatePageRank(database);
    }
}
