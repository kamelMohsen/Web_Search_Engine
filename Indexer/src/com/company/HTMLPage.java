package com.company;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UncheckedIOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import org.jsoup.select.NodeVisitor;

import javax.net.ssl.SSLException;

import java.net.SocketException;
import java.net.SocketTimeoutException;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class HTMLPage {

    private String url;
    private Document parsedHtml;
    private String title;
    private double pageRank;
    private String text;
    private int wordsCount;
    private List<ImageContainer> imgList;


    //Constructor that makes HtmlPage with initialized info
    public HTMLPage( String url, double pageRank) throws IOException {
        this.imgList = new LinkedList<>();
        this.text = "";
        this.pageRank = pageRank;
        this.wordsCount =0;
        try {
            parsedHtml = Jsoup.connect(url).get();
            StringBuilder parsedText = new StringBuilder();
            this.url = url;

            // Extract title
            this.title = parsedHtml.title().toLowerCase().replaceAll("[^a-z0-9]", " ");

            String alt;
            String src;

            for(Element metaTag: parsedHtml.getElementsByTag("img")) {

                alt = metaTag.attr("alt").toLowerCase();


                src = metaTag.attr("src").toLowerCase();


                if(!alt.equals("") && !src.equals("")) {
                    ImageContainer imageContainer = new ImageContainer(alt,src);
                    imgList.add(imageContainer);
                }
            }



            // Extract text
            parsedHtml.body().traverse(new NodeVisitor() {
                @Override
                public void head(Node node, int i) {
                    if (node instanceof TextNode && !((TextNode) node).isBlank()) {
                        parsedText.append(((TextNode) node).text().toLowerCase())
                                .append(" ");
                        wordsCount++;
                    }
                }

                @Override
                public void tail(Node node, int i) {

                }
            });
            this.text = parsedText.toString();



        }catch (HttpStatusException | SSLException | SocketException | SocketTimeoutException | UncheckedIOException ignored)
        {

        }

    }

   // Setters & Getters

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

    public List<ImageContainer> getImgList() {
        return imgList;
    }

    public void setImgList(List<ImageContainer> imgList) {
        this.imgList = imgList;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Document getParsedHtml() {
        return parsedHtml;
    }

    public void setHtmlCode(Document parsedHtml) {
        this.parsedHtml = parsedHtml;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    //Extra function made it at first to extract html code from html file if existing
    public static String HTMLToString(String path)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }
        String content = contentBuilder.toString();

        return content;
    }
}
