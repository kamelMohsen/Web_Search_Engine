package com.company;

import javax.swing.*;
import javax.swing.text.html.HTML;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.exit;
import static java.lang.System.setErr;

public class Indexer {

    public static void main(String[] args)  {
        DataBase dataBase = new DataBase();
        index(0,"https://www.bbc.com/",dataBase);
        index(1,"https://en.wikipedia.org/wiki/Main_Page",dataBase);

    }

    public static void index(int id, String url, DataBase dataBase){

        //Create HTMLPage object
            HTMLPage newHtml = createHtmlPage(id,url);
            List<Keyword> keywordsList = findKeywords(newHtml);
            for(int i = 0 ;i<keywordsList.size();i++)
            {
                DocumentWordEntry documentWordElement = getDocumentWordElement(keywordsList.get(i).getStem(),keywordsList.get(i).getFrequency(),newHtml);
                IndexItem newIndexEntry = new IndexItem(keywordsList.get(i).getStem(),documentWordElement);
                dataBase.updateIndex(newIndexEntry);
            }
    }

    public static HTMLPage createHtmlPage(int id, String url)  {
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

    public static DocumentWordEntry getDocumentWordElement(String word,int frequency, HTMLPage htmlPage) {

        DocumentWordEntry newDocumentWordEntry = null;
        List<Keyword> keywordsListTitle = null;

        try {
            keywordsListTitle = KeywordsExtractor.getKeywordsList(htmlPage.getTitle());
        } catch (IOException e) {
            System.out.println("Failed extracting words from html title");
            e.printStackTrace();
            exit(0);
        }

            newDocumentWordEntry = new DocumentWordEntry(htmlPage.getId(),frequency,inTitle(word,keywordsListTitle));


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
