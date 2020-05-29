package com.company;

import com.mongodb.*;
import java.lang.Math;
import org.bson.types.ObjectId;


import java.util.List;


@SuppressWarnings("deprecation")
public class DataBase {
    MongoClient mongoClient ;
    DB indexDB ;
    DBCollection indexCollection;
    DB freqDB ;
    DBCollection freqCollection;
    DB crawlerDB ;
    DBCollection crawlerCollection;

    public DataBase(){
        this.mongoClient  = new MongoClient("localhost", 27017);
        indexDB = mongoClient.getDB("indexDB");
        crawlerDB = mongoClient.getDB("CrawlerDB");
        freqDB = mongoClient.getDB("frequenciesDB");
        indexCollection = indexDB.getCollection("wikipedia_50_pages_try_1");
        crawlerCollection = crawlerDB.getCollection("Links");
        freqCollection = freqDB.getCollection("wikipedia_50_pages_try_1");


        indexCollection.createIndex(new BasicDBObject("word", 1).append("doc_url",1),"indexEntry",true);
        indexCollection.createIndex("doc_url");
        freqCollection.createIndex("word_docs");
    }


    //deals with crawler data base
    public void setIndexed(String _id){

        DBObject findQuery = new BasicDBObject("_id",new ObjectId(_id));
        DBObject objQuery = new BasicDBObject("indexed", 1);
        DBObject updateQuery = new BasicDBObject("$set",objQuery );
        if(crawlerCollection.findOne(findQuery) != null)
            crawlerCollection.update(findQuery, updateQuery);

    }
    //deals with crawler data base
    public void getLinks(List<Link> linksList){
        DBCursor cur =  crawlerCollection.find(new BasicDBObject("indexed", 0).append("Visited",1));
        int size = cur.size();
        for(int i = 0 ;i< size;i++) {
            DBObject doc = cur.next();
            
            String URL = (String) doc.get("URL");
            ObjectId objID = (ObjectId) doc.get("_id");
            String ID = objID.toString();

            double pageRank = (double)doc.get("PageRank");
            Link link = new Link(URL,ID,pageRank);
            linksList.add(link);
        }
    }



    public void updateIndex(IndexItem indexItem) {

        if(newOrOld(indexItem) == null)
        {
            insertNewIndexEntry(indexItem);
        }
        else
        {
            updateIndexEntry(indexItem);
        }

    }

    private DBObject newOrOld(IndexItem indexItem){
        DBObject query = new BasicDBObject("word", indexItem.getWord())
                .append("doc_url",indexItem.getDocumentWordElement().getdocURL());
        return indexCollection.findOne(query);
    }



    private void insertNewIndexEntry(IndexItem indexItem){

        BasicDBList dblImgs = new BasicDBList();
        for(int i = 0;i<indexItem.getDocumentWordElement().getImgSrcList().size();i++)
        {

            dblImgs.add(new BasicDBObject("img_Src",indexItem.getDocumentWordElement().getImgSrc(i)));
        }

        indexCollection.insert(new BasicDBObject("word", indexItem.getWord()).append("doc_url", indexItem.getDocumentWordElement().getdocURL())
                .append("word_frequency", indexItem.getDocumentWordElement().getFrequency())
                .append("is_in_title", indexItem.getDocumentWordElement().isInTitle())
                .append("first_statement", indexItem.getDocumentWordElement().getFirstStatement())
                .append("title", indexItem.getDocumentWordElement().getTitle())
                .append("page_rank", (double) indexItem.getDocumentWordElement().getPageRank())
                .append("total_words_count", indexItem.getDocumentWordElement().getWordsCount())
                .append("tf", ((double) indexItem.getDocumentWordElement().getFrequency() / (double) indexItem.getDocumentWordElement().getWordsCount()))
                .append("idf", (double) 0)
                .append("img_srcs", dblImgs));
    }

    public void updateWordDocsCount(String  word){

        if(newOrOldWordDocsCount(word) == null)
        {
            insertNewWordDocsCount(word);
        }else
        {
            updateWordDocsCountEntry(word);
        }
    }
    private DBObject newOrOldWordDocsCount(String word){
        DBObject query = new BasicDBObject("word_docs",word);
        return freqCollection.findOne(query);
    }

    private void insertNewWordDocsCount(String word){
        if(word!=null){
            freqCollection.insert(new BasicDBObject("word_docs", word)
                .append("count",1));
        }else{
            System.out.println("NULL");
        }
    }

    private void updateWordDocsCountEntry(String word) {
        DBObject findQuery = new BasicDBObject("word_docs",word);
        DBObject objQuery = new BasicDBObject("count", 1);
        DBObject updateQuery = new BasicDBObject("$inc",objQuery );
        freqCollection.update(findQuery, updateQuery);

    }



    private void updateIndexEntry(IndexItem indexItem){
        DBObject query = new BasicDBObject("word", indexItem.getWord())
                .append("doc_url",indexItem.getDocumentWordElement().getdocURL());
        indexCollection.remove(query);
        insertNewIndexEntry(indexItem);

    }





    public void normalizeURL(String  url,int size){
        DBCursor cur =  indexCollection.find(new BasicDBObject("doc_url", url));

        for(int i = 0 ;i< cur.size();i++) {
            DBObject doc = cur.next();
            String word = (String) doc.get("word");

            DBObject query = new BasicDBObject("word_docs",word);
            int wordDocsCount = (int) freqCollection.findOne(query).get("count");
            double idf = (double) Math.log((double)size /(double)wordDocsCount);

            DBObject findQuery = new BasicDBObject("word",word).append("doc_url",url);
            DBObject objQuery = new BasicDBObject("idf",idf);
            DBObject updateQuery = new BasicDBObject("$set",objQuery );

            indexCollection.update(findQuery, updateQuery);


        }

    }


}
