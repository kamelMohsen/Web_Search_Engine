import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
@SuppressWarnings("ALL")
public class DocumentWordEntry implements Comparable< DocumentWordEntry > {
    private double totalRank;
    private double RelevanceRank;
    private String url;
    private String title;
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


    public DocumentWordEntry(String url, int frequency, boolean inTitle, String firstStatement,String name, String imgSrc, double PageRank, int PageLength ,String title,double tf,double idf) {
        this.url = url;
        this.frequency = frequency;
        this.inTitle = inTitle;
        this.firstStatement = firstStatement;
        this.imgSrc = imgSrc;
        this.name = name;
        this.rank = PageRank;
        this.docLength = PageLength;
        this.title = title;
        this.tf = tf;
        this.idf = idf;

    }


    // Setters & Getters


    public DocumentWordEntry(double TotalRank){
        this.totalRank = TotalRank;
    }
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
    public String getImgSrc() {
        return imgSrc;
    }
    public String getTitle() {
        return title;
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
