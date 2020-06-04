package Indexer;

import java.util.List;

public class Normalizer {

    IndexerDataBaseManager indexerDataBaseManager;
    final List<Link> linksList;
    String url;
    int size;

    public Normalizer(IndexerDataBaseManager indexerDataBaseManager, List<Link> linksList, int size) {
        this.indexerDataBaseManager = indexerDataBaseManager;
        this.linksList = linksList;
        this.size = size;
    }

    public void startNormalizing(){
        while (true) {


            if(linksList.size()==0)
                break;
            try {
                this.url = "";
                this.url = linksList.get(0).getUrl();
                linksList.remove(0);
            }catch(NullPointerException ignored)
            {
            }


            indexerDataBaseManager.normalizeURL(this.url,this.size);
        }
    }


}
