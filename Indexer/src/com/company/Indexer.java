package com.company;


import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static java.lang.System.exit;

public class Indexer  implements Runnable{

    DataBase dataBase ;
    final List<Link> linksList;
    String url;
    String ID;
    double pageRank;
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
                    this.url = linksList.get(0).getUrl();
                    this.ID = linksList.get(0).getId();
                    this.pageRank = linksList.get(0).getPageRank();
                    linksList.remove(0);
                    System.out.println(linksList.size());
                }catch(NullPointerException ignored)
                {
                }

            }
            index(this.ID,this.url,this.pageRank , dataBase);
        }


    }
    public  void index(String ID, String url,double pageRank, DataBase dataBase){

        //Create HTMLPage object
            HTMLPage newHtml = createHtmlPage(url,pageRank);
            if(newHtml.getParsedHtml() != null)
            {
            List<Keyword> keywordsList = findKeywords(newHtml);
            mergeImages(newHtml,keywordsList);

                keywordsList.forEach(keyword -> {
                    DocumentWordEntry documentWordElement = getDocumentWordElement(keyword.getStem(), keyword.getFrequency(), newHtml, keyword.getFirstStatement(), keyword.getImgSrcList(), newHtml.getTitle(), newHtml.getPageRank(), newHtml.getWordsCount());
                    IndexItem newIndexEntry = new IndexItem(keyword.getStem(), documentWordElement);

                    synchronized (dataBase) {
                        if(newIndexEntry.getWord() == null){
                            System.out.println("Null");
                        }else{
                            dataBase.updateIndex(newIndexEntry);
                            //dataBase.setIndexed(ID);
                            dataBase.updateWordDocsCount(newIndexEntry.getWord());

                        }
                    }
                }
                );
            }
    }

    public  HTMLPage createHtmlPage(String url,double pageRank)  {
        HTMLPage newHtml = null;
        try {
            newHtml = new HTMLPage(url,pageRank);
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
        for (Keyword keyword : keywordsList) {
            for (Keyword value : imageKeywordsList) {
                if (keyword.getStem().equals(value.getStem())) {
                    keyword.addImgSrc(value.getImgSrc(0));
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

    public  DocumentWordEntry getDocumentWordElement(String word,int frequency, HTMLPage htmlPage, String firstStatement, List<String> imageSrcList, String title, double pageRank, int wordsCount) {

        List<Keyword> keywordsListTitle = null;

        try {
            keywordsListTitle = KeywordsExtractor.getKeywordsList(htmlPage.getTitle());
        } catch (IOException e) {
            System.out.println("Failed extracting words from html title");
            e.printStackTrace();
            exit(0);
        }


        return new DocumentWordEntry(htmlPage.getUrl(), frequency, inTitle(word, keywordsListTitle), firstStatement, imageSrcList, title, pageRank, wordsCount);
    }

    public  boolean inTitle(String word, List<Keyword> keywordsList){

        for (Keyword keyword : keywordsList) {
            if (keyword.getStem().equals(word)) {
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
