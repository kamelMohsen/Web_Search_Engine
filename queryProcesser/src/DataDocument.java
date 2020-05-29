//package queryprocessor;

import opennlp.tools.tokenize.WhitespaceTokenizer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DataDocument {

    private Integer id;
    private Set<String> titleKeywords;
    private Set<String> metaKeywords;
    private String text;

    public DataDocument(Integer id, String url, String html) {

        Document parsedHtml = Jsoup.parse(html, url);
        StringBuilder parsedText = new StringBuilder();

        // Extract title
        String title = parsedHtml.title().toLowerCase().replaceAll("[^a-z0-9]", " ");
        parsedText.append(title).append(" ");

        // Extract meta keywords

        String metaKeywords = "";
        for(Element metaTag: parsedHtml.getElementsByTag("meta")) {
            if (metaTag.attr("name").equals("keywords")) {
                metaKeywords = metaTag.attr("content").toLowerCase().replaceAll("[^a-z0-9]", " ");
                break;
            }
        }
        parsedText.append(metaKeywords).append(" ");

        // Extract text
        //parsedHtml.body().traverse(new NodeVisitor() {
          //  @Override
            //public void head(Node node, int i) {
              //  if (node instanceof TextNode && !((TextNode) node).isBlank()) {
                //    parsedText.append(((TextNode) node).text().toLowerCase().replaceAll("[^a-z0-9]", " "))
                  //          .append(" ");
                //}
            //}

            //@Override
            //public void tail(Node node, int i) {

            //}
        //});

        WhitespaceTokenizer wsTokenizer = WhitespaceTokenizer.INSTANCE;

        this.id = id;
        this.titleKeywords = new HashSet<>(Arrays.asList(wsTokenizer.tokenize(title)));
        this.metaKeywords = new HashSet<>(Arrays.asList(wsTokenizer.tokenize(metaKeywords)));
        this.text = parsedText.toString();
    }

    public Integer getId() {
        return id;
    }

    public Set<String> getTitleKeywords() {
        return titleKeywords;
    }

    public Set<String> getMetaKeywords() {
        return metaKeywords;
    }

    public String getText() {
        return text;
    }

}
