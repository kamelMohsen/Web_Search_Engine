package com.company;

import java.util.List;

public class DocumentWordEntry {
    private String docID;
    private int frequency;
    private boolean inTitle;
    private String firstStatement;
    private List<String> imgSrc;

    public DocumentWordEntry(String docID, int frequency, boolean inTitle, String firstStatement, List<String> imgSrc) {
        this.docID = docID;
        this.frequency = frequency;
        this.inTitle = inTitle;
        this.firstStatement = firstStatement;
        this.imgSrc = imgSrc;

    }

    // Setters & Getters

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
}
