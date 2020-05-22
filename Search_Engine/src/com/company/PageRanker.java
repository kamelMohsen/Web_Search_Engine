package com.company;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PageRanker  {
    private static final String DATABASE_NAME = "Index";
    private static final String CRAWLER_COLLECTION_NAME = "Index"; //write crawler table name here
    private static final String INDEXER_COLLECTION_NAME = "";

    public static void calculatePageRank(MongoDatabase database){
        MongoCollection<Document> collection = database.getCollection(CRAWLER_COLLECTION_NAME);
        MongoCursor<Document> cur = collection.find().cursor();

        if(cur.hasNext()) {
            Document current = cur.next();
            String currentUrl = (String) current.get("url");
            ArrayList<String> courses = (ArrayList<String>) current.get("InboundLinks");
            ArrayList<URLRank>  pageRankArray = new ArrayList<URLRank>();
            MongoCursor<Document> curt = collection.find().cursor();
            while(curt.hasNext()) {
                    Document doc = curt.next();

                    String s = (String) doc.get("url");
                    for (String e: courses){
                        if (e.equals(s)){
                            double rank = (double) doc.get("PageRank");
                            int noOfLinks = (int) doc.get("NoOfOutBoundLinks");
                            pageRankArray.add(new URLRank(rank, noOfLinks));
                        }
                    }
            }
            double actualRank = 0;
            for (URLRank e: pageRankArray) {
                actualRank += e.calculateRankSlice();
            }
            System.out.println(actualRank);
            BasicDBObject query = new BasicDBObject();
            query.put("url", currentUrl); // (1)

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("PageRank", actualRank); // (2)

            BasicDBObject updateObject = new BasicDBObject();
            updateObject.put("$set", newDocument); // (3)

            database.getCollection("Index").updateMany(query, updateObject);
        }

    }


    public static void main(String[] args) {
        //TODO: open a connection to the database
        MongoClient mongoMan = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoMan.getDatabase(DATABASE_NAME);
        MongoCollection<Document> collection = database.getCollection(CRAWLER_COLLECTION_NAME);
        calculatePageRank(database);
    }
}
