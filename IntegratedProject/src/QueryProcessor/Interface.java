package QueryProcessor;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("ALL")
@WebServlet("/Interface")
public class Interface extends HttpServlet {
    //Data members
    public String userInput = "messi";
    public String checkBox = "check";
    static private MongoDatabase Yara;
    private static MongoClient mongoClient;
    public  String Path = "~/Web_Search_Engine/IntegratedProject/Server/apache-tomcat-8.5.55/webapps/ROOT";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException
    {
        //0. Retrieve data
        mongoClient = new MongoClient("localhost", 27017);
        Yara = mongoClient.getDatabase("indexDB");
        MongoCollection<Document> collection = Yara.getCollection("index_table_13k");

        //1.To extract the text entered by the user
        userInput = request.getParameter("textbox");
        checkBox = request.getParameter("checkbox");

        //2. class constructors
        queryProcessor qp = new queryProcessor();


        //3. Declarations
        ArrayList<QueryDocumentWordEntry> docs = null;


        //4.Stem the input query and put in a list
        if(userInput!=null) {

            KeywordsExtractor keywordsExtractor = new KeywordsExtractor();
            List<Keyword> keywordList = keywordsExtractor.getKeywordsList(userInput);


            String[] finalStemmedArray = new String[keywordList.size()];  //Construct a string to put in it the stemmed words

            for (int i = 0; i < keywordList.size(); i++) {
                finalStemmedArray[i] = keywordList.get(i).getStem();     //add each stem inside single quotes and concatinate all
            }

            //5. check  phrase or non phrase then process accordingly (Send data to query processor)
            if (checkBox != null && checkBox.equals("ImageSearch")){
                docs = qp.imageSearch(finalStemmedArray, keywordList.size(), collection);
            }
            else if (qp.phraseOrNonphrase(userInput) == 1) {
                docs = qp.nonPhraseSearch(finalStemmedArray, keywordList.size(), collection);
            }
            else if (qp.phraseOrNonphrase(userInput) == 0) {
                docs = qp.PhraseSearch(finalStemmedArray, keywordList.size(), collection); //Fills array List toRanker
            }

            //6. Call the ranker ; the toRanker arrayList should be filled by this stage
            RelevanceRanker rr = new RelevanceRanker();
            rr.calculateRelevanceRank(docs);

        }

        //7.  print the results on screen
        //-set page content
        response.setContentType("text/html");
        if(checkBox == null) {
            queryProcessor.createJSFile(docs, Path);
            response.sendRedirect("http://localhost:8080/result.html");
        }
        else {

            Set<String> images = new HashSet<String>();

            for (int i = 0; i < docs.size(); i++) {
                for (int j = 0; j < docs.get(i).getImgSrc().size(); j++) {


                    images.add(docs.get(i).getImgSrc().get(j));


                }
            }
            String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
            docType = docType +
                    "<html>\n" +
                    "<head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head>\n";

            for (String s : images) {

                docType += "<img src=\"" + s + "\" style=\"width:15%\" style=\"height:15%\">";


            }

            docType += "</body></html>";
            response.getWriter().print(docType);
        }
    }
}
