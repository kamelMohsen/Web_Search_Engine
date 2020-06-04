import com.mongodb.*;
import netscape.javascript.JSObject;
import org.bson.types.ObjectId;

import java.net.URL;
import java.util.*;

public class Database {
    MongoClient mongoClient;
    DB crawlerDB;
    DBCollection peopleCollection ;

    public Database() {
        this.mongoClient = new MongoClient("localhost", 27017);
        crawlerDB = mongoClient.getDB("TrendsDB");
        peopleCollection = crawlerDB.getCollection("People");
        System.out.println("entered ");
    }
    void insertWord(String Word, String Region){

        DBCursor cur =  peopleCollection.find(new BasicDBObject("Word", Word)
                .append("Region",Region));
        int size = cur.size();
        if(size != 0){
            BasicDBObject newDocument = new BasicDBObject().append("$inc",
                    new BasicDBObject().append("occurrence", 1));
            peopleCollection.update(new BasicDBObject().append("Word", Word).
                    append("Region",Region), newDocument);
        }else{
            BasicDBObject wordEntry = new BasicDBObject("Word", Word)
                    .append("occurrence", 1).
                            append("Region",Region);
            peopleCollection.insert(wordEntry);
        }


        ////////////////////////////////////////////////////////////////////////////////
        DBCursor cur1 =  peopleCollection.find(new BasicDBObject("Word", Word)
                .append("Region","WW"));
        int size1 = cur1.size();
        if(size1 != 0){
            BasicDBObject newDocument = new BasicDBObject().append("$inc",
                    new BasicDBObject().append("occurrence", 1));
            peopleCollection.update(new BasicDBObject().append("Word", Word).
                    append("Region","WW"), newDocument);
        }else{
            BasicDBObject wordEntry = new BasicDBObject("Word", Word)
                    .append("occurrence", 1).
                            append("Region","WW");
            peopleCollection.insert(wordEntry);
        }


    }
    void getTrends(List<String> queue,Vector<Integer> numbers, String Region){ //  by region

        DBCursor cur =  peopleCollection.find(new BasicDBObject("Region", Region)).sort(new BasicDBObject("occurrence",-1)).limit(10);
        int size = cur.size();
        cur.sort(new BasicDBObject("occurrence",-1));
        for(int i = 0 ;i< size;i++) {
            DBObject doc = cur.next();
            String Word = (String) doc.get("Word");
            int number = (int) doc.get("occurrence");
            queue.add(Word);
            numbers.add(number);
        }

    }
    void getTrends(List<String> queue, Vector<Integer> numbers){ //  WORLDWIDE

        DBCursor cur =  peopleCollection.find(new BasicDBObject("Region","WW")).sort(new BasicDBObject("occurrence",-1)).limit(10);
        int size = cur.size();
        cur.sort(new BasicDBObject("occurrence",-1));
        for(int i = 0 ;i< size;i++) {
            DBObject doc = cur.next();
            String Word = (String) doc.get("Word");
            int number = (int) doc.get("occurrence");
            queue.add(Word);
            numbers.add(number);
        }
    }
};




