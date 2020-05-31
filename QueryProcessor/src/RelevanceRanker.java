import java.util.ArrayList;
import java.util.Collections;

public class RelevanceRanker {
    public void calculateRelevanceRank(ArrayList<DocumentWordEntry> docs){
        for (DocumentWordEntry doc: docs){

            doc.calculateTotalRank();
        }
         Collections.sort(docs, Collections.reverseOrder());
    }

}
