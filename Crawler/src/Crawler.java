import java.util.*;


public class Crawler implements Runnable{

    private int maxPages = 550;
    private Set<String> Visited;
    private List<String> queue;
    Map<String,Vector<String>> forbiddenList;
    Map<String,Vector<String>> allowedList;
    int id;
    Database DB;
    int count = 0;

    public Crawler(Database DB,Set<String> Visited ,List<String> queue,Map<String,Vector<String>> forbiddenList,Map<String,Vector<String>> allowedList, int id) {
        this.Visited = Visited;
        this.queue = queue;
        this.forbiddenList = forbiddenList;
        this.allowedList = allowedList;
        this.id = id;
        this.DB = DB;
    }


    public void crawl( ) {
        String currentUrl = null;

        while( Visited.size() < maxPages ) {
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
    }
    public static void main(String[] args) throws InterruptedException {
       Set<String> Visited = new HashSet<String>();
       List<String> queue = new LinkedList<String>();
        Map<String,Vector<String>> forbiddenList=new HashMap<String, Vector<String>>();
        Map<String,Vector<String>> allowedList=new HashMap<String, Vector<String>>();
       queue.add("https://en.wikipedia.org/");
       Thread t1 = null;

        Database DB = new Database();
        DB.getQueue(queue);
        DB.getVisited(Visited);
       for(int i = 0 ;i< 7; i++) {
           t1 = new Thread(new Crawler(DB,Visited, queue,forbiddenList,allowedList, i));
           t1.start();
       }

        // seedlist from txt file
        //
    }

    @Override
    public void run() {
        crawl();
    }
}
