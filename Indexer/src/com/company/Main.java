package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        DataBase dataBase = new DataBase();
        List<Link> linksList = new LinkedList<Link>();
        List<Thread> threadsList = new LinkedList<Thread>();
        dataBase.getLinks(linksList);
        System.out.println(linksList.size());
        long startTime = System.nanoTime();
        Thread t1 = null;
        for(int i = 0 ;i < 7; i++) {
            t1 = new Thread(new Indexer(dataBase,linksList));
            threadsList.add(t1);
            t1.start();

        }

        for(int i = 0 ; i < threadsList.size() ; i++)
        {
            threadsList.get(i).join();
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Total time is : " + totalTime / 1000000000);
    }
}
