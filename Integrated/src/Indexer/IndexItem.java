package Indexer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IndexItem {

    private String word;

    private DocumentWordEntry documentWordElement;

    public IndexItem(String word, DocumentWordEntry documentWordEntriesList) {
        this.word = word;
        this.documentWordElement = documentWordEntriesList;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public DocumentWordEntry getDocumentWordElement() {
        return documentWordElement;
    }

    public void setDocumentWordElement(DocumentWordEntry documentWordElement) {
        this.documentWordElement = documentWordElement;
    }
}
