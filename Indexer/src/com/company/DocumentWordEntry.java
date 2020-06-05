package com.company;

import java.util.Date;
import java.util.List;

@SuppressWarnings("All")
public class DocumentWordEntry {
    private String docURL;
    private int frequency;
    private boolean inTitle;
    private String firstStatement;
    private List<String> imgSrc;
    private String title;
    private double pageRank;
    private int wordsCount;
    private boolean inHeader;
    private boolean inUrl;
    private String region;
    private Date date;

    public DocumentWordEntry(String docURL, int frequency, boolean inTitle, String firstStatement, List<String> imgSrc,
                             String title, double pageRank, int wordsCount, boolean inHeader,
                             boolean inUrl, String region,Date date) {
        this.docURL = docURL;
        this.frequency = frequency;
        this.inTitle = inTitle;
        this.firstStatement = firstStatement;
        this.imgSrc = imgSrc;
        this.title = title;
        this.pageRank = pageRank;
        this.wordsCount = wordsCount;
        this.inHeader = inHeader;
        this.inUrl = inUrl;
        this.region = region;
        this.date = date;
    }


    // Setters & Getters

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setInUrl(boolean inUrl) {
        this.inUrl = inUrl;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public boolean isInUrl() {
        return inUrl;
    }

    public boolean isInHeader() {
        return inHeader;
    }

    public void setInHeader(boolean inHeader) {
        this.inHeader = inHeader;
    }

    public String getDocURL() {
        return docURL;
    }

    public void setDocURL(String docURL) {
        this.docURL = docURL;
    }

    public List<String> getImgSrc() {
        return imgSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPageRank() {
        return pageRank;
    }

    public void setPageRank(double pageRank) {
        this.pageRank = pageRank;
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public List<String> getImgSrcList() {
        return imgSrc;
    }

    public String getImgSrc(int i) {
        return imgSrc.get(i);
    }

    public void setImgSrc(List<String> imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getFirstStatement() {
        return firstStatement;
    }

    public void setFirstStatement(String firstStatement) {
        this.firstStatement = firstStatement;
    }

    public String getdocURL() {
        return docURL;
    }

    public void setdocURL(String docID) {
        this.docURL = docID;
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
}
