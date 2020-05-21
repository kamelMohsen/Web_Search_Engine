package com.company;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeVisitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HTMLPage {
    private Integer id;
    private String url;
    private Document parsedHtml;
    private String title;
    private String text;



    //Constructor that makes HtmlPage with initialized info
    public HTMLPage(Integer id, String url) throws IOException {

        parsedHtml = Jsoup.connect(url).get();
        StringBuilder parsedText = new StringBuilder();
        this.id = id;
        this.url = url;

        // Extract title
        this.title = parsedHtml.title().toLowerCase().replaceAll("[^a-z0-9]", " ");


        // Extract text
        parsedHtml.body().traverse(new NodeVisitor() {
            @Override
            public void head(Node node, int i) {
                if (node instanceof TextNode && !((TextNode) node).isBlank()) {
                    parsedText.append(((TextNode) node).text().toLowerCase().replaceAll("[^a-z0-9]", " "))
                            .append(" ");
                }
            }

            @Override
            public void tail(Node node, int i) {

            }
        });
        this.text = parsedText.toString();
    }

   // Setters & Getters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
