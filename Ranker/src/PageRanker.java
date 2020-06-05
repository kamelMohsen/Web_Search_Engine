import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class PageRanker  {
    private static final String DATABASE_NAME = "CrawlerDB";
    private static final String LINKS_COLLECTION_NAME = "Links"; //write crawler table name here
    private static final String HREFS_COLLECTION_NAME = "hrefs";
    private static final double dampingFactor = 0.85;
    private static final double invDampingFactor = 1-dampingFactor;
    private static final int noOfIterations = 10;
    public static void calculatePageRank(MongoDatabase database) {
        MongoCollection<Document> linksCollection = database.getCollection(LINKS_COLLECTION_NAME);
        MongoCollection<Document> hrefsCollection = database.getCollection(HREFS_COLLECTION_NAME);
        long noOfDocuments = linksCollection.count();
        long previous = System.currentTimeMillis();
        BasicDBObject resetQuery = new BasicDBObject();
        BasicDBObject resetDocument = new BasicDBObject();
        resetDocument.put("PageRank", ((float) 1 / noOfDocuments)); // (2)
        BasicDBObject resetObject = new BasicDBObject();
        resetObject.put("$set", resetDocument); // (3)
        linksCollection.updateMany(resetQuery, resetObject);
        System.out.print("time taken to set initial pageranks = ");
       // System.out.println(System.currentTimeMillis()-previous);
        previous = System.currentTimeMillis();
        MongoCursor<Document> holder = linksCollection.find(eq("Visited", 1)).iterator();
        //System.out.println("time for retrieving visited links = ");
        //System.out.println(System.currentTimeMillis()-previous);
        previous = System.currentTimeMillis();
        for (int i = 0; i < noOfIterations; i++) {
            MongoCursor<Document> linksCur = linksCollection.find(eq("Visited", 1)).iterator();;
            int documentCount = 0;
            System.out.println("Iteration : "+ i);
            while (linksCur.hasNext()) {
                ArrayList<URLRank> list = new ArrayList<URLRank>();
                documentCount++;
                System.out.println(documentCount);
                Document current = linksCur.next();
                previous = System.currentTimeMillis();
                ObjectId id = (ObjectId) current.get("_id");
                //System.out.println("Time taken to get id");
                //System.out.println(System.currentTimeMillis() - previous);
                String str = id.toString();
                previous = System.currentTimeMillis();
                MongoCursor<Document> hrefsCur = hrefsCollection.find(eq("refTo", str)).iterator(); //the links that refer to my link
                //System.out.println("Time taken to retrieve list of inbound links.");
               // System.out.println(System.currentTimeMillis() - previous);
                previous = System.currentTimeMillis();
                while (hrefsCur.hasNext()) {
                    Document hrefsCurrent = hrefsCur.next();
                    String hrefCounter = (String) hrefsCurrent.get("URL"); //get link that referred to my original link
                    long withinLoop = System.currentTimeMillis();
                    /////////////////////////////////////////
                    MongoCursor<Document> linkCounter = hrefsCollection.find(eq("URL", hrefCounter)).iterator(); //
                    /////////////////////////////////////////////
                   // System.out.println("time taken to retrieve list of reffering documents");
                    //System.out.println(System.currentTimeMillis() - withinLoop);
                    withinLoop = System.currentTimeMillis();
                    int counter = 0;
                    while (linkCounter.hasNext()) {
                        Document dummy = linkCounter.next();
                        counter++;
                    }
                    //System.out.println("time taken to count outbound links of referring document");
                   // System.out.println(System.currentTimeMillis() - withinLoop);
                    list.add(new URLRank((double) current.get("PageRank"), counter));
                }
                ///System.out.println("Time taken to add referring websites to array:");
                //System.out.println(System.currentTimeMillis()- previous);
                previous = System.currentTimeMillis();
                double actualRank = 0;
                for (URLRank e : list) {
                    actualRank += e.calculateRankSlice();
                }
                //String currentUrl = (String) current.get("URL");

                actualRank = invDampingFactor + dampingFactor * actualRank;
                //System.out.println("Time taken to calculate PageRank: ");
                //System.out.println(System.currentTimeMillis() - previous);
                previous = System.currentTimeMillis();
                BasicDBObject query = new BasicDBObject();
                query.put("_id", id); // (1)

                BasicDBObject newDocument = new BasicDBObject();
                newDocument.put("PageRank", actualRank); // (2)

                BasicDBObject updateObject = new BasicDBObject();
                updateObject.put("$set", newDocument); // (3)
                linksCollection.updateOne(query, updateObject);
               // System.out.println("Time taken to update the database: ");
               // System.out.println(System.currentTimeMillis() - previous);
            }
        }
    }





    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis();
        PerformanceAnalyzer crawlerPerformance = new PerformanceAnalyzer(1);

        MongoClient mongoMan = new MongoClient("localhost", 27017);

        MongoDatabase database = mongoMan.getDatabase(DATABASE_NAME);
        calculatePageRank(database);
        try {
            crawlerPerformance.addToFile("Time to page rank 100 documents for " + noOfIterations +" iterations is " +
                    (System.currentTimeMillis() - beforeTime)/1000 + " seconds.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
