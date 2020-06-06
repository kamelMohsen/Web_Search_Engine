package com.company;

import com.mongodb.*;

import java.lang.Math;

import org.bson.types.ObjectId;


import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("All")
public class DataBase {
    MongoClient mongoClient;
    DB indexDB;
    DBCollection indexCollection;
    DB freqDB;
    DBCollection freqCollection;
    DB crawlerDB;
    DBCollection crawlerCollection;
    DB NGramDB;
    DBCollection NGramCollection;

    public DataBase() {
        this.mongoClient = new MongoClient("localhost", 27017);
        indexDB = mongoClient.getDB("indexDB");
        crawlerDB = mongoClient.getDB("CrawlerDB");
        freqDB = mongoClient.getDB("frequenciesDB");
        crawlerCollection = crawlerDB.getCollection("Links");
        indexCollection = indexDB.getCollection("index_table");
        freqCollection = freqDB.getCollection("frequency_table");
        indexCollection.createIndex(new BasicDBObject("word", 1).append("doc_url", 1), "indexEntry", true);
        indexCollection.createIndex("doc_url");
        freqCollection.createIndex("word_docs");
        NGramDB = mongoClient.getDB("NGramDB");
        NGramCollection = NGramDB.getCollection("NGram_table");
        NGramCollection.createIndex("NGram");

    }


    //deals with crawler data base
    public void setIndexed(String _id) {

        DBObject findQuery = new BasicDBObject("_id", new ObjectId(_id));
        DBObject objQuery = new BasicDBObject("indexed", 1);
        DBObject updateQuery = new BasicDBObject("$set", objQuery);
        if (crawlerCollection.findOne(findQuery) != null)
            crawlerCollection.update(findQuery, updateQuery);

    }

    //deals with crawler data base
    public void getLinks(List<Link> linksList) {
        DBCursor cur = crawlerCollection.find(new BasicDBObject("indexed", 0).append("Visited", 1));
        int size = cur.size();
        for (int i = 0; i < size; i++) {
            DBObject doc = cur.next();

            String URL = (String) doc.get("URL");
            ObjectId objID = (ObjectId) doc.get("_id");
            String ID = objID.toString();

            double pageRank = (double) doc.get("PageRank");
            Link link = new Link(URL, ID, pageRank);
            linksList.add(link);
        }
    }


    public void updateIndex(IndexItem indexItem) {

        if (newOrOld(indexItem) == null) {
            insertNewIndexEntry(indexItem);
        } else {
            updateIndexEntry(indexItem);
        }

    }

    private DBObject newOrOld(IndexItem indexItem) {
        DBObject query = new BasicDBObject("word", indexItem.getWord())
                .append("doc_url", indexItem.getDocumentWordElement().getdocURL());
        return indexCollection.findOne(query);
    }


    private void insertNewIndexEntry(IndexItem indexItem) {

        BasicDBList dblImgs = new BasicDBList();
        for (int i = 0; i < indexItem.getDocumentWordElement().getImgSrcList().size(); i++) {

            dblImgs.add(new BasicDBObject("img_Src", indexItem.getDocumentWordElement().getImgSrc(i)));
        }
        String someString = indexItem.getDocumentWordElement().getdocURL();
        long count = someString.chars().filter(ch -> ch == '/').count();

        double url_length = (double) ((double) 2 / (double) (count - 2));
        indexCollection.insert(new BasicDBObject("word", indexItem.getWord()).append("doc_url", indexItem.getDocumentWordElement().getdocURL())
                .append("title", indexItem.getDocumentWordElement().getTitle())
                .append("first_statement", indexItem.getDocumentWordElement().getFirstStatement())
                .append("word_frequency", indexItem.getDocumentWordElement().getFrequency())
                .append("is_in_url", indexItem.getDocumentWordElement().isInUrl())
                .append("is_in_title", indexItem.getDocumentWordElement().isInTitle())
                .append("is_in_header", indexItem.getDocumentWordElement().isInHeader())
                .append("total_words_count", indexItem.getDocumentWordElement().getWordsCount())
                .append("page_rank", (double) indexItem.getDocumentWordElement().getPageRank())
                .append("tf", ((double) indexItem.getDocumentWordElement().getFrequency() / (double) indexItem.getDocumentWordElement().getWordsCount()))
                .append("idf", (double) 0)
                .append("url_length", url_length)
                .append("region", indexItem.getDocumentWordElement().getRegion())
                .append("date", indexItem.getDocumentWordElement().getDate())
                .append("img_srcs", dblImgs));
    }

