package com.company;

public class DocumentWordEntry {
    private int docID;
    private int frequency;
    private boolean inTitle;

    public DocumentWordEntry(int docID, int frequency, boolean inTitle) {
        this.docID = docID;
        this.frequency = frequency;
        this.inTitle = inTitle;
    }

    // Setters & Getters
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
