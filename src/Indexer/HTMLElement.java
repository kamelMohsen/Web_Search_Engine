package Indexer;

public class HTMLElement {
    private String Element;
    private String Type;

    public HTMLElement(String element, String type) {
        Element = element;
        Type = type;
    }

    // Setters and Getters


    public String getElement() {
        return Element;
    }

    public void setElement(String element) {
        Element = element;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
