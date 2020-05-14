package com.company;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String text = "compiler compile";
        List<Keyword> keywordsList = KeywordsExtractor.getKeywordsList(text);
        for (int i =0; i < keywordsList.size(); i++ ){
            System.out.println(keywordsList.get(i).getStem() + " " + keywordsList.get(i).getFrequency() + " " +keywordsList.get(i).getTerms());
        }
    }
}
