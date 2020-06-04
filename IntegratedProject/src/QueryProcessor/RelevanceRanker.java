package QueryProcessor;

import java.util.ArrayList;
import java.util.Collections;

public class RelevanceRanker {
    public void calculateRelevanceRank(ArrayList<QueryDocumentWordEntry> docs){
        for (QueryDocumentWordEntry doc: docs){

            doc.calculateTotalRank();
        }
         Collections.sort(docs, Collections.reverseOrder());
    }

}
