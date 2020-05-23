package com.company;

public class DocumentWordEntry {
    private int docID;
    private int frequency;
    private boolean inTitle;
    private String firstStatement;
    private String imgSrc;

    public DocumentWordEntry(int docID, int frequency, boolean inTitle, String firstStatement, String imgSrc) {
        this.docID = docID;
        this.frequency = frequency;
        this.inTitle = inTitle;
        this.firstStatement = firstStatement;
        this.imgSrc = imgSrc;

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

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
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
