package Indexer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Keyword card with stem form, terms dictionary and frequency rank
 */
@SuppressWarnings("All")
class Keyword implements Comparable<Keyword> {


    private final String stem;
    private final Set<String> terms = new HashSet<>();
    private int frequency;
    private String firstStatement;
    private boolean inTitle;
    private boolean inHeader;
    private boolean inUrl;
    private List<String> imgSrcList;




    public Keyword(String stem,String firstStatement, String imgSrc) {

        this.stem = stem;
        this.firstStatement = firstStatement;
        this.imgSrcList = new LinkedList<>();
        this.imgSrcList.add(imgSrc);
    }
    public Keyword(String stem,String firstStatement, boolean inTitle,boolean inHeader,boolean inUrl) {

        this.stem = stem;
        this.firstStatement = firstStatement;
        this.imgSrcList = new LinkedList<>();
        this.inHeader = inHeader;
        this.inTitle = inTitle;
        this.inUrl = inUrl;
    }


    public boolean isInUrl() {
        return inUrl;
    }

    public void setInUrl(boolean inUrl) {
        this.inUrl = inUrl;
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

    public boolean isInHeader() {
        return inHeader;
    }

    public void setInHeader(boolean inHeader) {
        this.inHeader = inHeader;
    }

    public void setImgSrcList(List<String> imgSrcList) {
        this.imgSrcList = imgSrcList;
    }

    public List<String> getImgSrcList() {
        return this.imgSrcList;
    }
    public String getImgSrc(int i) {
        return imgSrcList.get(i);
    }

    public void addImgSrc(String imgSrc) {
        this.imgSrcList.add(imgSrc);
    }

    public String getFirstStatement() {
        return firstStatement;
    }

    public void setFirstStatement(String firstStatement) {
        this.firstStatement = firstStatement;
    }
    public void add(String term) {
        this.terms.add(term);
        this.frequency++;
    }

    /**
     * Compare two keywords by frequency rank
     *
     * @param keyword
     * @return int, which contains comparison results
     */
    @Override
    public int compareTo(Keyword keyword) {
        return Integer.valueOf(keyword.frequency).compareTo(this.frequency);
    }

    /**
     * Get stem's hashcode
     *
     * @return int, which contains stem's hashcode
     */
    @Override
    public int hashCode() {
        return this.getStem().hashCode();
    }

    /**
     * Check if two stems are equal
     *
     * @param o
     * @return boolean, true if two stems are equal
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Keyword)) return false;

        Keyword that = (Keyword) o;

        return this.getStem().equals(that.getStem());
    }

    /**
     * Get stem form of keyword
     *
     * @return String, which contains getStemForm form
     */
    public String getStem() {
        return this.stem;
    }

    /**
     * Get terms dictionary of the stem
     *
     * @return Set<String>, which contains set of terms of the getStemForm
     */
    public Set<String> getTerms() {
        return this.terms;
    }

    /**
     * Get stem frequency rank
     *
     * @return int, which contains getStemForm frequency
     */
    public int getFrequency() {
        return this.frequency;
    }
}