package Indexer;

import org.apache.tika.langdetect.OptimaizeLangDetector;
import org.apache.tika.language.detect.LanguageDetector;
import org.apache.tika.language.detect.LanguageResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
@SuppressWarnings("All")
public class HTMLPage {

    private String url;
    private Document parsedHtml;
    private String title;
    private double pageRank;
    private List<HTMLElement> htmlElements;
    String text;
    private int wordsCount;
    private List<ImageContainer> imgList;



    //Constructor that makes HtmlPage with initialized info
    public HTMLPage( String url, double pageRank) throws IOException {

        this.imgList = new LinkedList<>();
        this.text = "";
        this.htmlElements = new LinkedList<HTMLElement>();
        this.pageRank = pageRank;
        this.wordsCount =0;

        try {
            parsedHtml = Jsoup.connect(url).get();
            StringBuilder parsedText = new StringBuilder();
            this.url = url;

            // Extract title
            this.title = parsedHtml.title();
            String alt;
            String src;
            String lang = parsedHtml.getElementsByTag("html").attr("lang");

            // Extracting Images
            for(Element metaTag: parsedHtml.getElementsByTag("img")) {
                alt = metaTag.attr("alt");
                src = metaTag.attr("src");
                if(!alt.equals("") && !src.equals("")) {
                    ImageContainer imageContainer = new ImageContainer(alt,src);
                    imgList.add(imageContainer);
                }
            }

            // Extract headers and add title and url
            this.htmlElements.add(new HTMLElement(this.url,"url"));

            this.htmlElements.add(new HTMLElement(parsedHtml.title(),"title"));
            this.text += parsedHtml.title()+" ";

            for(Element header : parsedHtml.getElementsByTag("h1")) {
                this.htmlElements.add(new HTMLElement(header.text(),"header"));
                this.text += header.text()+" ";
            }
            for(Element header : parsedHtml.getElementsByTag("h2")) {
                this.htmlElements.add(new HTMLElement(header.text(),"header"));
                this.text += header.text()+" ";
            }
            for(Element header : parsedHtml.getElementsByTag("h3")) {
                this.htmlElements.add(new HTMLElement(header.text(),"header"));
                this.text += header.text()+" ";
            }
            for(Element header : parsedHtml.getElementsByTag("h4")) {
                this.htmlElements.add(new HTMLElement(header.text(),"header"));
                this.text += header.text()+" ";
            }
            for(Element header : parsedHtml.getElementsByTag("h5")) {
                this.htmlElements.add(new HTMLElement(header.text(),"header"));
                this.text += header.text()+" ";
            }
            for(Element header : parsedHtml.getElementsByTag("h6")) {
                this.htmlElements.add(new HTMLElement(header.text(),"header"));
                this.text += header.text()+" ";
            }
            for(Element header : parsedHtml.getElementsByTag("th")) {
                this.htmlElements.add(new HTMLElement(header.text(),"header"));
                this.text += header.text()+" ";
            }

            // Extract rest of the site
            for(Element header : parsedHtml.getElementsByTag("p")) {
                this.htmlElements.add(new HTMLElement(header.text(),"paragraph"));
                this.text += header.text()+" ";
            }
            for(Element header : parsedHtml.getElementsByTag("b")) {
                this.htmlElements.add(new HTMLElement(header.text(),"bold"));
                this.text += header.text()+" ";
            }
            for(Element header : parsedHtml.getElementsByTag("i")) {
                this.htmlElements.add(new HTMLElement(header.text(),"italic"));
                this.text += header.text()+" ";
            }
            for(Element header : parsedHtml.getElementsByTag("small")) {
                this.htmlElements.add(new HTMLElement(header.text(),"small"));
                this.text += header.text()+" ";
            }
            for(Element header : parsedHtml.getElementsByTag("ol")) {
                this.htmlElements.add(new HTMLElement(header.text(),"ordered_list"));
                this.text += header.text()+" ";
            }
            for(Element header : parsedHtml.getElementsByTag("ul")) {
                this.htmlElements.add(new HTMLElement(header.text(),"unordered_list"));
                this.text += header.text()+" ";
            }
            for(Element header : parsedHtml.getElementsByTag("td")) {
                this.htmlElements.add(new HTMLElement(header.text(),"table_column"));
                this.text += header.text()+" ";
            }
            for(Element header : parsedHtml.getElementsByTag("tr")) {
                this.htmlElements.add(new HTMLElement(header.text(),"table_row"));
                this.text += header.text()+" ";
            }

            this.wordsCount = this.text.split("\\s+").length;

            LanguageDetector detector = new OptimaizeLangDetector().loadModels();
            LanguageResult result = detector.detect(this.text);

            if(!result.getLanguage().equals("en") || this.wordsCount < 100 || !lang.equals("en")){
                this.parsedHtml = null;
            }


        }catch (Exception ignored)
        {

        }

    }

   // Setters & Getters
   public List<HTMLElement> getHtmlElements() {
       return htmlElements;
   }
    public double getPageRank() {
        return pageRank;
    }

    public void setPageRank(double pageRank) {
        this.pageRank = pageRank;
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public List<ImageContainer> getImgList() {
        return imgList;
    }

    public void setImgList(List<ImageContainer> imgList) {
        this.imgList = imgList;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Document getParsedHtml() {
        return parsedHtml;
    }

    public void setHtmlCode(Document parsedHtml) {
        this.parsedHtml = parsedHtml;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    //Extra function made it at first to extract html code from html file if existing
    public static String HTMLToString(String path)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }
        String content = contentBuilder.toString();

        return content;
    }
}
