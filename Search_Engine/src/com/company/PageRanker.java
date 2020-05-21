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

public class PageRanker implements Runnable {
    private static final String DATABASE_NAME = "";
    private static final String CRAWLER_COLLECTION_NAME = ""; //write crawler table name here
    private static final String INDEXER_COLLECTION_NAME = "";
    public static void calculatePageRank(Document doc){

            float tempSum = 0;
            for (int i = 0; i < doc.linksPageRanks; i++) {
                tempSum += doc.linksPageRanks[i].pageRank / doc.linksPageRanks[i].numberOfOutboundLinks;

            }


    }
    public static void updateDocumentByID(){}


    public void run() {
//        MongoClient mongoMan = new MongoClient("localhost", 27017);
//        MongoDatabase database = mongoMan.getDatabase("Index");
//        MongoCollection<Document> collection = database.getCollection("Index");
//        MongoCursor<Document> cur = collection.find().iterator();
//        ArrayList<String> names = new ArrayList<String>();
//        while (cur.hasNext()){
//            Document obj = cur.next();
//            String name3 = obj.getString("name");
//            names.add(name3);
//            System.out.println(name3);
//        }
//        BasicDBObject query = new BasicDBObject();
//        query.put("name", "Ahmad Nader");
//
//        BasicDBObject newDocument = new BasicDBObject();
//        newDocument.put("name", "Nadora");
//
//        BasicDBObject updateObject = new BasicDBObject();
//        updateObject.put("$set", newDocument);
//
//        database.getCollection("Index").updateOne(query, updateObject);

        //TODO: open a connection to the database
        MongoClient mongoMan = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoMan.getDatabase(DATABASE_NAME);

        //TODO: retrieve an object representing the crawler's collection
        MongoCollection<Document> collection = database.getCollection(CRAWLER_COLLECTION_NAME);

        //TODO: retrieve un-ranked urls
        //TODO: rank them according to the pageRank
        //TODO: update the crawler collection
        MongoCursor<Document> cur = collection.find(eq("ranked", "0")).cursor();
        while (cur.hasNext()){
            calculatePageRank(cur.next());
//            updateDocumentByID();
        }

    }


}
