import java.util.*;


public class Crawler implements Runnable{

    private int maxPages = 50;
    private Set<String> Visited;
    private List<String> queue;
    Map<String,Vector<String>> forbiddenList;
    Map<String,Vector<String>> allowedList;
    int id;
    Database DB;
    int count = 0;
    Date recrawlTime;
    int turn;


    public Crawler(Database DB,Set<String> Visited ,List<String> queue,Map<String,Vector<String>> forbiddenList,Map<String,Vector<String>> allowedList, int id) {
        this.Visited = Visited;
        this.queue = queue;
        this.forbiddenList = forbiddenList;
        this.allowedList = allowedList;
        this.id = id;
        this.DB = DB;
        recrawlTime = new Date();
        turn = 0;
    }
    public Crawler(Database DB ,List<String> queue, int id) {
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
                        String nextUrl = queue.remove(0);
                        currentUrl = Visited.contains(nextUrl) ? null : nextUrl;
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

        Database DB = new Database();
        DB.getQueue(queue);
        DB.getVisited(Visited);
        if (Visited.size() == 0 && queue.size() == 0) {
            queue.add("https://www.bbc.com/");
        }
       for(int i = 0 ;i< 8; i++) {
           t1 = new Thread(new Crawler(DB,Visited, queue,forbiddenList,allowedList, i));
           String name = Integer.toString(i);
           t1.setName(name);
           t1.start();
       }
//        Date date = new Date();
//        Date date2 = new Date();//= new Date();
//        DB.getDate(date2);
//        System.out.println(date2);
//        List<String> queue1 = new LinkedList<String>();

        //date2.setHours(date2.getHours()+4);
//        date2.setMinutes(date2.getMinutes()+1);
//        while (!date2.equals(date)){
//            date = new Date();
//            System.out.println("the time has come");
//        }
//        // seedlist from txt file
        //
    }

    @Override
    public void run() {
        crawl();


        recrawl();
    }
}
