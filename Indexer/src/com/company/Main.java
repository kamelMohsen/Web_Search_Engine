package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        DataBase dataBase = new DataBase();
        List<Link> linksList;
        linksList = new LinkedList<>();
        dataBase.getLinks(linksList);
        long startTime = System.nanoTime();
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

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Total time indexing : " + totalTime / 1000000000);

        threadsList.clear();
        linksList.clear();
        dataBase.getLinks(linksList);

        startTime = System.nanoTime();

        Normalizer normalizer = new Normalizer(dataBase,linksList,linksList.size());
        normalizer.startNormalizing();

        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Total time normalizing : " + totalTime / 1000000000);

    }
}
