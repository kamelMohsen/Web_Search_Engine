import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class DocumentWordEntry implements Comparable< DocumentWordEntry > {
    private double totalRank;
    private double RelevanceRank;
    private String url;
    
    private String docID;
    private int frequency;
    private boolean inTitle;
    private String firstStatement;
    private String imgSrc;
    private String name;
    private double rank;
    private int docLength;
    private double tf;
    private double idf;
    private double noOfRelevantDocuments;
    private double noOfTotalDocuments;

    public void setTotalRank(double totalRank) {
        this.totalRank = totalRank;
    }

    public double getRelevanceRank() {
        return RelevanceRank;
    }

    public void setRelevanceRank(double relevanceRank) {
        RelevanceRank = relevanceRank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public int getDocLength() {
        return docLength;
    }

    public void setDocLength(int docLength) {
        this.docLength = docLength;
    }

    public double getTf() {
        return tf;
    }

    public void setTf(double tf) {
        this.tf = tf;
    }

    public double getIdf() {
        return idf;
    }

    public void setIdf(double idf) {
        this.idf = idf;
    }

    public double getNoOfRelevantDocuments() {
        return noOfRelevantDocuments;
    }

    public void setNoOfRelevantDocuments(double noOfRelevantDocuments) {
        this.noOfRelevantDocuments = noOfRelevantDocuments;
    }

    public double getNoOfTotalDocuments() {
        return noOfTotalDocuments;
    }

    public void setNoOfTotalDocuments(double noOfTotalDocuments) {
        this.noOfTotalDocuments = noOfTotalDocuments;
    }

    public DocumentWordEntry(String docID, int frequency, boolean inTitle, String firstStatement, String imgSrc
    , String name, double PageRank, int PageLength) {
        this.docID = docID;
        this.frequency = frequency;
        this.inTitle = inTitle;
        this.firstStatement = firstStatement;
        this.imgSrc = imgSrc;
        this.name = name;
        //this.rank = PageRank;

        this.docLength = PageLength;
        MongoClient mongoMan = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoMan.getDatabase("CrawlerDB");
       MongoCollection<Document> linksCollection = database.getCollection("Links");
        this.noOfTotalDocuments = linksCollection.countDocuments();
//        MongoCursor<Document> cur = linksCollection.find(eq("_id", docID)).cursor();
        //double pageRank = (double) cur.next().get("PageRank");
        this.rank = 0;
        this.tf = (double) frequency/docLength;

    }
    public DocumentWordEntry(double TotalRank){
        this.totalRank = TotalRank;
    }

    // Setters & Getters

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getFirstStatement() {
        return firstStatement;
    }

    public void setFirstStatement(String firstStatement) {
        this.firstStatement = firstStatement;
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public boolean isInTitle() {
        return inTitle;
    }

    public void setInTitle(boolean inTitle) {
        this.inTitle = inTitle;
    }

    public void setNoOfRelevantDocuments(int no){
        this.noOfRelevantDocuments = no;
    }
    public void calculateIdf(){
        this.idf = (double) Math.log(noOfTotalDocuments/1);
    }

    public void calculateTotalRank(){
        double wordInTitle = inTitle? 0.5 : 0;
        double tfidf = tf*idf;
        this.RelevanceRank = wordInTitle + tfidf;
        this.totalRank = RelevanceRank + rank;
    }

    public double getTotalRank() {
        return totalRank;
    }

    @Override
    public int compareTo(DocumentWordEntry o) {
        return Double.compare(this.getTotalRank(), o.getTotalRank());
    }
}
