package Indexer;

public class ImageContainer {
    private String altText;
    private String src;

    public ImageContainer(String altText, String src) {
        this.altText = altText;
        this.src = src;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
