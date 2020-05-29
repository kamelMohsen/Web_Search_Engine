package com.company;

import java.util.List;

public class Normalizer {

    DataBase dataBase ;
    final List<Link> linksList;
    String url;
    int size;

    public Normalizer(DataBase dataBase, List<Link> linksList,int size) {
        this.dataBase = dataBase;
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


            dataBase.normalizeURL(this.url,this.size);
        }
    }


}
