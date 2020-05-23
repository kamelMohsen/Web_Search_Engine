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

public class Indexer {


    public static void main(String[] args)  {
        DataBase dataBase = new DataBase();
        long startTime = System.nanoTime();

        List<Link> linksList = new LinkedList<>();
        dataBase.getLinks(linksList);

        for(int i =0;i<linksList.size();i++) {
            index(linksList.get(i).getId(),linksList.get(i).getUrl(), dataBase);
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Total time is : "+totalTime/1000000000);
    }

    public static void index(String id, String url, DataBase dataBase){

        //Create HTMLPage object
            HTMLPage newHtml = createHtmlPage(id,url);
            if(newHtml.getParsedHtml() != null)
            {
            List<Keyword> keywordsList = findKeywords(newHtml);
            mergeImages(newHtml,keywordsList);

            for(int i = 0 ;i<keywordsList.size();i++)
            {
                DocumentWordEntry documentWordElement = getDocumentWordElement(keywordsList.get(i).getStem(),keywordsList.get(i).getFrequency(),newHtml,keywordsList.get(i).getFirstStatement(),keywordsList.get(i).getImgSrc());
                IndexItem newIndexEntry = new IndexItem(keywordsList.get(i).getStem(),documentWordElement);
                dataBase.updateIndex(newIndexEntry);
            }
            }
    }

    public static HTMLPage createHtmlPage(String id, String url)  {
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
    public static void mergeImages(HTMLPage htmlPage,List<Keyword> keywordsList){
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
    public static void getMatches(List<Keyword> keywordsList,List<Keyword> imageKeywordsList) {
        for(int i = 0; i < keywordsList.size(); i++){
            for(int j = 0; j < imageKeywordsList.size(); j++){
                if(keywordsList.get(i).getStem().equals(imageKeywordsList.get(j).getStem())){
                    keywordsList.get(i).setImgSrc(imageKeywordsList.get(j).getImgSrc());
                }
            }
        }
    }
    public static List<Keyword> findKeywords(HTMLPage htmlPage) {
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

    public static DocumentWordEntry getDocumentWordElement(String word,int frequency, HTMLPage htmlPage, String firstStatement, String imageSrc) {

        DocumentWordEntry newDocumentWordEntry = null;
        List<Keyword> keywordsListTitle = null;

        try {
            keywordsListTitle = KeywordsExtractor.getKeywordsList(htmlPage.getTitle());
        } catch (IOException e) {
            System.out.println("Failed extracting words from html title");
            e.printStackTrace();
            exit(0);
        }

            newDocumentWordEntry = new DocumentWordEntry(htmlPage.getId(),frequency,inTitle(word,keywordsListTitle),firstStatement,imageSrc);


        return newDocumentWordEntry;
    }

    public static boolean inTitle(String word, List<Keyword> keywordsList){

        for (int i = 0; i < keywordsList.size(); i++) {
            if(keywordsList.get(i).getStem().equals(word))
            {
                return true;
            }
        }
        return false;
    }





}
