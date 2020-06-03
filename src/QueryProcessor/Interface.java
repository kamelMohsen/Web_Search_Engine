package QueryProcessor;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Interface extends HttpServlet {
    //Data members
    public String userInput = "messi";
    static private MongoDatabase Yara;
    private static MongoClient mongoClient;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException
    {
        //0. Retrieve data
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        Yara = mongoClient.getDatabase("indexDB");
        MongoCollection<Document> collection = Yara.getCollection("index_table_13k");

        //1.To extract the text entered by the user
        userInput = request.getParameter("textbox");

        //2. class constructors
        queryProcessor qp = new queryProcessor();


        //3. Declarations
        ArrayList<QueryDocumentWordEntry> docs = null;


        //4.Stem the input query and put in a list
        KeywordsExtractor keywordsExtractor = new KeywordsExtractor();
        List<Keyword> keywordList = keywordsExtractor.getKeywordsList(userInput);


        String [] finalStemmedArray = new String[keywordList.size()];  //Construct a string to put in it the stemmed words

        for (int i = 0 ; i<keywordList.size();i++){
            finalStemmedArray[i] = keywordList.get(i).getStem();     //add each stem inside single quotes and concatinate all
        }

        //5. check  phrase or non phrase then process accordingly (Send data to query processor)
        if(qp.phraseOrNonphrase(userInput) == 1)
            docs = qp.nonPhraseSearch(finalStemmedArray,keywordList.size(), collection); //Fills array list toRanker
        if(qp.phraseOrNonphrase(userInput)== 0)
            docs = qp.PhraseSearch(finalStemmedArray,keywordList.size(),collection); //Fills array List toRanker


        //6. Call the ranker ; the toRanker arrayList should be filled by this stage
        RelevanceRanker rr = new RelevanceRanker();
        System.out.println("Before Relevance Ranker: ");
        for (QueryDocumentWordEntry doc: docs){
            System.out.println(doc.getTotalRank());
        }
        rr.calculateRelevanceRank(docs);
        System.out.println("After Relevance Ranker: ");
        for (QueryDocumentWordEntry doc: docs){
            System.out.println(doc.getTotalRank());
        }

        //7.  print the results on screen

        //-set page content
        response.setContentType("text/html");
        //-Design the page

        //PrintWriter out = response.getWriter();
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        docType = docType +
                "<html>\n" +
                "<head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" ;
        for(int i=0;i<docs.size();i++)
        {

                    docType += "<b><a href="+ docs.get(i).getUrl()+">" +"<font size=\"5\">"+ docs.get(i).getTitle()+"</font>"+"</a></b><br>"+"<font color=\"green\">\n"+ docs.get(i).getUrl()+"</font><br>\n";
            docType += docs.get(i).getFirstStatement()+"<br>";

        }
        docType +="</body></html>";
        //- Dispaly page's content
        response.getWriter().print(docType);
    }

}