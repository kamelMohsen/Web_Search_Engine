package com.company;

import com.mongodb.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataBase {
    MongoClient mongoClient ;
    DB indexDB ;
    DBCollection indexCollection;
    DB crawlerDB ;
    DBCollection crawlerCollection;

    public DataBase(){
        this.mongoClient  = new MongoClient("localhost", 27017);
        indexDB = mongoClient.getDB("index");
        crawlerDB = mongoClient.getDB("CrawlerDB");
        indexCollection = indexDB.getCollection("index_table");
        crawlerCollection = crawlerDB.getCollection("Links");

    }

    public void getLinks(List<Link> linksList){
        DBCursor cur =  crawlerCollection.find(new BasicDBObject("indexed", 0).append("Visited",1));
        int size = cur.size();
        for(int i = 0 ;i< size;i++) {
            DBObject doc = cur.next();
            String URL = (String) doc.get("URL");
            ObjectId objID = (ObjectId) doc.get("_id");
            String ID = objID.toString();
            Link link = new Link(URL,ID);
            linksList.add(link);
        }
    }

    public void updateIndex(IndexItem indexItem) {
        DBCursor dbCursor = newOrOldWord(indexItem);
        if(dbCursor.count() == 0)
        {
        insertNewIndexEntry(indexItem);
        }
        else
        {
            updateIndexEntry(indexItem);
        }

    }

    private DBCursor newOrOldWord(IndexItem indexItem){
        DBObject query = new BasicDBObject("word", indexItem.getWord());
        return indexCollection.find(query);
    }
    private DBCursor newOrOldDocumentWord(IndexItem indexItem){

        DBObject query = new BasicDBObject("documents_"+indexItem.getWord()+".doc_id", indexItem.getDocumentWordElement().getDocID());
        return indexCollection.find(query);
    }
    private void insertNewIndexEntry(IndexItem indexItem){

        BasicDBList dbl = new BasicDBList();
        dbl.add(new BasicDBObject("doc_id",indexItem.getDocumentWordElement().getDocID())
                .append("word_frequency",indexItem.getDocumentWordElement().getFrequency())
                .append("is_in_title",indexItem.getDocumentWordElement().isInTitle())
                .append("first_statement", indexItem.getDocumentWordElement().getFirstStatement())
                .append("img_src", indexItem.getDocumentWordElement().getImgSrc()));
        BasicDBObject indexEntry = new BasicDBObject("word", indexItem.getWord()).append("documents_"+indexItem.getWord(), dbl);
        indexCollection.insert(indexEntry);
    }
    private void updateIndexEntry(IndexItem indexItem){

        DBCursor element = newOrOldDocumentWord(indexItem);

        if(element.count() == 0) {
            DBObject findQuery = new BasicDBObject("word", indexItem.getWord());
            DBObject listItem = new BasicDBObject("documents_" + indexItem.getWord(), new BasicDBObject("doc_id", indexItem.getDocumentWordElement().getDocID()).append("word_frequency", indexItem.getDocumentWordElement().getFrequency())
                    .append("is_in_title", indexItem.getDocumentWordElement().isInTitle())
                    .append("first_statement", indexItem.getDocumentWordElement().getFirstStatement())
                    .append("img_src", indexItem.getDocumentWordElement().getImgSrc()));
            DBObject updateQuery = new BasicDBObject("$push", listItem);
            indexCollection.update(findQuery, updateQuery);
        }
        else {

            DBObject findQuery = new BasicDBObject("documents_"+indexItem.getWord()+".doc_id", indexItem.getDocumentWordElement().getDocID());
            DBObject listItem  = new BasicDBObject("documents_"+indexItem.getWord(),new BasicDBObject("doc_id", indexItem.getDocumentWordElement().getDocID()));

            DBObject updateQuery = new BasicDBObject("$pull", listItem);
            indexCollection.update(findQuery, updateQuery);

            findQuery = new BasicDBObject("word", indexItem.getWord());
            listItem = new BasicDBObject("documents_" + indexItem.getWord(), new BasicDBObject("doc_id", indexItem.getDocumentWordElement().getDocID()).append("word_frequency", indexItem.getDocumentWordElement().getFrequency())
                    .append("is_in_title", indexItem.getDocumentWordElement().isInTitle())
                    .append("first_statement", indexItem.getDocumentWordElement().getFirstStatement())
                    .append("img_src", indexItem.getDocumentWordElement().getImgSrc()));
            updateQuery = new BasicDBObject("$push", listItem);
            indexCollection.update(findQuery, updateQuery);

        }
    }



}
