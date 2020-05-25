package com.company;

import com.mongodb.*;

import org.bson.types.ObjectId;


import java.util.List;


@SuppressWarnings("deprecation")
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
        indexCollection = indexDB.getCollection("wikipedia_500_pages_try_6");
        crawlerCollection = crawlerDB.getCollection("Links");
        indexCollection.createIndex("word");
        indexCollection.createIndex(new BasicDBObject("word", 1).append("doc_url",1),"indexEntry",true);

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
            Link link = new Link(URL,ID);
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

        BasicDBList dbl = new BasicDBList();
        BasicDBList dblImgs = new BasicDBList();
        for(int i = 0;i<indexItem.getDocumentWordElement().getImgSrcList().size();i++)
        {

            dblImgs.add(new BasicDBObject("img_Src",indexItem.getDocumentWordElement().getImgSrc(i)));
        }

        indexCollection.insert(new BasicDBObject("word", indexItem.getWord()).append("doc_url",indexItem.getDocumentWordElement().getdocURL())
                .append("word_frequency",indexItem.getDocumentWordElement().getFrequency())
                .append("is_in_title",indexItem.getDocumentWordElement().isInTitle())
                .append("first_statement", indexItem.getDocumentWordElement().getFirstStatement())
                .append("title",indexItem.getDocumentWordElement().getTitle())
                .append("page_rank",indexItem.getDocumentWordElement().getPageRank())
                .append("total_words_count",indexItem.getDocumentWordElement().getWordsCount())
                .append("img_srcs",dblImgs));
    }
    private void updateIndexEntry(IndexItem indexItem){
        DBObject query = new BasicDBObject("word", indexItem.getWord())
                .append("doc_url",indexItem.getDocumentWordElement().getdocURL());
        indexCollection.remove(query);
        insertNewIndexEntry(indexItem);

    }



}
