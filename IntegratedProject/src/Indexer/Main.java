package Indexer;

import java.util.LinkedList;
import java.util.List;
@SuppressWarnings("All")
public class Main {

    public static void main(String[] args) throws InterruptedException {
        IndexerDataBaseManager indexerDataBaseManager = new IndexerDataBaseManager();
        List<Link> linksList;
        linksList = new LinkedList<>();
        indexerDataBaseManager.getLinks(linksList);
        long startTime = System.nanoTime();
        Thread t1;
        List<Thread> threadsList = new LinkedList<>();
        for(int i = 0; i < 7; i++) {
            t1 = new Thread(new Indexer(indexerDataBaseManager,linksList));
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
        indexerDataBaseManager.getLinks(linksList);

        startTime = System.nanoTime();

        Normalizer normalizer = new Normalizer(indexerDataBaseManager,linksList,linksList.size());
        normalizer.startNormalizing();

        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Total time normalizing : " + totalTime / 1000000000);

    }
}