    public void updateWordDocsCount(String word) {

        if (newOrOldWordDocsCount(word) == null) {
            insertNewWordDocsCount(word);
        } else {
            updateWordDocsCountEntry(word);
        }
    }

    private DBObject newOrOldWordDocsCount(String word) {
        DBObject query = new BasicDBObject("word_docs", word);
        return freqCollection.findOne(query);
    }

    private void insertNewWordDocsCount(String word) {
        if (word != null) {
            freqCollection.insert(new BasicDBObject("word_docs", word)
                    .append("count", 1));
        } else {
            System.out.println("NULL");
        }
    }

    private void updateWordDocsCountEntry(String word) {
        DBObject findQuery = new BasicDBObject("word_docs", word);
        DBObject objQuery = new BasicDBObject("count", 1);
        DBObject updateQuery = new BasicDBObject("$inc", objQuery);
        freqCollection.update(findQuery, updateQuery);

    }


    private void updateIndexEntry(IndexItem indexItem) {
        DBObject query = new BasicDBObject("word", indexItem.getWord())
                .append("doc_url", indexItem.getDocumentWordElement().getdocURL());
        indexCollection.remove(query);
        insertNewIndexEntry(indexItem);

    }


    public void normalizeURL(String url, int size) {
        DBCursor cur = indexCollection.find(new BasicDBObject("doc_url", url));

        for (int i = 0; i < cur.size(); i++) {
            DBObject doc = cur.next();
            String word = (String) doc.get("word");

            DBObject query = new BasicDBObject("word_docs", word);
            int wordDocsCount = (int) freqCollection.findOne(query).get("count");
            double idf = (double) Math.log((double) size / (double) wordDocsCount);

            DBObject findQuery = new BasicDBObject("word", word).append("doc_url", url);
            DBObject objQuery = new BasicDBObject("idf", idf);
            DBObject updateQuery = new BasicDBObject("$set", objQuery);

            indexCollection.update(findQuery, updateQuery);


        }

    }


    public void addNGtworamWords(String Sentence) {
        List<String> threeNGram = null;
        List<String> twoNGram = null;
        List<String> oneNGram = null;

        if(Sentence.split(" ").length>=3){
            threeNGram = threengrams(Sentence);
            twoNGram = twongrams(Sentence);
            oneNGram = onengrams(Sentence);
        }
        else if(Sentence.split(" ").length==2){
            twoNGram = twongrams(Sentence);
            oneNGram = onengrams(Sentence);
        }
        else if(Sentence.split(" ").length==1){
            oneNGram = onengrams(Sentence);
        }
        if(threeNGram != null){
            for(int i = 0 ; i < threeNGram.size() ; i++)
            {
                DBObject findQuery = new BasicDBObject("NGram", threeNGram.get(i));
                if(NGramCollection.findOne(findQuery) == null){
                    NGramCollection.insert(new BasicDBObject("NGram",threeNGram.get(i)));
                }
            }
        }
        if(twoNGram != null){
            for(int i = 0 ; i < twoNGram.size() ; i++)
            {
                DBObject findQuery = new BasicDBObject("NGram", twoNGram.get(i));
                if(NGramCollection.findOne(findQuery) == null){
                    NGramCollection.insert(new BasicDBObject("NGram",twoNGram.get(i)));
                }
            }
        }
        if(oneNGram != null){
            for(int i = 0 ; i < oneNGram.size() ; i++)
            {
                DBObject findQuery = new BasicDBObject("NGram", oneNGram.get(i));
                if(NGramCollection.findOne(findQuery) == null){
                    NGramCollection.insert(new BasicDBObject("NGram",oneNGram.get(i)));
                }
            }
        }
    }


    public List<String> threengrams(String str) {
        List<String> ngrams = new ArrayList<String>();
        for (int i = 0; i < str.split(" ").length - 3 + 1; i++) {
            ngrams.add(str.split(" ")[i] + " " + str.split(" ")[i+1] + " " + str.split(" ")[i+2]);

        }

        return ngrams;
    }
    public List<String> twongrams(String str) {
        List<String> ngrams = new ArrayList<String>();
        for (int i = 0; i < str.split(" ").length - 2 + 1; i++) {
            ngrams.add(str.split(" ")[i] + " " + str.split(" ")[i+1] );
        }

        return ngrams;
    }
    public List<String> onengrams(String str) {
        List<String> ngrams = new ArrayList<String>();
        for (int i = 0; i < str.split(" ").length - 1 + 1; i++) {
            ngrams.add(str.split(" ")[i]);
        }

        return ngrams;
    }
}
