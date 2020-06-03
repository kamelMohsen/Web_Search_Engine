package Indexer;


import java.io.IOException;
import java.util.List;

import static java.lang.System.exit;

public class Indexer  implements Runnable{

    IndexerDataBaseManager indexerDataBaseManager;
    final List<Link> linksList;
    String url;
    String ID;
    double pageRank;
    public Indexer(IndexerDataBaseManager indexerDataBaseManager, List<Link> linksList) {

        this.indexerDataBaseManager = indexerDataBaseManager;
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
            index(this.ID,this.url,this.pageRank , indexerDataBaseManager);
        }


    }
    public  void index(String ID, String url,double pageRank, IndexerDataBaseManager indexerDataBaseManager){

        //Create HTMLPage object
            HTMLPage newHtml = createHtmlPage(url,pageRank);
            if(newHtml.getParsedHtml() != null)
            {
            List<Keyword> keywordsList = findKeywords(newHtml);
            mergeImages(newHtml,keywordsList);

                keywordsList.forEach(keyword -> {
                    DocumentWordEntry documentWordElement = new DocumentWordEntry(newHtml.getUrl(), keyword.getFrequency(), keyword.isInTitle(), keyword.getFirstStatement(), keyword.getImgSrcList(), newHtml.getTitle(), newHtml.getPageRank(), newHtml.getWordsCount(),keyword.isInHeader(),keyword.isInUrl());
                    IndexItem newIndexEntry = new IndexItem(keyword.getStem(), documentWordElement);

                    synchronized (indexerDataBaseManager) {
                        if(newIndexEntry.getWord() == null){
                            System.out.println("Null");
                        }else{
                            indexerDataBaseManager.updateIndex(newIndexEntry);
                            //dataBase.setIndexed(ID);
                            indexerDataBaseManager.updateWordDocsCount(newIndexEntry.getWord());

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
            keywordsList = KeywordsExtractor.getKeywordsList(htmlPage.getHtmlElements());
        } catch (IOException e) {
            System.out.println("Failed extracting words from html page");
            e.printStackTrace();
            exit(0);
        }

        return keywordsList;
    }



    @Override
    public void run() {
            startIndexing();
    }
}
