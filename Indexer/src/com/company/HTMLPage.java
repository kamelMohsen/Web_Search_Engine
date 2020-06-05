package com.company;

import org.apache.tika.langdetect.OptimaizeLangDetector;
import org.apache.tika.language.detect.LanguageDetector;
import org.apache.tika.language.detect.LanguageResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

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
    private String region;
    private Date date;

    //Constructor that makes HtmlPage with initialized info
    public HTMLPage(String url, double pageRank) throws IOException {

        this.imgList = new LinkedList<>();
        this.text = "";
        this.htmlElements = new LinkedList<HTMLElement>();
        this.pageRank = pageRank;
        this.wordsCount = 0;

        try {
            parsedHtml = Jsoup.connect(url).get();
            StringBuilder parsedText = new StringBuilder();
            this.url = url;

            if (url.endsWith(".af") || url.endsWith("/af")) {
                this.region = "Afghanistan";
            } else if (url.endsWith(".as") || url.endsWith("/as")) {
                this.region = "American Samoa";
            } else if (url.endsWith(".ai") || url.endsWith("/ai")) {
                this.region = "Anguilla";
            } else if (url.endsWith(".ar") || url.endsWith("/ar")) {
                this.region = "Argentina";
            } else if (url.endsWith(".au") || url.endsWith("/au")) {
                this.region = "Australia";
            } else if (url.endsWith(".al") || url.endsWith("/al")) {
                this.region = "Albania";
            } else if (url.endsWith(".ad") || url.endsWith("/ad")) {
                this.region = "Andorra";
            } else if (url.endsWith(".aq") || url.endsWith("/aq")) {
                this.region = "Antarctica";
            } else if (url.endsWith(".am") || url.endsWith("/am")) {
                this.region = "Armenia";
            } else if (url.endsWith(".at") || url.endsWith("/at")) {
                this.region = "Austria";
            } else if (url.endsWith(".dz") || url.endsWith("/dz")) {
                this.region = "Algeria";
            } else if (url.endsWith(".ao") || url.endsWith("/ao")) {
                this.region = "Angola";
            } else if (url.endsWith(".ag") || url.endsWith("/ag")) {
                this.region = "Antigua and Barbuda";
            } else if (url.endsWith(".aw") || url.endsWith("/aw")) {
                this.region = "Aruba";
            } else if (url.endsWith(".az") || url.endsWith("/az")) {
                this.region = "Azerbaijan";
            } else if (url.endsWith(".bs") || url.endsWith("/bs")) {
                this.region = "Bahamas";
            } else if (url.endsWith(".bb") || url.endsWith("/bb")) {
                this.region = "Barbados";
            } else if (url.endsWith(".bz") || url.endsWith("/bz")) {
                this.region = "Belize";
            } else if (url.endsWith(".bt") || url.endsWith("/bt")) {
                this.region = "Bhutan";
            } else if (url.endsWith(".bw") || url.endsWith("/bw")) {
                this.region = "Botswana";
            } else if (url.endsWith(".io") || url.endsWith("/io")) {
                this.region = "British Indian Ocean Territory";
            } else if (url.endsWith(".bf") || url.endsWith("/bf")) {
                this.region = "Burkina Faso";
            } else if (url.endsWith(".bh") || url.endsWith("/bh")) {
                this.region = "Bahrain";
            } else if (url.endsWith(".by") || url.endsWith("/by")) {
                this.region = "Belarus";
            } else if (url.endsWith(".bj") || url.endsWith("/bj")) {
                this.region = "Benin";
            } else if (url.endsWith(".bo") || url.endsWith("/bo")) {
                this.region = "Bolivia";
            } else if (url.endsWith(".bv") || url.endsWith("/bv")) {
                this.region = "Bouvet Island";
            } else if (url.endsWith(".bn") || url.endsWith("/bn")) {
                this.region = "Brunei Darussalam";
            } else if (url.endsWith(".bi") || url.endsWith("/bi")) {
                this.region = "Burundi";
            } else if (url.endsWith(".bd") || url.endsWith("/bd")) {
                this.region = "Bangladesh";
            } else if (url.endsWith(".be") || url.endsWith("/be")) {
                this.region = "Belgium";
            } else if (url.endsWith(".bm") || url.endsWith("/bm")) {
                this.region = "Bermuda";
            } else if (url.endsWith(".ba") || url.endsWith("/ba")) {
                this.region = "Bosnia Hercegovina";
            } else if (url.endsWith(".br") || url.endsWith("/br")) {
                this.region = "Brazil";
            } else if (url.endsWith(".bg") || url.endsWith("/bg")) {
                this.region = "Bulgaria";
            } else if (url.endsWith(".by") || url.endsWith("/by")) {
                this.region = "Byelorussia";
            } else if (url.endsWith(".kh") || url.endsWith("/kh")) {
                this.region = "Cambodia";
            } else if (url.endsWith(".cv") || url.endsWith("/cv")) {
                this.region = "Cape Verde";
            } else if (url.endsWith(".td") || url.endsWith("/td")) {
                this.region = "Chad";
            } else if (url.endsWith(".cx") || url.endsWith("/cx")) {
                this.region = "Christmas Island";
            } else if (url.endsWith(".km") || url.endsWith("/km")) {
                this.region = "Comoros";
            } else if (url.endsWith(".cr") || url.endsWith("/cr")) {
                this.region = "Costa Rica";
            } else if (url.endsWith(".cy") || url.endsWith("/cy")) {
                this.region = "Cyprus";
            } else if (url.endsWith(".cm") || url.endsWith("/cm")) {
                this.region = "Cameroon";
            } else if (url.endsWith(".ky") || url.endsWith("/ky")) {
                this.region = "Cayman Islands";
            } else if (url.endsWith(".cl") || url.endsWith("/cl")) {
                this.region = "Chile";
            } else if (url.endsWith(".cc") || url.endsWith("/cc")) {
                this.region = "Cocos Islands";
            } else if (url.endsWith(".cg") || url.endsWith("/cg")) {
                this.region = "Congo";
            } else if (url.endsWith(".hr") || url.endsWith("/hr")) {
                this.region = "Croatia";
            } else if (url.endsWith(".cs") || url.endsWith("/cs")) {
                this.region = "Czechoslovakia";
            } else if (url.endsWith(".ca") || url.endsWith("/ca")) {
                this.region = "Canada";
            } else if (url.endsWith(".cf") || url.endsWith("/cf")) {
                this.region = "Central African Republic";
            } else if (url.endsWith(".cn") || url.endsWith("/cn")) {
                this.region = "China";
            } else if (url.endsWith(".co") || url.endsWith("/co")) {
                this.region = "Colombia";
            } else if (url.endsWith(".ck") || url.endsWith("/ck")) {
                this.region = "Cook Islands";
            } else if (url.endsWith(".cu") || url.endsWith("/cu")) {
                this.region = "Cuba";
            } else if (url.endsWith(".dk") || url.endsWith("/dk")) {
                this.region = "Denmark";
            } else if (url.endsWith(".do") || url.endsWith("/do")) {
                this.region = "Dominican Republic";
            } else if (url.endsWith(".dj") || url.endsWith("/dj")) {
                this.region = "Djibouti";
            } else if (url.endsWith(".dm") || url.endsWith("/dm")) {
                this.region = "Dominica";
            } else if (url.endsWith(".tp") || url.endsWith("/tp")) {
                this.region = "East Timor";
            } else if (url.endsWith(".sv") || url.endsWith("/sv")) {
                this.region = "El Salvador";
            } else if (url.endsWith(".et") || url.endsWith("/et")) {
                this.region = "Ethiopia";
            } else if (url.endsWith(".ec") || url.endsWith("/ec")) {
                this.region = "Ecuador";
            } else if (url.endsWith(".gq") || url.endsWith("/gq")) {
                this.region = "Equatorial Guinea";
            } else if (url.endsWith(".eg") || url.endsWith("/eg")) {
                this.region = "Egypt";
            } else if (url.endsWith(".ee") || url.endsWith("/ee")) {
                this.region = "Estonia";
            } else if (url.endsWith(".fk") || url.endsWith("/fk")) {
                this.region = "Falkland Islands";
            } else if (url.endsWith(".fi") || url.endsWith("/fi")) {
                this.region = "Finland";
            } else if (url.endsWith(".pf") || url.endsWith("/pf")) {
                this.region = "French Polynesia";
            } else if (url.endsWith(".fo") || url.endsWith("/fo")) {
                this.region = "Faroe Islands";
            } else if (url.endsWith(".fr") || url.endsWith("/fr")) {
                this.region = "France";
            } else if (url.endsWith(".tf") || url.endsWith("/tf")) {
                this.region = "French Southern Territories";
            } else if (url.endsWith(".fj") || url.endsWith("/fj")) {
                this.region = "Fiji";
            } else if (url.endsWith(".gf") || url.endsWith("/gf")) {
                this.region = "French Guiana";
            } else if (url.endsWith(".ga") || url.endsWith("/ga")) {
                this.region = "Gabon";
            } else if (url.endsWith(".de") || url.endsWith("/de")) {
                this.region = "Germany";
            } else if (url.endsWith(".gr") || url.endsWith("/gr")) {
                this.region = "Greece";
            } else if (url.endsWith(".gp") || url.endsWith("/gp")) {
                this.region = "Guadeloupe";
            } else if (url.endsWith(".gn") || url.endsWith("/gn")) {
                this.region = "Guinea";
            } else if (url.endsWith(".gm") || url.endsWith("/gm")) {
                this.region = "Gambia";
            } else if (url.endsWith(".gh") || url.endsWith("/gh")) {
                this.region = "Ghana";
            } else if (url.endsWith(".gl") || url.endsWith("/gl")) {
                this.region = "Greenland";
            } else if (url.endsWith(".gu") || url.endsWith("/gu")) {
                this.region = "Guam";
            } else if (url.endsWith(".gw") || url.endsWith("/gw")) {
                this.region = "Guinea-bissau";
            } else if (url.endsWith(".ge") || url.endsWith("/ge")) {
                this.region = "Georgia";
            } else if (url.endsWith(".gi") || url.endsWith("/gi")) {
                this.region = "Gibraltar";
            } else if (url.endsWith(".gd") || url.endsWith("/gd")) {
                this.region = "Grenada";
            } else if (url.endsWith(".gt") || url.endsWith("/gt")) {
                this.region = "Guatemala";
            } else if (url.endsWith(".gy") || url.endsWith("/gy")) {
                this.region = "Guyana";
            } else if (url.endsWith(".ht") || url.endsWith("/ht")) {
                this.region = "Haiti";
            } else if (url.endsWith(".hk") || url.endsWith("/hk")) {
                this.region = "Hong Kong";
            } else if (url.endsWith(".hm") || url.endsWith("/hm")) {
                this.region = "Heard and Mc Donald Islands";
            } else if (url.endsWith(".hu") || url.endsWith("/hu")) {
                this.region = "Hungary";
            } else if (url.endsWith(".hn") || url.endsWith("/hn")) {
                this.region = "Honduras";
            } else if (url.endsWith(".is") || url.endsWith("/is")) {
                this.region = "Iceland";
            } else if (url.endsWith(".ir") || url.endsWith("/ir")) {
                this.region = "Iran";
            } else if (url.endsWith(".il") || url.endsWith("/il")) {
                this.region = "Israel";
            } else if (url.endsWith(".in") || url.endsWith("/in")) {
                this.region = "India";
            } else if (url.endsWith(".iq") || url.endsWith("/iq")) {
                this.region = "Iraq";
            } else if (url.endsWith(".it") || url.endsWith("/it")) {
                this.region = "Italy";
            } else if (url.endsWith(".id") || url.endsWith("/id")) {
                this.region = "Indonesia";
            } else if (url.endsWith(".ie") || url.endsWith("/ie")) {
                this.region = "Ireland";
            } else if (url.endsWith(".ci") || url.endsWith("/ci")) {
                this.region = "Ivory Coast";
            } else if (url.endsWith(".jm") || url.endsWith("/jm")) {
                this.region = "Jamaica";
            } else if (url.endsWith(".jp") || url.endsWith("/jp")) {
                this.region = "Japan";
            } else if (url.endsWith(".jo") || url.endsWith("/jo")) {
                this.region = "Jordan";
            } else if (url.endsWith(".kz") || url.endsWith("/kz")) {
                this.region = "Kazakhstan";
            } else if (url.endsWith(".kw") || url.endsWith("/kw")) {
                this.region = "Kuwait";
            } else if (url.endsWith(".ke") || url.endsWith("/ke")) {
                this.region = "Kenya";
            } else if (url.endsWith(".kg") || url.endsWith("/kg")) {
                this.region = "Kyrgyzstan";
            } else if (url.endsWith(".ki") || url.endsWith("/ki")) {
                this.region = "Kiribati";
            } else if (url.endsWith(".la") || url.endsWith("/la")) {
                this.region = "Laos";
            } else if (url.endsWith(".ls") || url.endsWith("/ls")) {
                this.region = "Lesotho";
            } else if (url.endsWith(".li") || url.endsWith("/li")) {
                this.region = "Lichtenstein";
            } else if (url.endsWith(".lv") || url.endsWith("/lv")) {
                this.region = "Latvia";
            } else if (url.endsWith(".lr") || url.endsWith("/lr")) {
                this.region = "Liberia";
            } else if (url.endsWith(".lt") || url.endsWith("/lt")) {
                this.region = "Lithuania";
            } else if (url.endsWith(".lb") || url.endsWith("/lb")) {
                this.region = "Lebanon";
            } else if (url.endsWith(".ly") || url.endsWith("/ly")) {
                this.region = "Libya";
            } else if (url.endsWith(".lu") || url.endsWith("/lu")) {
                this.region = "Luxembourg";
            } else if (url.endsWith(".mo") || url.endsWith("/mo")) {
                this.region = "Macau";
            } else if (url.endsWith(".my") || url.endsWith("/my")) {
                this.region = "Malaysia";
            } else if (url.endsWith(".mt") || url.endsWith("/mt")) {
                this.region = "Malta";
            } else if (url.endsWith(".mr") || url.endsWith("/mr")) {
                this.region = "Mauritania";
            } else if (url.endsWith(".fm") || url.endsWith("/fm")) {
                this.region = "Micronesia";
            } else if (url.endsWith(".mn") || url.endsWith("/mn")) {
                this.region = "Mongolia";
            } else if (url.endsWith(".mz") || url.endsWith("/mz")) {
                this.region = "Mozambique";
            } else if (url.endsWith(".mg") || url.endsWith("/mg")) {
                this.region = "Madagascar";
            } else if (url.endsWith(".mv") || url.endsWith("/mv")) {
                this.region = "Maldives";
            } else if (url.endsWith(".mh") || url.endsWith("/mh")) {
                this.region = "Marshall Islands";
            } else if (url.endsWith(".mu") || url.endsWith("/mu")) {
                this.region = "Mauritius";
            } else if (url.endsWith(".md") || url.endsWith("/md")) {
                this.region = "Moldova Republic";
            } else if (url.endsWith(".ms") || url.endsWith("/ms")) {
                this.region = "Montserrat";
            } else if (url.endsWith(".mm") || url.endsWith("/mm")) {
                this.region = "Myanmar";
            } else if (url.endsWith(".mw") || url.endsWith("/mw")) {
                this.region = "Malawi";
            } else if (url.endsWith(".ml") || url.endsWith("/ml")) {
                this.region = "Mali";
            } else if (url.endsWith(".mq") || url.endsWith("/mq")) {
                this.region = "Martinique";
            } else if (url.endsWith(".mx") || url.endsWith("/mx")) {
                this.region = "Mexico";
            } else if (url.endsWith(".mc") || url.endsWith("/mc")) {
                this.region = "Monaco";
            } else if (url.endsWith(".ma") || url.endsWith("/ma")) {
                this.region = "Morocco";
            } else if (url.endsWith(".na") || url.endsWith("/na")) {
                this.region = "Namibia";
            } else if (url.endsWith(".nl") || url.endsWith("/nl")) {
                this.region = "Netherlands";
            } else if (url.endsWith(".nc") || url.endsWith("/nc")) {
                this.region = "New Caledonia";
            } else if (url.endsWith(".ne") || url.endsWith("/ne")) {
                this.region = "Niger";
            } else if (url.endsWith(".nf") || url.endsWith("/nf")) {
                this.region = "Norfolk Island";
            } else if (url.endsWith(".no") || url.endsWith("/no")) {
                this.region = "Norway";
            } else if (url.endsWith(".nr") || url.endsWith("/nr")) {
                this.region = "Nauru";
            } else if (url.endsWith(".an") || url.endsWith("/an")) {
                this.region = "Netherlands Antilles";
            } else if (url.endsWith(".nz") || url.endsWith("/nz")) {
                this.region = "New Zealand";
            } else if (url.endsWith(".ng") || url.endsWith("/ng")) {
                this.region = "Nigeria";
            } else if (url.endsWith(".kp") || url.endsWith("/kp")) {
                this.region = "North Korea";
            } else if (url.endsWith(".np") || url.endsWith("/np")) {
                this.region = "Nepal";
            } else if (url.endsWith(".nt") || url.endsWith("/nt")) {
                this.region = "Neutral Zone";
            } else if (url.endsWith(".ni") || url.endsWith("/ni")) {
                this.region = "Nicaragua";
            } else if (url.endsWith(".nu") || url.endsWith("/nu")) {
                this.region = "Niue";
            } else if (url.endsWith(".mp") || url.endsWith("/mp")) {
                this.region = "Northern Mariana Islands";
            } else if (url.endsWith(".om") || url.endsWith("/om")) {
                this.region = "Oman";
            } else if (url.endsWith(".pk") || url.endsWith("/pk")) {
                this.region = "Pakistan";
            } else if (url.endsWith(".pg") || url.endsWith("/pg")) {
                this.region = "Papua New Guinea";
            } else if (url.endsWith(".ph") || url.endsWith("/ph")) {
                this.region = "Philippines";
            } else if (url.endsWith(".pt") || url.endsWith("/pt")) {
                this.region = "Portugal";
            } else if (url.endsWith(".pw") || url.endsWith("/pw")) {
                this.region = "Palau";
            } else if (url.endsWith(".py") || url.endsWith("/py")) {
                this.region = "Paraguay";
            } else if (url.endsWith(".pn") || url.endsWith("/pn")) {
                this.region = "Pitcairn";
            } else if (url.endsWith(".pr") || url.endsWith("/pr")) {
                this.region = "Puerto Rico";
            } else if (url.endsWith(".pa") || url.endsWith("/pa")) {
                this.region = "Panama";
            } else if (url.endsWith(".pe") || url.endsWith("/pe")) {
                this.region = "Peru";
            } else if (url.endsWith(".pl") || url.endsWith("/pl")) {
                this.region = "Poland";
            } else if (url.endsWith(".qa") || url.endsWith("/qa")) {
                this.region = "Qatar";
            } else if (url.endsWith(".kn") || url.endsWith("/kn")) {
                this.region = "Saint Kitts and Nevis";
            } else if (url.endsWith(".ws") || url.endsWith("/ws")) {
                this.region = "Samoa";
            } else if (url.endsWith(".sa") || url.endsWith("/sa")) {
                this.region = "Saudi Arabia";
            } else if (url.endsWith(".sl") || url.endsWith("/sl")) {
                this.region = "Sierra Leone";
            } else if (url.endsWith(".sb") || url.endsWith("/sb")) {
                this.region = "Solomon Islands";
            } else if (url.endsWith(".kr") || url.endsWith("/kr")) {
                this.region = "South Korea";
            } else if (url.endsWith(".sh") || url.endsWith("/sh")) {
                this.region = "St. Helena";
            } else if (url.endsWith(".sr") || url.endsWith("/sr")) {
                this.region = "Suriname";
            } else if (url.endsWith(".se") || url.endsWith("/se")) {
                this.region = "Sweden";
            } else if (url.endsWith(".lc") || url.endsWith("/lc")) {
                this.region = "Saint Lucia";
            } else if (url.endsWith(".sm") || url.endsWith("/sm")) {
                this.region = "San Marino";
            } else if (url.endsWith(".sn") || url.endsWith("/sn")) {
                this.region = "Senegal";
            } else if (url.endsWith(".sg") || url.endsWith("/sg")) {
                this.region = "Singapore";
            } else if (url.endsWith(".so") || url.endsWith("/so")) {
                this.region = "Somalia";
            } else if (url.endsWith(".es") || url.endsWith("/es")) {
                this.region = "Spain";
            } else if (url.endsWith(".pm") || url.endsWith("/pm")) {
                this.region = "St. Pierre and Miquelon";
            } else if (url.endsWith(".sj") || url.endsWith("/sj")) {
                this.region = "Svalbard and Jan Mayen Islands";
            } else if (url.endsWith(".ch") || url.endsWith("/ch")) {
                this.region = "Switzerland";
            } else if (url.endsWith(".vc") || url.endsWith("/vc")) {
                this.region = "Saint Vincent, Grenadines";
            } else if (url.endsWith(".st") || url.endsWith("/st")) {
                this.region = "Sao Tome and Principe";
            } else if (url.endsWith(".sc") || url.endsWith("/sc")) {
                this.region = "Seychelles";
            } else if (url.endsWith(".si") || url.endsWith("/si")) {
                this.region = "Slovenia";
            } else if (url.endsWith(".za") || url.endsWith("/za")) {
                this.region = "South Africa";
            } else if (url.endsWith(".lk") || url.endsWith("/lk")) {
                this.region = "Sri Lanka";
            } else if (url.endsWith(".sd") || url.endsWith("/sd")) {
                this.region = "Sudan";
            } else if (url.endsWith(".sz") || url.endsWith("/sz")) {
                this.region = "Swaziland";
            } else if (url.endsWith(".sy") || url.endsWith("/sy")) {
                this.region = "Syria";
            } else if (url.endsWith(".tw") || url.endsWith("/tw")) {
                this.region = "Taiwan";
            } else if (url.endsWith(".th") || url.endsWith("/th")) {
                this.region = "Thailand";
            } else if (url.endsWith(".to") || url.endsWith("/to")) {
                this.region = "Tonga";
            } else if (url.endsWith(".tr") || url.endsWith("/tr")) {
                this.region = "Turkey";
            } else if (url.endsWith(".tv") || url.endsWith("/tv")) {
                this.region = "Tuvalu";
            } else if (url.endsWith(".tj") || url.endsWith("/tj")) {
                this.region = "Tajikistan";
            } else if (url.endsWith(".tg") || url.endsWith("/tg")) {
                this.region = "Togo";
            } else if (url.endsWith(".tt") || url.endsWith("/tt")) {
                this.region = "Trinidad, Tobago";
            } else if (url.endsWith(".tm") || url.endsWith("/tm")) {
                this.region = "Turkmenistan";
            } else if (url.endsWith(".tz") || url.endsWith("/tz")) {
                this.region = "Tanzania";
            } else if (url.endsWith(".tk") || url.endsWith("/tk")) {
                this.region = "Tokelau";
            } else if (url.endsWith(".tn") || url.endsWith("/tn")) {
                this.region = "Tunisia";
            } else if (url.endsWith(".tc") || url.endsWith("/tc")) {
                this.region = "Turks and Caicos Islands";
            } else if (url.endsWith(".ug") || url.endsWith("/ug")) {
                this.region = "Uganda";
            } else if (url.endsWith(".uk") || url.endsWith("/uk")) {
                this.region = "United Kingdom";
            } else if (url.endsWith(".uy") || url.endsWith("/uy")) {
                this.region = "Uruguay";
            } else if (url.endsWith(".ua") || url.endsWith("/ua")) {
                this.region = "Ukraine";
            } else if (url.endsWith(".us") || url.endsWith("/us")) {
                this.region = "United States";
            } else if (url.endsWith(".uz") || url.endsWith("/uz")) {
                this.region = "Uzbekistan";
            } else if (url.endsWith(".ae") || url.endsWith("/ae")) {
                this.region = "United Arab Emirates";
            } else if (url.endsWith(".um") || url.endsWith("/um")) {
                this.region = "United States Minor Islands";
            } else if (url.endsWith(".vu") || url.endsWith("/vu")) {
                this.region = "Vanuatu";
            } else if (url.endsWith(".vn") || url.endsWith("/vn")) {
                this.region = "Viet Nam";
            } else if (url.endsWith(".va") || url.endsWith("/va")) {
                this.region = "Vatican City";
            } else if (url.endsWith(".vg") || url.endsWith("/vg")) {
                this.region = "Virgin Islands (British)";
            } else if (url.endsWith(".ve") || url.endsWith("/ve")) {
                this.region = "Venezuela";
            } else if (url.endsWith(".vi") || url.endsWith("/vi")) {
                this.region = "Virgin Islands (U.S.)";
            } else if (url.endsWith(".wf") || url.endsWith("/wf")) {
                this.region = "Wallis and Futuna Islands";
            } else if (url.endsWith(".eh") || url.endsWith("/eh")) {
                this.region = "Western Sahara";
            } else if (url.endsWith(".ye") || url.endsWith("/ye")) {
                this.region = "Yemen";
            } else if (url.endsWith(".yu") || url.endsWith("/yu")) {
                this.region = "Yugoslavia";
            } else if (url.endsWith(".zr") || url.endsWith("/zr")) {
                this.region = "Zaire";
            } else if (url.endsWith(".zm") || url.endsWith("/zm")) {
                this.region = "Zambia";
            } else if (url.endsWith(".zw") || url.endsWith("/zw")) {
                this.region = "Zimbabwe";
            } else {
                this.region = "None";
            }

            this.date = new Date();
            this.date.setYear(2018);

            for (Element metaTag : parsedHtml.getElementsByTag("meta[itemprop=datePublished]")) {
                System.out.println("Brought date");

                try {
                    String string = metaTag.attr("datetime");
                    DateFormat format = new SimpleDateFormat("yyyy-mm-ddThh:mm:ssZ", Locale.ENGLISH);
                    Date date = format.parse(string);
                    this.date = date;
                } catch (Exception ignored) {
                    System.out.println("Failed");
                }
            }
            for (Element metaTag : parsedHtml.getElementsByTag("time[itemprop=datePublished]")) {
                System.out.println("Brought date");
                try {
                    String string = metaTag.attr("datetime");
                    DateFormat format = new SimpleDateFormat("yyyy-mm-ddThh:mm:ssZ", Locale.ENGLISH);
                    Date date = format.parse(string);
                    this.date = date;
                } catch (Exception ignored) {
                    System.out.println("Failed");
                }
            }
            for (Element metaTag : parsedHtml.getElementsByTag("meta[itemprop=pubdate]")) {
                System.out.println("Brought date");

                try {
                    String string = metaTag.attr("datetime");
                    DateFormat format = new SimpleDateFormat("yyyy-mm-ddThh:mm:ssZ", Locale.ENGLISH);
                    Date date = format.parse(string);
                    this.date = date;
                } catch (Exception ignored) {
                    System.out.println("Failed");
                }
            }
            for (Element metaTag : parsedHtml.getElementsByTag("time[itemprop=pubdate]")) {
                System.out.println("Brought date");
                try {
                    String string = metaTag.attr("datetime");
                    DateFormat format = new SimpleDateFormat("yyyy-mm-ddThh:mm:ssZ", Locale.ENGLISH);
                    Date date = format.parse(string);
                    this.date = date;
                } catch (Exception ignored) {
                    System.out.println("Failed");
                }
            }


            // Extract title
            this.title = parsedHtml.title();
            String alt;
            String src;
            String lang = parsedHtml.getElementsByTag("html").attr("lang");

            // Extracting Images
            for (Element metaTag : parsedHtml.getElementsByTag("img")) {
                alt = metaTag.attr("alt");
                src = metaTag.attr("src");
                if (!src.replaceAll("\\s+", "").equals("")) {
                    if (alt.replaceAll("\\s+", "").equals("")) {
                        alt = parsedHtml.title();
                    }
                    ImageContainer imageContainer = new ImageContainer(alt, src);
                    imgList.add(imageContainer);
                }
            }

            // Extract headers and add title and url
            String headerString = "";
            this.htmlElements.add(new HTMLElement(this.url, "url"));
            this.htmlElements.add(new HTMLElement(parsedHtml.title(), "title"));
            this.text += parsedHtml.title() + " ";

            for (Element header : parsedHtml.getElementsByTag("h1")) {
                headerString += header.text();
                this.text += header.text() + " ";
            }
            for (Element header : parsedHtml.getElementsByTag("h2")) {
                headerString += header.text();
                this.text += header.text() + " ";
            }
            for (Element header : parsedHtml.getElementsByTag("h3")) {
                headerString += header.text();
                this.text += header.text() + " ";
            }
            for (Element header : parsedHtml.getElementsByTag("h4")) {
                headerString += header.text();
                this.text += header.text() + " ";
            }
            for (Element header : parsedHtml.getElementsByTag("h5")) {
                headerString += header.text();
                this.text += header.text() + " ";
            }
            for (Element header : parsedHtml.getElementsByTag("h6")) {
                headerString += header.text();
                this.text += header.text() + " ";
            }
            for (Element header : parsedHtml.getElementsByTag("th")) {
                headerString += header.text();
                this.text += header.text() + " ";
            }
            this.htmlElements.add(new HTMLElement(headerString, "header"));
            // Extract rest of the site
            for (Element header : parsedHtml.getElementsByTag("p")) {
                this.htmlElements.add(new HTMLElement(header.text(), "paragraph"));
                this.text += header.text() + " ";
            }
            for (Element header : parsedHtml.getElementsByTag("b")) {
                this.htmlElements.add(new HTMLElement(header.text(), "bold"));
                this.text += header.text() + " ";
            }
            for (Element header : parsedHtml.getElementsByTag("i")) {
                this.htmlElements.add(new HTMLElement(header.text(), "italic"));
                this.text += header.text() + " ";
            }
            for (Element header : parsedHtml.getElementsByTag("small")) {
                this.htmlElements.add(new HTMLElement(header.text(), "small"));
                this.text += header.text() + " ";
            }
            for (Element header : parsedHtml.getElementsByTag("ol")) {
                this.htmlElements.add(new HTMLElement(header.text(), "ordered_list"));
                this.text += header.text() + " ";
            }
            for (Element header : parsedHtml.getElementsByTag("ul")) {
                this.htmlElements.add(new HTMLElement(header.text(), "unordered_list"));
                this.text += header.text() + " ";
            }
            for (Element header : parsedHtml.getElementsByTag("td")) {
                this.htmlElements.add(new HTMLElement(header.text(), "table_column"));
                this.text += header.text() + " ";
            }
            for (Element header : parsedHtml.getElementsByTag("tr")) {
                this.htmlElements.add(new HTMLElement(header.text(), "table_row"));
                this.text += header.text() + " ";
            }

            this.wordsCount = this.text.split("\\s+").length;

            LanguageDetector detector = new OptimaizeLangDetector().loadModels();
            LanguageResult result = detector.detect(this.text);

            if (!result.getLanguage().equals("en") || this.wordsCount < 100 || !lang.equals("en")) {
                this.parsedHtml = null;
            }


        } catch (Exception ignored) {

        }

    }

    // Setters & Getters

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

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
    public static String HTMLToString(String path) {
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
