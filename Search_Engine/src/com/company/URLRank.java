package com.company;

public class URLRank {
    private double PageRank;
    private int NoOfOutBoundLinks;

    public URLRank(double rank, int no) {
        this.PageRank = rank;
        this.NoOfOutBoundLinks = no;
    }

    public int getNoOfOutBoundLinks() {
        return NoOfOutBoundLinks;
    }

    public void setNoOfOutBoundLinks(int noOfOutBoundLinks) {
        NoOfOutBoundLinks = noOfOutBoundLinks;
    }

    public double getPageRank() {
        return PageRank;
    }

    public void setPageRank(double pageRank) {
        PageRank = pageRank;
    }
    public double calculateRankSlice(){
        return (double) PageRank/NoOfOutBoundLinks;
    }
}

