import java.util.List;
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

    public DocumentWordEntry(double pageRank, String url,
                             String title, int frequency, boolean inTitle, boolean inHeader, boolean inUrl,
                             String firstStatement, List<String> imgSrc, String word, int docLength, double tf,
                             double idf, double urlLength) {

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
    }

// Setters & Getters


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
        double wordInUrl = inUrl? 3 : 0;
        double wordInTitle = inTitle? 2 : 0;
        double wordInHeader = inHeader? 1 : 0;
        double tfidf = tf*idf;
        this.RelevanceRank = wordInUrl + wordInHeader + wordInTitle + tfidf + urlLength;
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
