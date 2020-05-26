import java.util.*;
import java.io.File;
import java.io.IOException;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import org.apache.commons.io.FileUtils;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class helpingClass {
    //Data members
    static   String[] stopWords ={"a", "as", "able", "about", "above", "according", "accordingly", "across", "actually", "after", "afterwards",
            "again", "against", "aint", "all", "allow", "allows", "almost", "alone", "along", "already", "also", "although",
            "always", "am", "among", "amongst", "an", "and", "another", "any", "anybody", "anyhow", "anyone", "anything", "anyway",
            "anyways", "anywhere", "apart", "appear", "appreciate", "appropriate", "are", "arent", "around", "as" };

    static Set<String> stopWordSet = new HashSet<String>(Arrays.asList(stopWords));
    WhitespaceTokenizer wsTokenizer = WhitespaceTokenizer.INSTANCE;
    static final String pagesPath = "E:/CCE Files/Semster6/APT/spring 2018/Crawler/pages/";

    //Constructor
    static public DataDocument  helpingClass(Integer id, String url) throws IOException
    {
        DataDocument dataDocument=new  DataDocument(id,url,readFile(id));
        return  dataDocument;
    }

    //Function check stop word or not
    public static boolean isStopword(String word) {
        if(word.length() < 2) return true;
        //if(word.charAt(0) >= '0' && word.charAt(0) <= '9') return true; //remove numbers, "25th", etc-->check
        if(stopWordSet.contains(word)) return true;
        else return false;
    }

    //Function that removes the stopping words
    public static List<String> remove(String string)
    {
        String[] words=string.split("\\s+");//match one or many whitespaces
        //String[] result = new String[words.length]; //maximum size is length of words
        List<String> s=new ArrayList<>();
        for(String word:words){
            if(word.isEmpty()) continue;
            if(isStopword(word)) continue; //remove stopwords
            //result[i]=word;
            s.add(word);
            // i++;
        }
        //return result;
        return s;
    }


    static  public String readFile(Integer urlId) throws IOException {
        return FileUtils.readFileToString(new File(pagesPath + "/" + Integer.toString(urlId) + ".html"), "UTF-8");
    }

    static public String htmlTitle(String filePath) throws IOException
    {
        File file=new File(filePath);
        Document doc = Jsoup.parse(file, "UTF-8", "");
        return doc.title();
    }

    static public String getSnippet(Integer id, String url,List<String> queryInput) throws IOException{

        String snip="";

        DataDocument doc=helpingClass(id, url);
        String b= doc.getText();
        //search for any of the inputs in the body and return first index
        int sIndex=0;
        for(int i=0;i<queryInput.size();i++)
        {
            if(b.contains(queryInput.get(i)))
            {
                sIndex=i;
                break;
            }
        }
        if(sIndex>10)
        {
            if(b.length()>=150)
            {
                snip=   b.substring(sIndex-10, sIndex+140);
            }
            else
            {
                snip=b.substring(sIndex-10, b.length()-1);
                for(int i=snip.length()-1;i<160;i++)
                    snip+='.';
            }
        }
        else
        {
            if(b.length()>=150)
            {
                snip=   b.substring(sIndex, sIndex+150);
            }
            else
            {
                snip=b.substring(sIndex, b.length()-1);
                if(snip.length()<150)
                    snip+="...";
            }
        }


        System.out.println(b);
        //  System.out.println(in);
        //  System.out.println(b.substring(in-150, in-1));
        //System.out.println(b.substring(in, in+150));

        System.out.println("snip=  "+snip);

        return  snip;
    }

    static public  String getExactSnippet(Integer id, String url,String input) throws IOException
    {
        String snip="";
        DataDocument doc=helpingClass(id,url);
        String b= doc.getText();
        //search for any of the inputs in the body and return first index
        int sIndex=b.indexOf(input);
        if(sIndex>10)
        {
            if(b.length()>=150)
            {
                snip=   b.substring(sIndex-10, sIndex+140);
            }
            else
            {
                snip=b.substring(sIndex-10, b.length()-1);
                for(int i=snip.length()-1;i<160;i++)
                    snip+='.';
            }
        }
        else
        {
            if(b.length()>=150)
            {
                snip=   b.substring(sIndex, sIndex+150);
            }
            else
            {
                snip=b.substring(sIndex, b.length()-1);
                if(snip.length()<150)
                    snip+="...";
            }
        }
        return snip;
    }

}
