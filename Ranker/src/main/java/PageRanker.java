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
    public static void calculatePageRank(MongoDatabase database){
        int documentCount = 0;
        System.out.println("Boom, looking for this?");
        MongoCollection<Document> linksCollection = database.getCollection(LINKS_COLLECTION_NAME);
        MongoCollection<Document> hrefsCollection = database.getCollection(HREFS_COLLECTION_NAME);
        long noOfDocuments = linksCollection.countDocuments();
        System.out.println("No Of Documents is " + noOfDocuments);
        // collection.update
        BasicDBObject resetQuery = new BasicDBObject();
        //query.put("$exists", true); // (1)

        BasicDBObject resetDocument = new BasicDBObject();
        resetDocument.put("PageRank", ((float) 1/noOfDocuments)); // (2)

        BasicDBObject resetObject = new BasicDBObject();
        resetObject.put("$set", resetDocument); // (3)
        linksCollection.updateMany(resetQuery, resetObject);
        //for (int i = 0; i < noOfDocuments - 1; i++) {
            MongoCursor<Document> linksCur = linksCollection.find().cursor();
            while (linksCur.hasNext()) {
                ArrayList<URLRank> list = new ArrayList<URLRank>();
                System.out.println("retrieved links collection");
                System.out.println("Document count is " + documentCount);
                documentCount++;
                Document current = linksCur.next();
                ObjectId id = (ObjectId) current.get("_id");
                String str = id.toString();
                System.out.println(id.toString());
                MongoCursor<Document> hrefsCur = hrefsCollection.find(eq("refTo",str)).cursor(); //the links that refer to my link
                while(hrefsCur.hasNext()){
                    System.out.println("retrieved hrefs collection");
                    Document hrefsCurrent = hrefsCur.next();
                    String hrefCounter = (String) hrefsCurrent.get("URL"); //get link that referred to my original link
                    MongoCursor<Document> linkCounter = hrefsCollection.find(eq("URL", hrefCounter)).cursor(); //
                    int counter = 0;
                    while(linkCounter.hasNext()) {
                        Document dummy = linkCounter.next();
                        counter++;
                    }
                    System.out.println(counter);
                    MongoCursor<Document> myUrl = linksCollection.find(eq("URL", hrefCounter)).cursor();
                    double pageRank = (double) myUrl.next().get("PageRank");
                    System.out.println("PageRank is "+ pageRank + " and no of outbound links " + counter);
                    list.add(new URLRank(pageRank, counter));
                }
                double actualRank = 0;
                for (URLRank e : list) {
                    actualRank += e.calculateRankSlice();
                }
                actualRank = (1-dampingFactor) + dampingFactor*actualRank;
                System.out.println("Rank to be stored in the Database" + actualRank);
                if( actualRank == 0.15000000000000002){
                    return;
                }
                String currentUrl = (String) current.get("URL");
                BasicDBObject query = new BasicDBObject();
                query.put("URL", currentUrl); // (1)

                BasicDBObject newDocument = new BasicDBObject();
                newDocument.put("PageRank", actualRank); // (2)

                BasicDBObject updateObject = new BasicDBObject();
                updateObject.put("$set", newDocument); // (3)
                linksCollection.updateOne(query, updateObject);
            }
        }
   // }

//                ArrayList<String> courses = (ArrayList<String>) current.get("InboundLinks");
//                ArrayList<URLRank> pageRankArray = new ArrayList<URLRank>();
//                MongoCursor<Document> curt = collection.find().cursor();
//                while (curt.hasNext()) {
//                    Document doc = curt.next();
//                    String s = (String) doc.get("url");
//                    for (String e : courses) {
//                        if (e.equals(s)) {
//                            double rank = (double) doc.get("PageRank");
//                            int noOfLinks = (int) doc.get("NoOfOutBoundLinks");
//                            pageRankArray.add(new URLRank(rank, noOfLinks));
//                            break;
//                        }
//                    }
//                }
//                double actualRank = 0;
//                for (URLRank e : pageRankArray) {
//                    actualRank += e.calculateRankSlice();
//                }
//                actualRank = (1-dampingFactor) + dampingFactor*actualRank;
//                System.out.println(actualRank);
//                String currentUrl = (String) current.get("url");
//                BasicDBObject query = new BasicDBObject();
//                query.put("url", currentUrl); // (1)
//
//                BasicDBObject newDocument = new BasicDBObject();
//                newDocument.put("PageRank", actualRank); // (2)
//
//                BasicDBObject updateObject = new BasicDBObject();
//                updateObject.put("$set", newDocument); // (3)
//
//                database.getCollection("Index").updateMany(query, updateObject);
//            }
//        }



    public static void main(String[] args) {
        //TODO: open a connection to the database
        MongoClient mongoMan = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoMan.getDatabase(DATABASE_NAME);
//        MongoCollection<Document> collection = database.getCollection(HREFS_COLLECTION_NAME);
//        MongoCollection<Document> ANOTHERcollection = database.getCollection(LINKS_COLLECTION_NAME);
        calculatePageRank(database);
//        System.out.println("confirming database connection, and collections retrieval");
//        double iHateJava = (double) (1/8246)/0;
//        System.out.println(iHateJava);
    }
}
