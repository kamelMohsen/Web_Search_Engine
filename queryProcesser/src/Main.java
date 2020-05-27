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
import java.util.List;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import org.bson.Document;
import com.mongodb.DB;
import  com.mongodb.DBCursor;

public class Main {
    //Data members
    static private MongoDatabase Yara;
    static private DBCollection firstTable;
    private static MongoClient mongoClient;
    static PorterStemmer porterStemmer = new PorterStemmer();

    public static void main(String[] args) throws IOException {

        //0. Declarations
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        Yara = mongoClient.getDatabase("Yara");
        MongoCollection<Document> collection = Yara.getCollection("firstTable");

        //1. class constructors
        queryProcessor qp = new queryProcessor();
        Stemming CI = new Stemming();

        //2. Retrieve data from the collection(table) and put it in vector of documents


        // 3. Receive the userInput
        //String s = new Interface().userInput;
        String s = "done ball play";
        //4.Stem the input query and put in a list
        List<String> noStoppingWordsList = new ArrayList<>(); // Construct an List to put in it the words without the stopping words
        noStoppingWordsList = CI.remove(s); //Fill this list
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

        //5. and test the check of phrase and non phrase
        if(qp.phraseOrNonphrase(s) == 1)
            qp.nonPhraseSearch(finalStemmedArray,length, collection); //Fills array list toRanker
        if(qp.phraseOrNonphrase(s)== 0)
            qp.PhraseSearch(finalStemmedArray,length,collection); //Fills array List toRanker

        //6. Call the ranker ; the toRanker arrayList should be filled by this stage

    }
}
