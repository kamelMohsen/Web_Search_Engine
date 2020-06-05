package com.company;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
@SuppressWarnings("All")
public class Main {

    public static void main(String[] args) throws InterruptedException {
        DataBase dataBase = new DataBase();
        List<Link> linksList;
        linksList = new LinkedList<>();
        dataBase.getLinks(linksList);
        long beforeTime = System.currentTimeMillis();
        PerformanceAnalyzer crawlerPerformance = new PerformanceAnalyzer(2);
        Thread t1;
        List<Thread> threadsList = new LinkedList<>();
        for(int i = 0; i < 7; i++) {
            t1 = new Thread(new Indexer(dataBase,linksList));
            threadsList.add(t1);
            t1.start();
        }

        for (Thread thread : threadsList) {
            thread.join();
        }



        threadsList.clear();
        linksList.clear();
        dataBase.getLinks(linksList);


        Normalizer normalizer = new Normalizer(dataBase,linksList,linksList.size());
        normalizer.startNormalizing();

        try {
            crawlerPerformance.addToFile("Time to index and normalize 100 documents is " +
                    (System.currentTimeMillis() - beforeTime)/1000 + " seconds.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
