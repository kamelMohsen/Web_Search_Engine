import java.io.IOException;

public class Main {



    public static void main(String args[]) throws IOException {
        int id = 0;
        String url = "https://www.bbc.com/";
        String htmlCode = HTMLPage.HTMLToString("./Downlaoded_HTML_Pages/Test.html");
        HTMLPage newHtml = new HTMLPage(id, url, htmlCode);
        System.out.println("ID is: " + newHtml.getId() + "\nUrl is: " + newHtml.getUrl() + "\nTitle is: " + newHtml.getTitle() );
        System.out.println("MetaKeywords are: " + newHtml.getMetaKeywords());
        System.out.println("Whole text is: " + newHtml.getText());
    }

}
