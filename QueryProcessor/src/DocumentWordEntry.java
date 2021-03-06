import java.util.List;

import static jdk.nashorn.internal.objects.Global.Infinity;

@SuppressWarnings("ALL")
public class DocumentWordEntry implements Comparable< DocumentWordEntry > {
    private double totalRank;
    private double RelevanceRank;
    private double pageRank;
    private String url;
    private String title;
    private int frequency;
    private boolean inTitle;
    private boolean inHeader;
    private boolean inUrl;
    private String firstStatement;
    private List<String> imgSrc;
    private String word;
    private int docLength;
    private double tf;
    private double idf;
    private double urlLength;
    private int matches;
    double wordInUrl ;
    double wordInTitle;
    double wordInHeader;
    double sameCountry;
    double recent;


    public DocumentWordEntry(double pageRank, String url,
                             String title, int frequency, boolean inTitle, boolean inHeader, boolean inUrl,
                             String firstStatement, List<String> imgSrc, String word, int docLength, double tf,
                             double idf, double urlLength,double sameCountry,double recent) {

        this.pageRank = pageRank;
        this.url = url;
        this.title = title;
        this.frequency = frequency;
        this.inTitle = inTitle;
        this.inHeader = inHeader;
        this.inUrl = inUrl;
        this.firstStatement = firstStatement;
        this.imgSrc = imgSrc;
        this.word = word;
        this.docLength = docLength;
        this.tf = tf;
        this.idf = idf;
        this.urlLength = urlLength;
        this.matches = 0;
        this.wordInUrl = this.inUrl? 3 : 0;
        this.wordInTitle = this.inTitle? 2 : 0;
        this.wordInHeader = this.inHeader? 1 : 0;
        this.sameCountry = sameCountry;
        this.recent = recent;

    }

// Setters & Getters


    public double getWordInUrl() {
        return wordInUrl;
    }

    public void setWordInUrl(double wordInUrl) {
        this.wordInUrl = wordInUrl;
    }

    public double getWordInTitle() {
        return wordInTitle;
    }

    public void setWordInTitle(double wordInTitle) {
        this.wordInTitle = wordInTitle;
    }

    public double getWordInHeader() {
        return wordInHeader;
    }

    public void setWordInHeader(double wordInHeader) {
        this.wordInHeader = wordInHeader;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public double getPageRank() {
        return pageRank;
    }

    public void setPageRank(double pageRank) {
        this.pageRank = pageRank;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isInHeader() {
        return inHeader;
    }

    public void setInHeader(boolean inHeader) {
        this.inHeader = inHeader;
    }

    public boolean isInUrl() {
        return inUrl;
    }

    public void setInUrl(boolean inUrl) {
        this.inUrl = inUrl;
    }

    public List<String> getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(List<String> imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public double getUrlLength() {
        return urlLength;
    }

    public void setUrlLength(double urlLength) {
        this.urlLength = urlLength;
    }

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


    public String getTitle() {
        return title;
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

    public void calculateTotalRank(){
        double tfidf = tf*idf;
        this.RelevanceRank = this.wordInUrl + this.wordInHeader + this.wordInTitle + tfidf + (this.urlLength ) + (double)this.matches + recent + sameCountry;
        //this.RelevanceRank =   this.urlLength + tfidf  + (this.matches == 0 ? 1 : (double)this.matches)*(wordInUrl + wordInHeader + wordInTitle);
        this.totalRank = RelevanceRank + pageRank;
    }

    public double getTotalRank() {
        return totalRank;
    }

    @Override
    public int compareTo(DocumentWordEntry o) {
        return Double.compare(this.getTotalRank(), o.getTotalRank());
    }
}
