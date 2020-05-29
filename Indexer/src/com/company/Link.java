package com.company;

public class Link {
    private String url;
    private String id;
    private double pageRank;


    public Link(String url, String id,double pageRank) {
        this.url = url;
        this.id = id;
        this.pageRank = pageRank;
    }


    public double getPageRank() {
        return pageRank;
    }

    public void setPageRank(double pageRank) {
        this.pageRank = pageRank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
