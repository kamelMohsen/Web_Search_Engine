package com.company;

import org.jsoup.nodes.Element;

import javax.swing.*;
import javax.swing.text.html.HTML;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static java.lang.System.exit;
import static java.lang.System.setErr;

public class Indexer  implements Runnable{

    DataBase dataBase ;
    List<Link> linksList;
    String ID;
    String url;

    public Indexer(DataBase dataBase, List<Link> linksList) {
        this.dataBase = dataBase;
        this.linksList = linksList;
    }

    public void startIndexing() {


        while (true) {
            synchronized (linksList) {
                if(linksList.size()==0)
                    break;
                try {
                    this.url = "";
                    this.ID = "";
                    this.url = linksList.get(0).getUrl();
                    this.ID = linksList.remove(0).getId();
                }catch(NullPointerException e)
                {

                }
            }
            index(this.ID,this.url , dataBase);
        }


    }
    public  void index(String id, String url, DataBase dataBase){

        //Create HTMLPage object
            HTMLPage newHtml = createHtmlPage(id,url);
            if(newHtml.getParsedHtml() != null)
            {
            List<Keyword> keywordsList = findKeywords(newHtml);
            mergeImages(newHtml,keywordsList);

            for(int i = 0 ;i<keywordsList.size();i++)
            {
                DocumentWordEntry documentWordElement = getDocumentWordElement(keywordsList.get(i).getStem(),keywordsList.get(i).getFrequency(),newHtml,keywordsList.get(i).getFirstStatement(),keywordsList.get(i).getImgSrcList());
                IndexItem newIndexEntry = new IndexItem(keywordsList.get(i).getStem(),documentWordElement);
                synchronized (dataBase){
                dataBase.updateIndex(newIndexEntry);
                dataBase.setIndexed(id);
                }
            }
            }
    }

    public  HTMLPage createHtmlPage(String id, String url)  {
        HTMLPage newHtml = null;
        try {
            newHtml = new HTMLPage(id,url);
        } catch (IOException e) {
            System.out.println("Failed Creating Html Page object");
            e.printStackTrace();
            exit(0);
        }
            return newHtml;
    }
    public  void mergeImages(HTMLPage htmlPage,List<Keyword> keywordsList){
        List<Keyword> imageKeywordsList = null;



            for(int i = 0; i<htmlPage.getImgList().size(); i++){
                try {
                    imageKeywordsList = KeywordsExtractor.getKeywordsList(htmlPage.getImgList().get(i).getAltText(),htmlPage.getImgList().get(i).getSrc());

                } catch (IOException e) {
                    System.out.println("Failed extracting words from image alt text");
                    e.printStackTrace();
                    exit(0);
                }
                getMatches(keywordsList,imageKeywordsList);
            }

    }
    public  void getMatches(List<Keyword> keywordsList,List<Keyword> imageKeywordsList) {
        for(int i = 0; i < keywordsList.size(); i++){
            for(int j = 0; j < imageKeywordsList.size(); j++){
                if(keywordsList.get(i).getStem().equals(imageKeywordsList.get(j).getStem())){
                    keywordsList.get(i).addImgSrc(imageKeywordsList.get(j).getImgSrc(0));
                }
            }
        }
    }
    public  List<Keyword> findKeywords(HTMLPage htmlPage) {
        List<Keyword> keywordsList = null;
        try {
            keywordsList = KeywordsExtractor.getKeywordsList(htmlPage.getText() + htmlPage.getTitle());
        } catch (IOException e) {
            System.out.println("Failed extracting words from html page");
            e.printStackTrace();
            exit(0);
        }

        return keywordsList;
    }

    public  DocumentWordEntry getDocumentWordElement(String word,int frequency, HTMLPage htmlPage, String firstStatement, List<String> imageSrcList) {

        DocumentWordEntry newDocumentWordEntry = null;
        List<Keyword> keywordsListTitle = null;

        try {
            keywordsListTitle = KeywordsExtractor.getKeywordsList(htmlPage.getTitle());
        } catch (IOException e) {
            System.out.println("Failed extracting words from html title");
            e.printStackTrace();
            exit(0);
        }

            newDocumentWordEntry = new DocumentWordEntry(htmlPage.getId(),frequency,inTitle(word,keywordsListTitle),firstStatement,imageSrcList);


        return newDocumentWordEntry;
    }

    public  boolean inTitle(String word, List<Keyword> keywordsList){

        for (int i = 0; i < keywordsList.size(); i++) {
            if(keywordsList.get(i).getStem().equals(word))
            {
                return true;
            }
        }
        return false;
    }


    @Override
    public void run() {
            startIndexing();
    }
}
