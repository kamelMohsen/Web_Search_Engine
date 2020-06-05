import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.rometools.rome.feed.atom.Link;
import org.bson.Document;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@SuppressWarnings("ALL")
@WebServlet("/Interface")
public class Interface extends HttpServlet {
    //Data members
    public String userInput = "messi";
    public String radio = "check";
    public String region = "";
    static private MongoDatabase Yara;
    private static MongoClient mongoClient;
    public String Path = "F:/Tech/CUFE_CHS/Spring 2020/Advance Programming Techniques/Project/Web_Search_Engine/Server/apache-tomcat-8.5.55/webapps/ROOT";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long beforeTime = System.currentTimeMillis();
        PerformanceAnalyzer crawlerPerformance = new PerformanceAnalyzer(3);
        //0. Retrieve data
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        Yara = mongoClient.getDatabase("indexDB");
        MongoCollection<Document> collection = Yara.getCollection("index_table");

        //1.To extract the text entered by the user
        userInput = request.getParameter("textbox");
        radio = request.getParameter("SearchType");
        region = request.getParameter("country");

        //2. class constructors
        queryProcessor qp = new queryProcessor();
        Trends trendPoster = new Trends();

        //3. Declarations
        ArrayList<DocumentWordEntry> docs = null;


        //4.Stem the input query and put in a list
        if (userInput != null) {

            if (radio.equals("ImagesSearch") || radio.equals("Search")) {
                if (!region.equals("Global")) {
                    trendPoster.postQuery(userInput, region.toLowerCase());
                }

                KeywordsExtractor keywordsExtractor = new KeywordsExtractor();
                List<Keyword> keywordList = keywordsExtractor.getKeywordsList(userInput.replaceAll("\"+",""));


                String[] finalStemmedArray = new String[keywordList.size()];  //Construct a string to put in it the stemmed words

                for (int i = 0; i < keywordList.size(); i++) {
                    finalStemmedArray[i] = keywordList.get(i).getStem();     //add each stem inside single quotes and concatinate all
                }

                //5. check  phrase or non phrase then process accordingly (Send data to query processor)
                if (radio != null && radio.equals("ImagesSearch")) {
                    docs = qp.imageSearch(finalStemmedArray, keywordList.size(), collection,region);
                } else if (qp.phraseOrNonphrase(userInput) == 1) {
                    docs = qp.nonPhraseSearch(finalStemmedArray, keywordList.size(), collection,region);
                } else if (qp.phraseOrNonphrase(userInput) == 0) {
                    docs = qp.PhraseSearch(finalStemmedArray, keywordList.size(), collection,region); //Fills array List toRanker
                }
                for(DocumentWordEntry doc : docs) {
                    System.out.println(doc.getTotalRank());
                }
                //6. Call the ranker ; the toRanker arrayList should be filled by this stage
                long beforeRankTime = System.currentTimeMillis();
                RelevanceRanker rr = new RelevanceRanker();
                rr.calculateRelevanceRank(docs);
                try {
                    crawlerPerformance.addToFile("Time to relevance rank "+ docs.size() + " documents for a 2 words query is :" +
                            (System.currentTimeMillis() - beforeRankTime) + " milliseconds.");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //7.  print the results on screen
                //-set page content
                response.setContentType("text/html");
                if (radio.equals("Search")) {
                    queryProcessor.createJSFile(docs, Path);
                    try {
                        crawlerPerformance.addToFile("Total latency to return search results " +
                                (System.currentTimeMillis() - beforeTime)+ " milliseconds.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    response.sendRedirect("http://localhost:8080/result.html");
                } else {

                    Set<String> images = new HashSet<String>();

                    for (int i = 0; i < docs.size(); i++) {
                        for (int j = 0; j < docs.get(i).getImgSrc().size(); j++) {


                            images.add(docs.get(i).getImgSrc().get(j));


                        }
                    }

                    List<String> imagesList = new LinkedList<>();
                    for (String s : images) {
                        if (s.length() > 10) {
                            imagesList.add(s);

                        }
                    }
                    try {
                        crawlerPerformance.addToFile("Total latency to return image results " +
                                (System.currentTimeMillis() - beforeTime) + " milliseconds.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    queryProcessor.createImagesJSFile(imagesList, Path);
                    response.sendRedirect("http://localhost:8080/images.html");
                }
            }
            if (radio.equals("TrendsSearch")) {

                List<String> names = new LinkedList<>();
                Vector numbers = new Vector();

                if (region.equals("Global")) {
                    trendPoster.getTrendsWorldWide(names, numbers);
                } else {
                    trendPoster.getTrendsInRegion(names, numbers, region.toLowerCase());
                }
                queryProcessor.createTrendsJSFile(names, numbers, region, Path);
                try {
                    crawlerPerformance.addToFile("Total latency to return trends " +
                            (System.currentTimeMillis() - beforeTime) + " milliseconds.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("http://localhost:8080/trends.html");
            }
        }

    }
}
