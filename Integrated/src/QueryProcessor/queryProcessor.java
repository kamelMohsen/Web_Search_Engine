package QueryProcessor; //imports
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import opennlp.tools.stemmer.PorterStemmer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.bson.Document;

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


    public ArrayList<QueryDocumentWordEntry>  imageSearch(String[] finalStemmedArray, int length, MongoCollection<Document> collection) {
        ArrayList<QueryDocumentWordEntry> allResults = new ArrayList<QueryDocumentWordEntry>();

        for (int i = 0; i < length; i++) {
            FindIterable<Document> documents = (FindIterable<Document>) collection.find(Filters.eq("word", finalStemmedArray[i]));
            for (Document document : documents) {
                double pageRank = (double) document.get("page_rank");
                String docUrl = (String) document.get("doc_url");
                String docTitle = (String) document.get("title");
                int wordFrequency = (int) document.get("word_frequency");
                boolean isInTitle = (boolean) document.get("is_in_title");
                boolean isInHeader = (boolean) document.get("is_in_header");
                boolean isInUrl = (boolean) document.get("is_in_url");
                String firstStatement = (String) document.get("first_statement");
                String word = (String) document.get("word");
                int docLength = (int) document.get("total_words_count");
                double tf = (double) document.get("tf");
                double idf = (double) document.get("idf");
                double urlLength = (double) document.get("url_length");

                ArrayList<Document> allWebPages = (ArrayList<Document>) document.get("img_srcs"); //has all info need to be parsed

                List<String> imgSrc = new LinkedList<String>();
                for (Document obj : allWebPages) {

                    imgSrc.add((String) obj.get("img_Src"));
                }

                allResults.add(new QueryDocumentWordEntry(pageRank, docUrl, docTitle, wordFrequency, isInTitle,
                        isInHeader, isInUrl, firstStatement, imgSrc, word, docLength, tf, idf, urlLength));

            }
        }



        return  allResults;
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
                    j--;
                }

            }

        }


        return allResults;
    }



     static void createJSFile(ArrayList<QueryDocumentWordEntry> docs, String Path){


         try {

             FileWriter myWriter = new FileWriter(Path+"/pagination.js");
             myWriter.write("var current_page = 1;\n");
             myWriter.write("var records_per_page = 10;\n");
             myWriter.write("var objJson = [\n");
             for(int i = 0 ; i < docs.size(); i++){
                 if(i== docs.size()-1){
                     String Stripped = docs.get(i).getFirstStatement().replaceAll("\""," ").replaceAll("\\n|\\\t"," ");
                     myWriter.write("    { title:\""+docs.get(i).getTitle().replaceAll("\""," ").replaceAll("\\n|\\\t"," ")+"\" ," +
                             " statement:\""+Stripped.substring(0,(Stripped.length()>140 ? 140:Stripped.length()))+"..."+"\" ," +
                             " url:\""+docs.get(i).getUrl().replaceAll("\""," ").replaceAll("\\n|\\\t"," ")+"\"}\n");
                 }
                 else {
                     String Stripped = docs.get(i).getFirstStatement().replaceAll("\""," ").replaceAll("\\n|\\\t"," ");
                     myWriter.write("    { title: \"" + docs.get(i).getTitle().replaceAll("\"", " ").replaceAll("\\n|\\\t"," ") + "\" ," +
                             " statement:\""+Stripped.substring(0,(Stripped.length()>140 ? 140:Stripped.length()))+"..."+"\" ," +
                             " url:\"" + docs.get(i).getUrl().replaceAll("\""," ").replaceAll("\\n|\\\t"," ") + "\"},\n");
                 }
             }
             myWriter.write("];");

             myWriter.write("function prevPage()\n" +
                     "{\n" +
                     "    if (current_page > 1) {\n" +
                     "        current_page--;\n" +
                     "        changePage(current_page);\n" +
                     "    }\n" +
                     "}");

             myWriter.write("function nextPage()\n" +
                     "{\n" +
                     "    if (current_page < numPages()) {\n" +
                     "        current_page++;\n" +
                     "        changePage(current_page);\n" +
                     "    }\n" +
                     "}");

             myWriter.write("function changePage(page)\n" +
                     "{\n" +
                     "    var btn_next = document.getElementById(\"btn_next\");\n" +
                     "    var btn_prev = document.getElementById(\"btn_prev\");\n" +
                     "    var listing_table = document.getElementById(\"listingTable\");\n" +
                     "    var page_span = document.getElementById(\"page\");\n" +
                     "\n" +
                     "    // Validate page\n" +
                     "    if (page < 1) page = 1;\n" +
                     "    if (page > numPages()) page = numPages();\n" +
                     "\n" +
                     "    listing_table.innerHTML = \"\";\n" +
                     "\n" +
                     "    for (var i = (page-1) * records_per_page; i < (page * records_per_page) && i < objJson.length; i++) {\n" +
                     "        listing_table.innerHTML += \"<b><a href=\\\"\"+objJson[i].url+\"\\\"><font size=\\\"5\\\">\"+objJson[i].title+\"</font></a>\"+ \"</b><br>\";\n" +
                     "        listing_table.innerHTML += \"<font color=\\\"green\\\">\"+objJson[i].url+\"</font><br>\";\n" +
                     "        listing_table.innerHTML += \"<font color=\\\"black\\\" size=\\\"3\\\">\"+objJson[i].statement+\"</font><br>\"+ \"<br>\";\n" +

                     "    }\n" +
                     "    page_span.innerHTML = page;\n" +
                     "\n" +
                     "    if (page == 1) {\n" +
                     "        btn_prev.style.visibility = \"hidden\";\n" +
                     "    } else {\n" +
                     "        btn_prev.style.visibility = \"visible\";\n" +
                     "    }\n" +
                     "\n" +
                     "    if (page == numPages()) {\n" +
                     "        btn_next.style.visibility = \"hidden\";\n" +
                     "    } else {\n" +
                     "        btn_next.style.visibility = \"visible\";\n" +
                     "    }\n" +
                     "}\n");

             myWriter.write("function numPages()\n" +
                    "{\n" +
                    "    return Math.ceil(objJson.length / records_per_page);\n" +
                    "}\n" +
                    "\n" +
                    "window.onload = function() {\n" +
                    "    changePage(1);\n" +
                    "};");


             myWriter.close();
             System.out.println("Successfully wrote to the file.");
         } catch (IOException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
         }

    }


} //end class



