package Crawler;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;
import java.util.Set;

@SuppressWarnings("ALL")
public class CrawlerDatabaseManager {
    MongoClient mongoClient;
    DB crawlerDB;
    DBCollection crawlerCollection ;
    DBCollection hrefCollection;
    DBCollection DateCollection;

    public CrawlerDatabaseManager() {
        this.mongoClient = new MongoClient("localhost", 27017);
        crawlerDB = mongoClient.getDB("CrawlerDB");
        crawlerCollection = crawlerDB.getCollection("Links");
        hrefCollection = crawlerDB.getCollection("hrefs");
        crawlerCollection.createIndex("URL");
        hrefCollection.createIndex("URL");
        crawlerCollection.createIndex("Visited");
        crawlerCollection.createIndex("indexed");



    }
    void updateHref(List<String> Link,String baseURL){

            DBCursor cur =  crawlerCollection.find(new BasicDBObject("URL", baseURL));
            DBObject doc = cur.next();
            ObjectId objID = (ObjectId) doc.get("_id");
            String ID = objID.toString();
            BasicDBObject oldEntry = new BasicDBObject("refTo", ID);
            hrefCollection.findAndRemove(oldEntry);

            for(int i = 0 ;i<Link.size(); i++) {
                BasicDBObject crawlerEntry = new BasicDBObject("URL", Link.get(i))
                        .append("refTo", ID);


                hrefCollection.insert(crawlerEntry);
            }
        }

    public void insertHref(List<String> Link,String baseURL) {

        DBCursor cur =  crawlerCollection.find(new BasicDBObject("URL", baseURL));
            DBObject doc = cur.next();
            ObjectId objID = (ObjectId) doc.get("_id");
            String ID = objID.toString();
            for(int i = 0 ;i<Link.size(); i++) {
        BasicDBObject crawlerEntry = new BasicDBObject("URL", Link.get(i))
                .append("refTo", ID);


        hrefCollection.insert(crawlerEntry);
        }
    }
    public void insertLink(List<String> Link){


        for(int i = 0 ;i<Link.size(); i++) {
            BasicDBObject crawlerEntry = new BasicDBObject("URL", Link.get(i))
                    .append("Visited", 0)
                    .append("indexed", 0)
                    .append("importance",0)
                    .append("PageRank",(double)0.0);


            crawlerCollection.insert(crawlerEntry);
        }
    }
    public void insertDate(Date time){
            BasicDBObject crawlerEntry = new BasicDBObject("Date", time)
                    .append("type","date");
            crawlerCollection.insert(crawlerEntry);
    }
    public void getDate(Date time) {

        DBCursor cur = crawlerCollection.find(new BasicDBObject("type", "date"));
        int size = cur.size();
        if (size != 0) {
            DBObject doc = cur.next();
            Date T = (Date) doc.get("Date");
            time.setTime(T.getTime());
            time.setHours(time.getHours()+4);


        }
    }
    public void updateDate(Date time){
        DBObject findQuery = new BasicDBObject("type", "date");
        DBObject objQuery = new BasicDBObject("Date", time);
        DBObject updateQuery = new BasicDBObject("$set",objQuery );
        if(crawlerCollection.find(findQuery).count() != 0)
            crawlerCollection.update(findQuery, updateQuery);
        else{
            insertDate(time);
        }
    }
    public void visitLink(String Link,int importance){

        DBObject findQuery = new BasicDBObject("URL", Link);
        DBObject objQuery = new BasicDBObject("Visited", 1)
                .append("importance",importance);
        DBObject updateQuery = new BasicDBObject("$set",objQuery );
        if(crawlerCollection.find(findQuery).count() != 0)
        crawlerCollection.update(findQuery, updateQuery);
        else{
            BasicDBObject crawlerEntry = new BasicDBObject("URL", Link)
                    .append("Visited", 1)
                    .append("indexed", 0)
                    .append("importance",importance)
                    .append("PageRank",(double) 0.0);


            crawlerCollection.insert(crawlerEntry);
        }
    }
    void getQueue(List<String> queue){

        DBCursor cur =  crawlerCollection.find(new BasicDBObject("Visited", 0));
        int size = cur.size();
        for(int i = 0 ;i< size;i++) {
         DBObject doc = cur.next();
         String URL = (String) doc.get("URL");
         queue.add(URL);
        }
    }
    void getVisited(Set<String> Visited){
        DBCursor cur =  crawlerCollection.find(new BasicDBObject("Visited", 1));
        int size = cur.size();
        for(int i = 0 ;i< size;i++) {
            DBObject doc = cur.next();
            String URL = (String) doc.get("URL");
            Visited.add(URL);
        }
    }
    void getVisited(List<String> queue){
        DBCursor cur =  crawlerCollection.find(new BasicDBObject("Visited", 1));
        int size = cur.size();
        for(int i = 0 ;i< size;i++) {
            DBObject doc = cur.next();
            String URL = (String) doc.get("URL");
            queue.add(URL);
        }
    }
    void getImportant(List<String> queue){
        DBCursor cur =  crawlerCollection.find(new BasicDBObject("Visited", 1)
                .append("importance",1));
        int size = cur.size();
        for(int i = 0 ;i< size;i++) {
            DBObject doc = cur.next();
            String URL = (String) doc.get("URL");
            queue.add(URL);
        }
    }
    void updateLink(String URL){
        DBObject findQuery = new BasicDBObject("URL", URL);
        DBObject objQuery = new BasicDBObject("indexed", 0)
                .append("PageRank",0.0);

        DBObject updateQuery = new BasicDBObject("$set",objQuery );
        crawlerCollection.update(findQuery, updateQuery);
    }

};




