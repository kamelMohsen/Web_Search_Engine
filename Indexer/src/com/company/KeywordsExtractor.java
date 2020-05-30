package com.company;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilter;
import org.apache.lucene.analysis.standard.ClassicFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;
@SuppressWarnings("All")
/**
 * Keywords extractor functionality handler
 */
class KeywordsExtractor {


    static List<Keyword> getKeywordsList(List<HTMLElement> htmlElements) throws IOException {

        TokenStream tokenStream = null;
        String Url = htmlElements.get(0).getElement();

        try {
            List<Keyword> cardKeywords = new LinkedList<>();
            for(int i = 1 ; i< htmlElements.size() ; i++) {


                boolean inTitle = false;
                boolean inHeader = false;

                if(htmlElements.get(i).getType().equals("title")){
                    inTitle = true;
                }
                if(htmlElements.get(i).getType().equals("header")){
                    inHeader = true;
                }
                // treat the dashed words, don't let separate them during the processing
                String fullText = htmlElements.get(i).getElement();

                fullText = fullText.replaceAll("-+", "-0");

                // replace any punctuation char but apostrophes and dashes with a space
                fullText = fullText.replaceAll("[\\p{Punct}&&[^'-]]+", " ");

                // replace most common English contractions
                fullText = fullText.replaceAll("(?:'(?:[tdsm]|[vr]e|ll))+\\b", "");

                StandardTokenizer stdToken = new StandardTokenizer();
                stdToken.setReader(new StringReader(fullText));

                tokenStream = new StopFilter(new ASCIIFoldingFilter(new ClassicFilter(new LowerCaseFilter(stdToken))), EnglishAnalyzer.getDefaultStopSet());
                tokenStream.reset();


                CharTermAttribute token = tokenStream.getAttribute(CharTermAttribute.class);


                while (tokenStream.incrementToken()) {

                    String term = token.toString();
                    boolean inUrl = false;
                    if(Url.toLowerCase().split(term).length>1){
                        inUrl =true;
                    }
                    String stem = getStemForm(term);

                    if (stem != null) {
                        Keyword cardKeyword = find(cardKeywords, new Keyword(stem.replaceAll("-0", "-"), htmlElements.get(i).getElement(),inTitle,inHeader,inUrl));
                        // treat the dashed words back, let look them pretty
                        cardKeyword.add(term.replaceAll("-0", "-"));
                    }
                }
            }
            // reverse sort by frequency
            Collections.sort(cardKeywords);

            return cardKeywords;
        } finally {
            if (tokenStream != null) {
                try {
                    tokenStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }







    // Just for images
    static List<Keyword> getKeywordsList(String fullText,String imgSrc) throws IOException {

        TokenStream tokenStream = null;


        try {

            // treat the dashed words, don't let separate them during the processing
            fullText = fullText.replaceAll("-+", "-0");

            // replace any punctuation char but apostrophes and dashes with a space
            fullText = fullText.replaceAll("[\\p{Punct}&&[^'-]]+", " ");

            // replace most common English contractions
            fullText = fullText.replaceAll("(?:'(?:[tdsm]|[vr]e|ll))+\\b", "");

            StandardTokenizer stdToken = new StandardTokenizer();
            stdToken.setReader(new StringReader(fullText));

            tokenStream = new StopFilter(new ASCIIFoldingFilter(new ClassicFilter(new LowerCaseFilter(stdToken))), EnglishAnalyzer.getDefaultStopSet());
            tokenStream.reset();



            List<Keyword> cardKeywords = new LinkedList<>();

            CharTermAttribute token = tokenStream.getAttribute(CharTermAttribute.class);


            while (tokenStream.incrementToken()) {

                String term = token.toString();
                String stem = getStemForm(term);


                if (stem != null) {
                    Keyword cardKeyword = find(cardKeywords, new Keyword(stem.replaceAll("-0", "-"),"",imgSrc));
                    // treat the dashed words back, let look them pretty
                    cardKeyword.add(term.replaceAll("-0", "-"));
                }
            }

            // reverse sort by frequency
            Collections.sort(cardKeywords);

            return cardKeywords;
        } finally {
            if (tokenStream != null) {
                try {
                    tokenStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * Get stem form of the term
     *
     * @param term
     * @return String, which contains the stemmed form of the term
     * @throws IOException
     */
    private static String getStemForm(String term) throws IOException {

        TokenStream tokenStream = null;

        try {
            StandardTokenizer stdToken = new StandardTokenizer();
            stdToken.setReader(new StringReader(term));

            tokenStream = new PorterStemFilter(stdToken);
            tokenStream.reset();

            // eliminate duplicate tokens by adding them to a set
            Set<String> stems = new HashSet<>();

            CharTermAttribute token = tokenStream.getAttribute(CharTermAttribute.class);

            while (tokenStream.incrementToken()) {
                stems.add(token.toString());
            }

            // if stem form was not found or more than 2 stems have been found, return null
            if (stems.size() != 1) {
                return null;
            }

            String stem = stems.iterator().next();

            // if the stem form has non-alphanumerical chars, return null
            if (!stem.matches("[a-zA-Z0-9-]+")) {
                return null;
            }

            return stem;
        } finally {
            if (tokenStream != null) {
                try {
                    tokenStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Find sample in collection
     *
     * @param collection
     * @param sample
     * @param <T>
     * @return <T> T, which contains the found object within collection if exists, otherwise the initially searched object
     */
    private static <T> T find(Collection<T> collection, T sample) {

        for (T element : collection) {
            if (element.equals(sample)) {
                return element;
            }
        }

        collection.add(sample);

        return sample;
    }
}