package com.company;

import com.mongodb.*;

import org.bson.types.ObjectId;

import java.util.LinkedList;
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
        indexCollection = indexDB.getCollection("wikipedia_500_pages_try_3");
        crawlerCollection = crawlerDB.getCollection("Links");
        indexCollection.createIndex("word");

    }

    public void setIndexed(String _id){

        DBObject findQuery = new BasicDBObject("_id",new ObjectId(_id));
        DBObject objQuery = new BasicDBObject("indexed", 1);
        DBObject updateQuery = new BasicDBObject("$set",objQuery );
        if(crawlerCollection.findOne(findQuery) != null)
            crawlerCollection.update(findQuery, updateQuery);

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

    public void updateIndex(LinkedList<IndexItem> indexItemList) {



                insertNewIndexEntry(indexItemList);


    }


    public void updateIndex(IndexItem indexItem) {

        if(newOrOldWord(indexItem) == null)
        {
        insertNewIndexEntry(indexItem);
        }
        else
        {
            updateIndexEntry(indexItem);
        }

    }

    private DBObject newOrOldWord(IndexItem indexItem){
        DBObject query = new BasicDBObject("word", indexItem.getWord());
        return indexCollection.findOne(query);
    }
    private DBObject newOrOldDocumentWord(IndexItem indexItem){

        DBObject query = new BasicDBObject("documents_"+indexItem.getWord()+".doc_url", indexItem.getDocumentWordElement().getdocURL());
        return indexCollection.findOne(query);
    }


    private void insertNewIndexEntry(LinkedList<IndexItem> indexItemList){
        BasicDBList dbl = new BasicDBList();;
        BasicDBList dblImgs;

        for(int i =0 ; i< indexItemList.size() ;i++ )
        {

            dblImgs = new BasicDBList();
            for (int j = 0; j < indexItemList.get(i).getDocumentWordElement().getImgSrcList().size(); j++) {

                dblImgs.add(new BasicDBObject("img_Src", indexItemList.get(i).getDocumentWordElement().getImgSrc(j)));
            }
            dbl.add(new BasicDBObject("doc_url", indexItemList.get(i).getDocumentWordElement().getdocURL())
                    .append("word_frequency", indexItemList.get(i).getDocumentWordElement().getFrequency())
                    .append("is_in_title", indexItemList.get(i).getDocumentWordElement().isInTitle())
                    .append("first_statement", indexItemList.get(i).getDocumentWordElement().getFirstStatement())
                    .append("img_srcs", dblImgs)
                    .append("title", indexItemList.get(i).getDocumentWordElement().getTitle())
                    .append("page_rank", indexItemList.get(i).getDocumentWordElement().getPageRank())
                    .append("total_words_count", indexItemList.get(i).getDocumentWordElement().getWordsCount()));

        }
        BasicDBObject indexEntry = new BasicDBObject("word", indexItemList.get(0).getWord()).append("documents_"+indexItemList.get(0).getWord(), dbl);
        indexCollection.insert(indexEntry);
    }


    private void insertNewIndexEntry(IndexItem indexItem){

        BasicDBList dbl = new BasicDBList();
        BasicDBList dblImgs = new BasicDBList();
        for(int i = 0;i<indexItem.getDocumentWordElement().getImgSrcList().size();i++)
        {

            dblImgs.add(new BasicDBObject("img_Src",indexItem.getDocumentWordElement().getImgSrc(i)));
        }
        dbl.add(new BasicDBObject("doc_url",indexItem.getDocumentWordElement().getdocURL())
                .append("word_frequency",indexItem.getDocumentWordElement().getFrequency())
                .append("is_in_title",indexItem.getDocumentWordElement().isInTitle())
                .append("first_statement", indexItem.getDocumentWordElement().getFirstStatement())
                .append("img_srcs",dblImgs)
                .append("title",indexItem.getDocumentWordElement().getTitle())
                .append("page_rank",indexItem.getDocumentWordElement().getPageRank())
                .append("total_words_count",indexItem.getDocumentWordElement().getWordsCount()));


        BasicDBObject indexEntry = new BasicDBObject("word", indexItem.getWord()).append("documents_"+indexItem.getWord(), dbl);
        indexCollection.insert(indexEntry);
    }
    private void updateIndexEntry(IndexItem indexItem){

        if(newOrOldDocumentWord(indexItem) == null) {
            DBObject findQuery = new BasicDBObject("word", indexItem.getWord());
            BasicDBList dblImgs = new BasicDBList();
            for(int i = 0;i<indexItem.getDocumentWordElement().getImgSrcList().size();i++)
            {
                dblImgs.add(new BasicDBObject("img_Src",indexItem.getDocumentWordElement().getImgSrc(i)));
            }
            DBObject listItem = new BasicDBObject("documents_"+indexItem.getWord(), new BasicDBObject("doc_url", indexItem.getDocumentWordElement().getdocURL()).append("word_frequency", indexItem.getDocumentWordElement().getFrequency())
                    .append("is_in_title", indexItem.getDocumentWordElement().isInTitle())
                    .append("first_statement", indexItem.getDocumentWordElement().getFirstStatement())
                    .append("img_srcs", dblImgs)
                    .append("title",indexItem.getDocumentWordElement().getTitle())
                    .append("page_rank",indexItem.getDocumentWordElement().getPageRank())
                    .append("total_words_count",indexItem.getDocumentWordElement().getWordsCount()));
            DBObject updateQuery = new BasicDBObject("$push", listItem);
            indexCollection.update(findQuery, updateQuery);
        }
        else {

            DBObject findQuery = new BasicDBObject("documents_"+indexItem.getWord()+".doc_url", indexItem.getDocumentWordElement().getdocURL());
            DBObject listItem = new BasicDBObject("documents_"+indexItem.getWord(), new BasicDBObject("doc_url", indexItem.getDocumentWordElement().getdocURL()));

            DBObject updateQuery = new BasicDBObject("$pull", listItem);
            indexCollection.update(findQuery, updateQuery);
            BasicDBList dblImgs = new BasicDBList();
            for (int i = 0; i < indexItem.getDocumentWordElement().getImgSrcList().size(); i++)
            {
                dblImgs.add(new BasicDBObject("img_Src",indexItem.getDocumentWordElement().getImgSrc(i)));
            }
            findQuery = new BasicDBObject("word", indexItem.getWord());
            listItem = new BasicDBObject("documents_"+indexItem.getWord(), new BasicDBObject("doc_url", indexItem.getDocumentWordElement().getdocURL()).append("word_frequency", indexItem.getDocumentWordElement().getFrequency())
                    .append("is_in_title", indexItem.getDocumentWordElement().isInTitle())
                    .append("first_statement", indexItem.getDocumentWordElement().getFirstStatement())
                    .append("img_srcs", dblImgs)
                    .append("title",indexItem.getDocumentWordElement().getTitle())
                    .append("page_rank",indexItem.getDocumentWordElement().getPageRank())
                    .append("total_words_count",indexItem.getDocumentWordElement().getWordsCount()));
            updateQuery = new BasicDBObject("$push", listItem);
            indexCollection.update(findQuery, updateQuery);

        }
    }



}
