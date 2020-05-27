public class DocumentWordEntry {
    private String docID;
    private int frequency;
    private boolean inTitle;
    private String firstStatement;
    private String imgSrc;
    private String name;

    public DocumentWordEntry(String docID, int frequency, boolean inTitle, String firstStatement, String imgSrc ,String name) {
        this.docID = docID;
        this.frequency = frequency;
        this.inTitle = inTitle;
        this.firstStatement = firstStatement;
        this.imgSrc = imgSrc;
        this.name = name;

    }

    // Setters & Getters

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getFirstStatement() {
        return firstStatement;
    }

    public void setFirstStatement(String firstStatement) {
        this.firstStatement = firstStatement;
    }

    public String getDocID() {
        return docID;
    }
    public String getName(){
        return name;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public boolean isInTitle() {
        return inTitle;
    }

    public void setInTitle(boolean inTitle) {
        this.inTitle = inTitle;
    }
}