public class UrlData {

    private String associatedWord;
    private String url;
    private double PageRank;
    private double TF;  // Frequency of term over length of page
    private double IDF; // log(total number of documents/ number of documents containing the term)
    private String Date;

    public UrlData(String word, String url, double PageRank, double termFrequency, double IDF){

    }
    public double CalculateRelevanceRank(){
        return 0.0;
    }
}
