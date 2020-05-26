import java.util.*;
import opennlp.tools.stemmer.PorterStemmer;
import java.io.File;
import java.io.IOException;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import org.apache.commons.io.FileUtils;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Stemming {
    //Data members
    static   String[] stopWords ={"I","is","the","of","why","a", "as", "able", "about", "above", "according", "accordingly", "across", "actually", "after", "afterwards",
            "again", "against", "aint", "all", "allow", "allows", "almost", "alone", "along", "already", "also", "although",
            "always", "am", "among", "amongst", "an", "and", "another", "any", "anybody", "anyhow", "anyone", "anything", "anyway",
            "anyways", "anywhere", "apart", "appear", "appreciate", "appropriate", "are", "arent", "around", "as" };

    //1.change the array to a set to search it easily
    static Set<String> stopWordSet = new HashSet<String>(Arrays.asList(stopWords));

    //2. Check is it a stopping word or not
    public static boolean isStopWord(String word) {
        if(word.length() < 2) return true;
        if(stopWordSet.contains(word)) return true;
        else return false;
    }

    // 3.Removes the stopping words and returns a list of the words to be searched
    public static List<String> remove(String string)
    {
        String[] words=string.split("\\s+");//removes all white spaces and put it into an array
        List<String> s=new ArrayList<>();
        for(String word:words){                  //loops on the array
            if(word.isEmpty()) continue;         //In case empty or stop word don't add to the list
            if(isStopWord(word)) continue;
            s.add(word);
        }
        return s;                                   //Finally returns the result which is a list of non stop words;
    }

}



