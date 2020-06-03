import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import java.io.IOException;
import java.util.*;
public class Trends {
    Database DB;
    public Trends(){
        DB = new Database();
    };
    public void postQuery(String Query, String Region){
                    Annotation document =
                            new Annotation(Query);
                    Properties props = new Properties();
                    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,entitymentions");
                    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
                    pipeline.annotate(document);



                    for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
                        for (CoreMap entityMention : sentence.get(CoreAnnotations.MentionsAnnotation.class)) {

                            //System.out.println(entityMention.get(CoreAnnotations.EntityTypeAnnotation.class));
                            if (entityMention.get(CoreAnnotations.EntityTypeAnnotation.class).equals("PERSON")) {
                                DB.insertWord(entityMention.toString(),Region);
                                //System.out.println(entityMention.toString());
                            }
                        }

                    }

    }
    public void getTrendsInRegion(List<String> List ,
                                  Vector<Integer> numbers ,
                                  String Region){
        List.clear();
        numbers.clear();
        DB.getTrends(List,numbers,Region);
    }
    public void getTrendsWorldWide(List<String> List ,Vector<Integer> numbers ){
        List.clear();
        numbers.clear();
        DB.getTrends(List,numbers);
    }

    public static void main(String[] args){
        Trends T = new Trends();
        List<String> Trends = new LinkedList<String>();
        Vector<Integer> numbers = new Vector<Integer>();
        T.getTrendsInRegion(Trends,numbers,"MOH");
        for(int i = 0 ;i< Trends.size(); i++)
        System.out.println(Trends.get(i)+" with  " +numbers.get(i)+"number :" + i +"    ");
        System.out.println("WorldWide");
        T.getTrendsWorldWide(Trends,numbers);
        for(int i = 0 ;i< Trends.size(); i++)
            System.out.println(Trends.get(i)+" with  " +numbers.get(i)+"number :" + i +"    ");
    }
}
