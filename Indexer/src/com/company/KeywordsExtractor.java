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

/**
 * Keywords extractor functionality handler
 */
class KeywordsExtractor {

    /**
     * Get list of keywords with stem form, frequency rank, and terms dictionary
     *
     * @param fullText
     * @return List<Keyword>, which contains keywords cards
     * @throws IOException
     */
    static List<Keyword> getKeywordsList(String fullText) throws IOException {

        TokenStream tokenStream = null;
        TokenStream tokenStream1 = null;
        String notEditedFullText = "";

        try {
            notEditedFullText = fullText;
            // treat the dashed words, don't let separate them during the processing
            fullText = fullText.replaceAll("-+", "-0");

            // replace any punctuation char but apostrophes and dashes with a space
            fullText = fullText.replaceAll("[\\p{Punct}&&[^'-]]+", " ");

            // replace most common English contractions
            fullText = fullText.replaceAll("(?:'(?:[tdsm]|[vr]e|ll))+\\b", "");

            StandardTokenizer stdToken = new StandardTokenizer();
            stdToken.setReader(new StringReader(fullText));

            StandardTokenizer stdToken1 = new StandardTokenizer();
            stdToken1.setReader(new StringReader(notEditedFullText));

            tokenStream = new StopFilter(new ASCIIFoldingFilter(new ClassicFilter(new LowerCaseFilter(stdToken))), EnglishAnalyzer.getDefaultStopSet());
            tokenStream.reset();

            tokenStream1 = new StopFilter(new ASCIIFoldingFilter(new ClassicFilter(new LowerCaseFilter(stdToken1))), EnglishAnalyzer.getDefaultStopSet());
            tokenStream1.reset();


            List<Keyword> cardKeywords = new LinkedList<>();

            CharTermAttribute token = tokenStream.getAttribute(CharTermAttribute.class);
            CharTermAttribute token1 = tokenStream1.getAttribute(CharTermAttribute.class);

            String wholeText = "";
            String [] splitTerms = null;
            String firstStatement = "";
            int counter = 0;

            while(tokenStream1.incrementToken()){
                String term = token1.toString();
                wholeText += term+" ";
            }

            while (tokenStream.incrementToken()) {
                firstStatement = "";
                String term = token.toString();
                String stem = getStemForm(term);

                splitTerms = wholeText.split(" ");

                int start = ((counter - 5 > 0) ? (counter - 5):0);
                int end = ((counter + 5 < splitTerms.length - 1) ? (counter+5):splitTerms.length - 1);
                for(int i = start; i <= end ; i++){
                    firstStatement += " " + splitTerms[i];
                }
                counter++;
                if (stem != null) {
                    Keyword cardKeyword = find(cardKeywords, new Keyword(stem.replaceAll("-0", "-"),firstStatement));
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

            String wholeText = "";
            String [] splitTerms = null;
            String firstStatement = "";
            int counter = 0;
            while (tokenStream.incrementToken()) {
                firstStatement = "";
                String term = token.toString();
                wholeText += term + " ";
                String stem = getStemForm(term);

                splitTerms = wholeText.split(" ");

                int start = ((counter - 5 > 0) ? (counter - 5):0);
                int end = ((counter + 5 < splitTerms.length - 1) ? (counter+5):splitTerms.length - 1);
                for(int i = start; i <= end ; i++){
                    firstStatement += " " + splitTerms[i];
                }
                counter++;
                if (stem != null) {
                    Keyword cardKeyword = find(cardKeywords, new Keyword(stem.replaceAll("-0", "-"),firstStatement,imgSrc));
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