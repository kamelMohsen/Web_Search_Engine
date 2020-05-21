package com.company;

import com.mongodb.*;
import org.bson.Document;

public class DataBase {
    MongoClient mongoClient ;
    DB indexDB ;
    DBCollection indexCollection;
    DB htmlsDB ;
    DBCollection htmlsCollection;

    public DataBase(){
        this.mongoClient  = new MongoClient("localhost", 27017);
        indexDB = mongoClient.getDB("index");
        htmlsDB = mongoClient.getDB("htmls");
        indexCollection = indexDB.getCollection("index_table");
        htmlsCollection = htmlsDB.getCollection("websites_table");

    }

    public void dropIndexDB(){
        indexDB.dropDatabase();
    }

    public void dropHtmlsDB(){

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
                .append("is_in_title",indexItem.getDocumentWordElement().isInTitle()));
        BasicDBObject indexEntry = new BasicDBObject("word", indexItem.getWord()).append("documents_"+indexItem.getWord(), dbl);
        indexCollection.insert(indexEntry);
    }
    private void updateIndexEntry(IndexItem indexItem){

        DBCursor element = newOrOldDocumentWord(indexItem);

        if(element.count() == 0) {
            DBObject findQuery = new BasicDBObject("word", indexItem.getWord());
            DBObject listItem = new BasicDBObject("documents_" + indexItem.getWord(), new BasicDBObject("doc_id", indexItem.getDocumentWordElement().getDocID()).append("word_frequency", indexItem.getDocumentWordElement().getFrequency())
                    .append("is_in_title", indexItem.getDocumentWordElement().isInTitle()));
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
                    .append("is_in_title", indexItem.getDocumentWordElement().isInTitle()));
            updateQuery = new BasicDBObject("$push", listItem);
            indexCollection.update(findQuery, updateQuery);

        }
    }



}
