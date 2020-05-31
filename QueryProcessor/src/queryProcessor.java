 //imports
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import opennlp.tools.stemmer.PorterStemmer;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import org.bson.Document;
import com.mongodb.DB;
import  com.mongodb.DBCursor;

 @SuppressWarnings("ALL")
public class queryProcessor {
    //Data Members
    static PorterStemmer porterStemmer = new PorterStemmer();
    static public MongoDatabase Yara;
    static public DBCollection collection;
    public MongoClient mongoClient;


    //1.Constructor
    public queryProcessor() {
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            Yara = mongoClient.getDatabase("indexDB");
            //2. Retrieve data from the collection(table) and put it in vector of documents
            MongoCollection<Document> collection = Yara.getCollection("index_table");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //2.check if there is quotes or not , returns array of results
    public static int phraseOrNonphrase(String string) throws IOException {
        if (string.startsWith("\"")) {
            //phrase search
            System.out.println("yes it is a phrase");
            String phrase = string.replaceAll("\"", "");
            return 0;
        } else {
            //non phrase search
            System.out.println("Not a phrase");
            return 1;
        }
    }

    //3. phrase search
    public ArrayList<DocumentWordEntry> PhraseSearch(String[] finalStemmedArray, int length, MongoCollection<Document> collection) throws IOException {
        return null;
    }

    //4. nonPhraseSearch
    public ArrayList<DocumentWordEntry> nonPhraseSearch(String[] finalStemmedArray, int length, MongoCollection<Document> collection) throws IOException {
        ArrayList<DocumentWordEntry> toRanker = new ArrayList<DocumentWordEntry>();
        for (int i = 0; i < length; i++) {
            FindIterable<Document> documents = (FindIterable<Document>) collection.find(Filters.eq("word", finalStemmedArray[i]));
            for (Document document : documents) {


                double pageRank = (double) document.get("page_rank");
                String docUrl = (String) document.get("doc_url");
                String docTitle = (String) document.get("title");
                int  wordFrequency = (int) document.get("word_frequency");
                boolean isInTitle = (boolean) document.get("is_in_title");
                boolean isInHeader = (boolean) document.get("is_in_header");
                boolean isInUrl = (boolean) document.get("is_in_url");
                String firstStatement = (String) document.get("first_statement");
                List<String> imgSrc = new LinkedList<String>();//(ArrayList) document.get("img_srcs");
                String word = (String) document.get("word");
                int  docLength = (int) document.get("total_words_count");
                double tf = (double) document.get("tf");
                double idf = (double) document.get("idf");
                double urlLength = (double) document.get("url_length");
                toRanker.add(i, new DocumentWordEntry(pageRank, docUrl,docTitle,wordFrequency,isInTitle,
                        isInHeader,isInUrl, firstStatement,imgSrc,word,docLength,tf, idf,urlLength));

            }
        }
        return toRanker;
    }



} //end class



