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
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }

    //2.check if there is quotes or not , returns array of results
    public static int phraseOrNonphrase(String string ) throws IOException{
        if(string.startsWith("\""))
        {
            //phrase search
            System.out.println("yes it is a phrase");
            String phrase= string.replaceAll("\"", "");
            return 0;
        }
        else{
            //non phrase search
            System.out.println("Not a phrase");
            return  1 ;
        }
    }

    //3. phrase search
    public void phraseSearch() throws IOException{

    }

    //4. nonPhraseSearch
    public ArrayList<DocumentWordEntry> nonPhraseSearch(String [] finalStemmedArray,int length,MongoCollection<Document> collection  ) throws IOException{
        ArrayList<DocumentWordEntry> toRanker = new ArrayList<DocumentWordEntry>();
        for(int i = 0 ; i <length; i++) {
            //  List<Document> documents = (List<Document>) collection.find(Filters.eq("nickName", "Saraaaa")).into(new ArrayList<Document>());
            FindIterable<Document> documents = (FindIterable<Document>) collection.find(Filters.or(Filters.eq("word", finalStemmedArray[i]), Filters.eq("word", "bad")));
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
                    System.out.println(d);
                    toRanker.add(i, new DocumentWordEntry(a, b, c, d, e));
                }
            }

        }
        return toRanker;
    }

    //5. build results from to be sent to the interface and be displayed in case of list
    public Result[] formResult( ArrayList<Document> documents, List<String> queryInput) throws IOException
    {
        Result[] results=new Result[documents.size()];
        int i=0;
        for(Document d:documents)
        {
            int id=(int)d.get("_id");
            String url=d.getString("url");
            String snip=helpingClass.getSnippet(id,url,queryInput );
            results[i]=new Result(id,((double)d.get("score")),url);
           // results[i].setTitle(helpingClass.htmlTitle(pagesPath+id+".html"));
            results[i].setSnippet(snip);
            System.out.println(snip);
            i++;

        }
        return results;
    }

   //6. build results from to be sent to the interface and be displayed in case of string
    public Result[] formResult( ArrayList<Document> documents, String queryInput) throws IOException
    {
        Result[] results=new Result[documents.size()];
        int i=0;
        for(Document d:documents)
        {
            int id=(int)d.get("_id");
            String url=d.getString("url");
            String snip=helpingClass.getExactSnippet(id,d.getString("url"),queryInput);
            results[i]=new Result(id,((double)d.get("score")),url);
           // results[i].setTitle(helpingClass.htmlTitle(pagesPath+id+".html"));
            results[i].setSnippet( snip);
            i++;

        }
        return results;
    }


  }

