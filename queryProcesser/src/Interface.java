import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import opennlp.tools.stemmer.PorterStemmer;
import org.bson.Document;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Interface extends HttpServlet {
    //Data members
    public String userInput = "messi";
    static private MongoDatabase Yara;
    static private DBCollection firstTable;
    private static MongoClient mongoClient;
    static PorterStemmer porterStemmer = new PorterStemmer();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException
    {
        //0. Retrieve data
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        Yara = mongoClient.getDatabase("indexDB");
        MongoCollection<Document> collection = Yara.getCollection("wikipedia_50_pages_try_1");

        //1.To extract the text entered by the user
        userInput = request.getParameter("textbox");

        //2. class constructors
        queryProcessor qp = new queryProcessor();
        Stemming CI = new Stemming();

        //3. Declarations
        ArrayList<DocumentWordEntry> docs = null;

        //4.Stem the input query and put in a list
        List<String> noStoppingWordsList = new ArrayList<>(); // Construct an List to put in it the words without the stopping words
        noStoppingWordsList = CI.remove(userInput); //Fill this list
        int length = noStoppingWordsList.size();
        int count = 0;
        String [] finalStemmedArray = new String[length];  //Construct a string to put in it the stemmed words
        while(count< length)
        {
            for (String ss : noStoppingWordsList) //Loop on the list with no stop words
            {
                finalStemmedArray[count] =porterStemmer.stem(ss);     //add each stem inside single quotes and concatinate all
                count++;
            }
        }

        //5. check  phrase or non phrase then process accordingly (Send data to query processor)
        if(qp.phraseOrNonphrase(userInput) == 1)
            docs = qp.nonPhraseSearch(finalStemmedArray,length, collection); //Fills array list toRanker
        if(qp.phraseOrNonphrase(userInput)== 0)
            docs = qp.PhraseSearch(finalStemmedArray,length,collection); //Fills array List toRanker


        //6. Call the ranker ; the toRanker arrayList should be filled by this stage
        RelevanceRanker rr = new RelevanceRanker();
        System.out.println("Before Relevance Ranker: ");
        for (DocumentWordEntry doc: docs){
            System.out.println(doc.getFirstStatement());
            System.out.println(doc.getTotalRank());
        }
        rr.calculateRelevanceRank(docs);
        System.out.println("After Relevance Ranker: ");
        for (DocumentWordEntry doc: docs){
            System.out.println(doc.getFirstStatement());
            System.out.println(doc.getTotalRank());
        }

        //7.  print the results on screen

        //-set page content
        response.setContentType("text/html");
        //-Design the page
        PrintWriter out = response.getWriter();
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" );
        for(int i=0;i<10;i++)
        {
            out.println(
                    "<b><a href="+ docs.get(i).getUrl()+">" +"<font size=\"5\">"+ docs.get(i).getTitle()+"</font>"+"</a></b><br>"+"<font color=\"green\">\n"+ docs.get(i).getUrl()+"</font><br>\n");
            out.println(docs.get(i).getFirstStatement()+"<br>");

        }
        out.println( "</body></html>");
        //- Dispaly page's content
        //response.getWriter().print(page);
    }

}