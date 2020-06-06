import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.URL;
import java.net.MalformedURLException;

import java.io.IOException;
import java.util.*;

import java.util.regex.PatternSyntaxException;

@SuppressWarnings("ALL")
public class Scraper {

    public List<String> links = new LinkedList<String>();
    public Document htmlDocument;
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    int counter = 0;

    public void scrape(Database DB, String url, Map<String, Vector<String>> forbiddenList, Map<String, Vector<String>> allowedList) {
        try {
            boolean forbidden = false;
            boolean allowed = false;
            String metaKeyWords = " ";
            int importance = 0;

            if (!forbiddenList.containsKey(getDomain(url)) && !allowedList.containsKey(getDomain(url)))
                robotRead(url, forbiddenList, allowedList);

            if (forbiddenList.containsKey(getDomain(url))) {
                for (int i = 0; i < forbiddenList.get(getDomain(url)).size(); i++) {

                    if (url.startsWith(forbiddenList.get(getDomain(url)).get(i)))
                        forbidden = true;
                }
            }
            if (forbidden) {
                if (allowedList.containsKey(getDomain(url))) {
                    for (int i = 0; i < allowedList.get(getDomain(url)).size(); i++) {
                        if (url.startsWith(allowedList.get(getDomain(url)).get(i)))
                            allowed = true;
                    }
                } else
                    return;
            }
            if (forbidden && !allowed)
                return;


            Document htmlDocument = Jsoup.connect(url).get();
            this.htmlDocument = Jsoup.parse(htmlDocument.toString());
            for (Element metaTag : this.htmlDocument.getElementsByTag("meta")) {
                if (metaTag.attr("name").toLowerCase().equals("keywords")) {
                    metaKeyWords = metaTag.attr("content").toLowerCase();
                    break;
                }
            }
            if (metaKeyWords.toLowerCase().contains("news") || metaKeyWords.toLowerCase().contains("movie") || metaKeyWords.toLowerCase().contains("tv") || metaKeyWords.toLowerCase().contains("radio") || metaKeyWords.toLowerCase().contains("music") || metaKeyWords.toLowerCase().contains("sport"))
                importance = 1;
            Elements hyperLinks = htmlDocument.select("a[href]");
            for (Element link : hyperLinks) {
                this.links.add(link.absUrl("href"));
                if(links.size()>30){
                    break;
                }
            }
            DB.visitLink(url, importance);
            DB.insertLink(getLinks());
            DB.insertHref(getLinks(), url);
        } catch (IOException ioe) {
            System.out.println("Error in the HTTP request " + ioe);
        } catch (PatternSyntaxException e) {
            System.out.println("Regex error " + e);
        } catch (IllegalArgumentException e) {

        }
    }

    public List<String> getLinks() {
        return this.links;
    }

    private static String getDomain(String url1) {
        String baseUrl = null;
        try {
            URL url = new URL(url1);
            baseUrl = url.getProtocol() + "://" + url.getHost();

        } catch (MalformedURLException e) {
            System.out.println("Malformed Exception ");
        }
        return baseUrl;
    }

    private void robotRead(String url, Map<String, Vector<String>> forbiddenList, Map<String, Vector<String>> allowedList) throws IOException {
        boolean start = false;
        Vector<String> robotForAll = new Vector<>();
        Vector<String> forbidden = new Vector<>();
        Vector<String> allowed = new Vector<>();
        String Domain = getDomain(url);
        Document htmlDocument;
        try {
                htmlDocument = Jsoup.connect(Domain + "/robots.txt").get();
        }
        catch ( IOException ioe){
            // no robot so forbidden paths vector is empty
           forbiddenList.put(Domain,forbidden);
           return;
        }
        String[] words = htmlDocument.text().split(" ");

        for (int i = 0; i < words.length-2; i++) {
            if (words[i].equals("User-agent:") && (words[i + 1].equals("*"))) {
                start = true;
                i += 2;
            }
            if (start) {
                if (words[i].equals("User-agent:") && !(words[i + 1].equals("*")) || words[i].equals("#"))
                    break;
                robotForAll.add(words[i]);
            }
        }

        for (int i = 0; i < robotForAll.size() - 1; i++) {
            if (robotForAll.get(i).equals("Disallow:"))
                forbidden.add(Domain + robotForAll.get(i + 1));
            if (robotForAll.get(i).equals("Allow:"))
                allowed.add(Domain + robotForAll.get(i + 1));
        }
        forbiddenList.put(Domain, forbidden);
        allowedList.put(Domain, allowed);

    }

    public void Rescrape(Database DB, String url) {

        try {

            Document htmlDocument = Jsoup.connect(url).get();
            Elements hyperLinks = htmlDocument.select("a[href]");
            for (Element link : hyperLinks) {
                this.links.add(link.absUrl("href"));
                if(links.size()>30){
                    break;
                }
            }
            DB.updateLink(url);
            DB.updateHref(getLinks(), url);
        } catch (IOException ioe) {
            System.out.println("Error in the HTTP request " + ioe);
        } catch (PatternSyntaxException e) {
            System.out.println("Regex error " + e);
        } catch (IllegalArgumentException e) {

        }
    }
}
