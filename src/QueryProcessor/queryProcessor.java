package QueryProcessor; //imports
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
            MongoCollection<Document> collection = Yara.getCollection("index_table_13k");

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
    public ArrayList<QueryDocumentWordEntry> PhraseSearch(String[] finalStemmedArray, int length, MongoCollection<Document> collection) throws IOException {
        return null;
    }

    //4. nonPhraseSearch
    public ArrayList<QueryDocumentWordEntry> nonPhraseSearch(String[] finalStemmedArray, int length, MongoCollection<Document> collection) throws IOException {
        ArrayList<QueryDocumentWordEntry> toRanker = new ArrayList<QueryDocumentWordEntry>();
        ArrayList<QueryDocumentWordEntry> allResults = new ArrayList<QueryDocumentWordEntry>();
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



                allResults.add(i, new QueryDocumentWordEntry(pageRank, docUrl,docTitle,wordFrequency,isInTitle,
                        isInHeader,isInUrl, firstStatement,imgSrc,word,docLength,tf, idf,urlLength));
            }
        }
        for(int i = 0 ; i < allResults.size();i++ ){
            for (int j = i+1; j<allResults.size();j++){

                if(allResults.get(i).getUrl().equals(allResults.get(j).getUrl())){
                    allResults.get(i).setTf(allResults.get(i).getTf()+allResults.get(j).getTf());
                    allResults.get(i).setIdf(allResults.get(i).getIdf()+allResults.get(j).getIdf());
                    allResults.get(i).setMatches(allResults.get(i).getMatches()+5);
                    if(allResults.get(j).isInHeader() == true)
                    {
                        allResults.get(i).setWordInHeader(allResults.get(i).getWordInHeader() + 1);
                    }
                    if(allResults.get(j).isInTitle() == true)
                    {
                        allResults.get(i).setWordInTitle(allResults.get(i).getWordInTitle() + 2);
                    }
                    if(allResults.get(j).isInUrl() == true)
                    {
                        allResults.get(i).setWordInUrl(allResults.get(i).getWordInUrl() + 3);
                    }

                    allResults.remove(j);
                }

            }

        }


        return allResults;
    }



} //end class



