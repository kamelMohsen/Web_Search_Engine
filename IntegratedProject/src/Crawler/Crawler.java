package Crawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@SuppressWarnings("ALL")
public class Crawler implements Runnable{

    private int maxPages = 20;
    private Set<String> Visited;
    private List<String> queue;
    Map<String,Vector<String>> forbiddenList;
    Map<String,Vector<String>> allowedList;
    int id;
    CrawlerDatabaseManager DB;
    int count = 0;
    Date recrawlTime;
    int turn;


    public Crawler(CrawlerDatabaseManager DB, Set<String> Visited , List<String> queue, Map<String,Vector<String>> forbiddenList, Map<String,Vector<String>> allowedList, int id) {
        this.Visited = Visited;
        this.queue = queue;
        this.forbiddenList = forbiddenList;
        this.allowedList = allowedList;
        this.id = id;
        this.DB = DB;
        recrawlTime = new Date();
        turn = 0;
    }
    public Crawler(CrawlerDatabaseManager DB , List<String> queue, int id) {
        this.queue = queue;
        this.id = id;
        this.DB = DB;
    }

    public void recrawl() {
        String currentUrl = null;

        while (true) {
            if (Thread.currentThread().getName().equals("0")) {
                queue.clear();
                if(turn == 0) {
                    DB.getVisited(queue);
                    turn = 1;
                }else {
                    DB.getImportant(queue);
                    turn = 0;
                }
                DB.getDate(recrawlTime);
            }
            while((new Date().after (recrawlTime)));
            while (true ) {  // recrawl every 4 hours

                synchronized (queue) {
                    if (queue.isEmpty()) {
                        Date time2 = new Date();
                        DB.updateDate(time2);
                        break;
                    }
                }
                currentUrl = null;
                synchronized (queue) {
                    if (!queue.isEmpty()) {
                        currentUrl = queue.remove(0);
                    }
                }
                if (currentUrl != null) {
                    Scraper scraper = new Scraper();
                    scraper.Rescrape(DB, currentUrl);
                }
            }

        }
    }


    public void crawl() {
        String currentUrl = null;

        while( true ) {
            synchronized (Visited){
                if(Visited.size() > maxPages)
                    break;
            }
            currentUrl = null;
            synchronized (queue) {
                if(!queue.isEmpty()) {
                    synchronized ( Visited) {
                        try {
                            Collections.shuffle(queue);
                            String nextUrl = queue.remove(0);
                            currentUrl = Visited.contains(nextUrl) ? null : nextUrl;

                        }catch (Exception ignored){

                        }
                        if(currentUrl != null) {
                            Visited.add(currentUrl);
                        }
                    }
                }
            }
            if (currentUrl != null) {
                Scraper scraper = new Scraper();
                scraper.scrape(DB,currentUrl,forbiddenList,allowedList);
                queue.addAll(scraper.getLinks());
            }
        }
        Date time = new Date();
        DB.updateDate(time);
    }
    public static void main(String[] args) throws InterruptedException {
        Set<String> Visited = new HashSet<String>();
        List<String> queue = new LinkedList<String>();
        Map<String,Vector<String>> forbiddenList=new HashMap<String, Vector<String>>();
        Map<String,Vector<String>> allowedList=new HashMap<String, Vector<String>>();

        Thread t1 = null;

        CrawlerDatabaseManager DB = new CrawlerDatabaseManager();
        DB.getQueue(queue);
        DB.getVisited(Visited);
        if (Visited.size() == 0 && queue.size() == 0) {

            readSeedList(queue);

        }
        for(int i = 0 ;i< 8; i++) {
            t1 = new Thread(new Crawler(DB,Visited, queue,forbiddenList,allowedList, i));
            String name = Integer.toString(i);
            t1.setName(name);
            t1.start();
        }

    }



    public static void readSeedList(List<String> queue){
        try {
            File myObj = new File("/home/ahmad/Desktop/APT project/Integrated/src/seed_list.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                queue.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading seed list.");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        crawl();

        recrawl();

    }
}