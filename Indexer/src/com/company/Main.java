package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Map<String,LinkedList<IndexItem>> bigMap = new HashMap<>();
        DataBase dataBase = new DataBase();
        List<Link> linksList;
        linksList = new LinkedList<>();
        dataBase.getLinks(linksList);
        System.out.println(linksList.size());
        long startTime = System.nanoTime();
        Thread t1;
        List<Thread> threadsList = new LinkedList<>();
        for(int i = 0; i < 7; i++) {
            t1 = new Thread(new Indexer(dataBase,linksList,bigMap));
            threadsList.add(t1);
            t1.start();
        }

        for (Thread thread : threadsList) {
            thread.join();
        }
        for (String key: bigMap.keySet()) {
            dataBase.updateIndex(bigMap.get(key));
        }


        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Total time is : " + totalTime / 1000000000);
    }
}
