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
import java.util.List;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import org.bson.Document;
import com.mongodb.DB;
import  com.mongodb.DBCursor;


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
            Yara = mongoClient.getDatabase("Yara");
            //2. Retrieve data from the collection(table) and put it in vector of documents
            MongoCollection<Document> collection = Yara.getCollection("firstTable");
            System.out.println("Yaryora shatoraa");
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

        ArrayList<DocumentWordEntry> toRanker = new ArrayList<DocumentWordEntry>(); //the filled
        ArrayList<DocumentWordEntry> phraseSearchToRanker = new ArrayList<DocumentWordEntry>(); //the arraylist that will be sent to the ranker
        for (int i = 0; i < finalStemmedArray.length; i++) {
            FindIterable<Document> documents = (FindIterable<Document>) collection.find(Filters.eq("word", finalStemmedArray[i]));
            for (Document document : documents) {
                //System.out.println(document);
                ArrayList<Document> allWebPages = (ArrayList<Document>) document.get("documents_" + document.get("word"));//has all info need to be parsed
                for (Document obj : allWebPages) {
                    System.out.println(obj);
                    String a = (String) obj.get("doc_id");
                    int b = (int) obj.get("word_frequency");
                    boolean c = (boolean) obj.get("is_in_title");
                    String d = (String) obj.get("first_statement");
                    String e = (String) obj.get("img_srcs");
                    String f = document.getString("word");
                    //    System.out.println(f);
                    toRanker.add(i, new DocumentWordEntry(a, b, c, d, e, f));
                }
            }
        }
        //when we reach here we have a ready array list then the coming part is adjustments for phrase search

        int count = 0;
        int y =0 ; //index for new arraylist
        int frequency = 0 ;
        String allStatements = "" ;
        String name = "";

        //First, get id we want to search for and find the length of the all the possible documents selected
        String id = toRanker.get(toRanker.size()-1).getDocID();
        int countList = toRanker.size();

        //Second, Make a copy to keep track of all documents and make sure that we searched for all documents
        ArrayList<DocumentWordEntry> copy = (ArrayList<DocumentWordEntry>) toRanker.clone(); //just a copy to keep track , we need to make it with same type and that was a mistake here

        if(!copy.isEmpty()) { // Make sure the copy array is not empty

            //Target is to get all docs with this id (one id) + 3 different words
            for (int i = 0; i < finalStemmedArray.length; i++) { //for loop on all the words in the input search query
                for (int j = 0; j < countList; j++) { //Then a for loop on all the possible web pages figured out in step one

                    if (id == toRanker.get(j).getDocID() && toRanker.get(j).getName().equals(finalStemmedArray[i])) { //if same id we are searching for and same word in the search query add one pint to count
                        count++;
                        frequency = frequency + toRanker.get(j).getFrequency(); // add all the frequencies
                        allStatements = allStatements + toRanker.get(j).getFirstStatement(); //All this is to extract the data
                        name = name + toRanker.get(j).getName();
                        continue;
                    }

                    if(copy.size() >1)
                        copy.remove(j); //we should remove anyway the id that we searched for , bec stopping condition is to stop when the arraylist is finished

                    if (count == finalStemmedArray.length) { //if this condition is achieved then the doc id repeated for the all the words
                        phraseSearchToRanker.add(y, new DocumentWordEntry(id, frequency, true, allStatements, toRanker.get(j).getImgSrc(), name)); //Fill the array list that will be sent to the ranker
                        count = 0 ; //Then clear all the that to fill from the begining
                        frequency = 0;
                        allStatements ="";
                        name = "" ;
                    }

                } //close inner for

            } //close outer for
        }//close the first if condition
        return  phraseSearchToRanker ;
    }

    //4. nonPhraseSearch
    public ArrayList<DocumentWordEntry> nonPhraseSearch(String[] finalStemmedArray, int length, MongoCollection<Document> collection) throws IOException {
        ArrayList<DocumentWordEntry> toRanker = new ArrayList<DocumentWordEntry>();
        for (int i = 0; i < length; i++) {
            //  List<Document> documents = (List<Document>) collection.find(Filters.eq("nickName", "Saraaaa")).into(new ArrayList<Document>());
            FindIterable<Document> documents = (FindIterable<Document>) collection.find(Filters.eq("word", finalStemmedArray[i]));
            //4. Iterate and print to check

            for (Document document : documents) {
                System.out.println(document);
                ArrayList<Document> allWebPages = (ArrayList<Document>) document.get("documents_" + document.get("word"));//has all info need to be parsed
                for (Document obj : allWebPages) {
                    String a = (String) obj.get("doc_id");
                    int b = (int) obj.get("word_frequency");
                    boolean c = (boolean) obj.get("is_in_title");
                    String d = (String) obj.get("first_statement");
                    String e = (String) obj.get("img_srcs");
                    String f = document.getString("word");
                    System.out.println(d);
                    toRanker.add(i, new DocumentWordEntry(a, b, c, d, e, f));
                }
            }

        }
        return toRanker;
    }

    //5. build results from to be sent to the interface and be displayed in case of list
    public Result[] formResult(ArrayList<Document> documents, List<String> queryInput) throws IOException {
        Result[] results = new Result[documents.size()];
        int i = 0;
        for (Document d : documents) {
            int id = (int) d.get("_id");
            String url = d.getString("url");
            String snip = helpingClass.getSnippet(id, url, queryInput);
            results[i] = new Result(id, ((double) d.get("score")), url);
            // results[i].setTitle(helpingClass.htmlTitle(pagesPath+id+".html"));
            results[i].setSnippet(snip);
            System.out.println(snip);
            i++;

        }
        return results;
    }

    //6. build results from to be sent to the interface and be displayed in case of string
    public Result[] formResult(ArrayList<Document> documents, String queryInput) throws IOException {
        Result[] results = new Result[documents.size()];
        int i = 0;
        for (Document d : documents) {
            int id = (int) d.get("_id");
            String url = d.getString("url");
            String snip = helpingClass.getExactSnippet(id, d.getString("url"), queryInput);
            results[i] = new Result(id, ((double) d.get("score")), url);
            // results[i].setTitle(helpingClass.htmlTitle(pagesPath+id+".html"));
            results[i].setSnippet(snip);
            i++;

        }
        return results;
    }

} //class



