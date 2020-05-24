import com.mongodb.*;
import netscape.javascript.JSObject;
import org.bson.types.ObjectId;

import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Database {
    MongoClient mongoClient;
    DB crawlerDB;
    DBCollection crawlerCollection ;
    DBCollection hrefCollection;

    public Database() {
        this.mongoClient = new MongoClient("localhost", 27017);
        crawlerDB = mongoClient.getDB("CrawlerDB");
        crawlerCollection = crawlerDB.getCollection("Links");
        hrefCollection = crawlerDB.getCollection("hrefs");
        System.out.println("entered ");
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
                    .append("PageRank", 0);


            crawlerCollection.insert(crawlerEntry);
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
                    .append("PageRank", 0);


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
};




