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

            if (url.contains(".af.") || url.contains(".af/") || url.contains("/af/") || url.contains("/.af.") || url.contains("/af.") || url.endsWith("/.af") || url.endsWith("/af")) {
                this.region = "Afghanistan";
            } else if (url.contains(".as.") || url.contains(".as/") || url.contains("/as/") || url.contains("/.as.") || url.contains("/as.") || url.endsWith("/.as") || url.endsWith("/as")) {
                this.region = "American Samoa";
            } else if (url.contains(".ai.") || url.contains(".ai/") || url.contains("/ai/") || url.contains("/.ai.") || url.contains("/ai.") || url.endsWith("/.ai") || url.endsWith("/ai")) {
                this.region = "Anguilla";
            } else if (url.contains(".ar.") || url.contains(".ar/") || url.contains("/ar/") || url.contains("/.ar.") || url.contains("/ar.") || url.endsWith("/.ar") || url.endsWith("/ar")) {
                this.region = "Argentina";
            } else if (url.contains(".au.") || url.contains(".au/") || url.contains("/au/") || url.contains("/.au.") || url.contains("/au.") || url.endsWith("/.au") || url.endsWith("/au")) {
                this.region = "Australia";
            } else if (url.contains(".al.") || url.contains(".al/") || url.contains("/al/") || url.contains("/.al.") || url.contains("/al.") || url.endsWith("/.al") || url.endsWith("/al")) {
                this.region = "Albania";
            } else if (url.contains(".ad.") || url.contains(".ad/") || url.contains("/ad/") || url.contains("/.ad.") || url.contains("/ad.") || url.endsWith("/.ad") || url.endsWith("/ad")) {
                this.region = "Andorra";
            } else if (url.contains(".aq.") || url.contains(".aq/") || url.contains("/aq/") || url.contains("/.aq.") || url.contains("/aq.") || url.endsWith("/.aq") || url.endsWith("/aq")) {
                this.region = "Antarctica";
            } else if (url.contains(".am.") || url.contains(".am/") || url.contains("/am/") || url.contains("/.am.") || url.contains("/am.") || url.endsWith("/.am") || url.endsWith("/am")) {
                this.region = "Armenia";
            } else if (url.contains(".at.") || url.contains(".at/") || url.contains("/at/") || url.contains("/.at.") || url.contains("/at.") || url.endsWith("/.at") || url.endsWith("/at")) {
                this.region = "Austria";
            } else if (url.contains(".dz.") || url.contains(".dz/") || url.contains("/dz/") || url.contains("/.dz.") || url.contains("/dz.") || url.endsWith("/.dz") || url.endsWith("/dz")) {
                this.region = "Algeria";
            } else if (url.contains(".ao.") || url.contains(".ao/") || url.contains("/ao/") || url.contains("/.ao.") || url.contains("/ao.") || url.endsWith("/.ao") || url.endsWith("/ao")) {
                this.region = "Angola";
            } else if (url.contains(".ag.") || url.contains(".ag/") || url.contains("/ag/") || url.contains("/.ag.") || url.contains("/ag.") || url.endsWith("/.ag") || url.endsWith("/ag")) {
                this.region = "Antigua and Barbuda";
            } else if (url.contains(".aw.") || url.contains(".aw/") || url.contains("/aw/") || url.contains("/.aw.") || url.contains("/aw.") || url.endsWith("/.aw") || url.endsWith("/aw")) {
                this.region = "Aruba";
            } else if (url.contains(".az.") || url.contains(".az/") || url.contains("/az/") || url.contains("/.az.") || url.contains("/az.") || url.endsWith("/.az") || url.endsWith("/az")) {
                this.region = "Azerbaijan";
            } else if (url.contains(".bs.") || url.contains(".bs/") || url.contains("/bs/") || url.contains("/.bs.") || url.contains("/bs.") || url.endsWith("/.bs") || url.endsWith("/bs")) {
                this.region = "Bahamas";
            } else if (url.contains(".bb.") || url.contains(".bb/") || url.contains("/bb/") || url.contains("/.bb.") || url.contains("/bb.") || url.endsWith("/.bb") || url.endsWith("/bb")) {
                this.region = "Barbados";
            } else if (url.contains(".bz.") || url.contains(".bz/") || url.contains("/bz/") || url.contains("/.bz.") || url.contains("/bz.") || url.endsWith("/.bz") || url.endsWith("/bz")) {
                this.region = "Belize";
            } else if (url.contains(".bt.") || url.contains(".bt/") || url.contains("/bt/") || url.contains("/.bt.") || url.contains("/bt.") || url.endsWith("/.bt") || url.endsWith("/bt")) {
                this.region = "Bhutan";
            } else if (url.contains(".bw.") || url.contains(".bw/") || url.contains("/bw/") || url.contains("/.bw.") || url.contains("/bw.") || url.endsWith("/.bw") || url.endsWith("/bw")) {
                this.region = "Botswana";
            } else if (url.contains(".io.") || url.contains(".io/") || url.contains("/io/") || url.contains("/.io.") || url.contains("/io.") || url.endsWith("/.io") || url.endsWith("/io")) {
                this.region = "British Indian Ocean Territory";
            } else if (url.contains(".bf.") || url.contains(".bf/") || url.contains("/bf/") || url.contains("/.bf.") || url.contains("/bf.") || url.endsWith("/.bf") || url.endsWith("/bf")) {
                this.region = "Burkina Faso";
            } else if (url.contains(".bh.") || url.contains(".bh/") || url.contains("/bh/") || url.contains("/.bh.") || url.contains("/bh.") || url.endsWith("/.bh") || url.endsWith("/bh")) {
                this.region = "Bahrain";
            } else if (url.contains(".by.") || url.contains(".by/") || url.contains("/by/") || url.contains("/.by.") || url.contains("/by.") || url.endsWith("/.by") || url.endsWith("/by")) {
                this.region = "Belarus";
            } else if (url.contains(".bj.") || url.contains(".bj/") || url.contains("/bj/") || url.contains("/.bj.") || url.contains("/bj.") || url.endsWith("/.bj") || url.endsWith("/bj")) {
                this.region = "Benin";
            } else if (url.contains(".bo.") || url.contains(".bo/") || url.contains("/bo/") || url.contains("/.bo.") || url.contains("/bo.") || url.endsWith("/.bo") || url.endsWith("/bo")) {
                this.region = "Bolivia";
            } else if (url.contains(".bv.") || url.contains(".bv/") || url.contains("/bv/") || url.contains("/.bv.") || url.contains("/bv.") || url.endsWith("/.bv") || url.endsWith("/bv")) {
                this.region = "Bouvet Island";
            } else if (url.contains(".bn.") || url.contains(".bn/") || url.contains("/bn/") || url.contains("/.bn.") || url.contains("/bn.") || url.endsWith("/.bn") || url.endsWith("/bn")) {
                this.region = "Brunei Darussalam";
            } else if (url.contains(".bi.") || url.contains(".bi/") || url.contains("/bi/") || url.contains("/.bi.") || url.contains("/bi.") || url.endsWith("/.bi") || url.endsWith("/bi")) {
                this.region = "Burundi";
            } else if (url.contains(".bd.") || url.contains(".bd/") || url.contains("/bd/") || url.contains("/.bd.") || url.contains("/bd.") || url.endsWith("/.bd") || url.endsWith("/bd")) {
                this.region = "Bangladesh";
            } else if (url.contains(".be.") || url.contains(".be/") || url.contains("/be/") || url.contains("/.be.") || url.contains("/be.") || url.endsWith("/.be") || url.endsWith("/be")) {
                this.region = "Belgium";
            } else if (url.contains(".bm.") || url.contains(".bm/") || url.contains("/bm/") || url.contains("/.bm.") || url.contains("/bm.") || url.endsWith("/.bm") || url.endsWith("/bm")) {
                this.region = "Bermuda";
            } else if (url.contains(".ba.") || url.contains(".ba/") || url.contains("/ba/") || url.contains("/.ba.") || url.contains("/ba.") || url.endsWith("/.ba") || url.endsWith("/ba")) {
                this.region = "Bosnia Hercegovina";
            } else if (url.contains(".br.") || url.contains(".br/") || url.contains("/br/") || url.contains("/.br.") || url.contains("/br.") || url.endsWith("/.br") || url.endsWith("/br")) {
                this.region = "Brazil";
            } else if (url.contains(".bg.") || url.contains(".bg/") || url.contains("/bg/") || url.contains("/.bg.") || url.contains("/bg.") || url.endsWith("/.bg") || url.endsWith("/bg")) {
                this.region = "Bulgaria";
            } else if (url.contains(".by.") || url.contains(".by/") || url.contains("/by/") || url.contains("/.by.") || url.contains("/by.") || url.endsWith("/.by") || url.endsWith("/by")) {
                this.region = "Byelorussia";
            } else if (url.contains(".kh.") || url.contains(".kh/") || url.contains("/kh/") || url.contains("/.kh.") || url.contains("/kh.") || url.endsWith("/.kh") || url.endsWith("/kh")) {
                this.region = "Cambodia";
            } else if (url.contains(".cv.") || url.contains(".cv/") || url.contains("/cv/") || url.contains("/.cv.") || url.contains("/cv.") || url.endsWith("/.cv") || url.endsWith("/cv")) {
                this.region = "Cape Verde";
            } else if (url.contains(".td.") || url.contains(".td/") || url.contains("/td/") || url.contains("/.td.") || url.contains("/td.") || url.endsWith("/.td") || url.endsWith("/td")) {
                this.region = "Chad";
            } else if (url.contains(".cx.") || url.contains(".cx/") || url.contains("/cx/") || url.contains("/.cx.") || url.contains("/cx.") || url.endsWith("/.cx") || url.endsWith("/cx")) {
                this.region = "Christmas Island";
            } else if (url.contains(".km.") || url.contains(".km/") || url.contains("/km/") || url.contains("/.km.") || url.contains("/km.") || url.endsWith("/.km") || url.endsWith("/km")) {
                this.region = "Comoros";
            } else if (url.contains(".cr.") || url.contains(".cr/") || url.contains("/cr/") || url.contains("/.cr.") || url.contains("/cr.") || url.endsWith("/.cr") || url.endsWith("/cr")) {
                this.region = "Costa Rica";
            } else if (url.contains(".cy.") || url.contains(".cy/") || url.contains("/cy/") || url.contains("/.cy.") || url.contains("/cy.") || url.endsWith("/.cy") || url.endsWith("/cy")) {
                this.region = "Cyprus";
            } else if (url.contains(".cm.") || url.contains(".cm/") || url.contains("/cm/") || url.contains("/.cm.") || url.contains("/cm.") || url.endsWith("/.cm") || url.endsWith("/cm")) {
                this.region = "Cameroon";
            } else if (url.contains(".ky.") || url.contains(".ky/") || url.contains("/ky/") || url.contains("/.ky.") || url.contains("/ky.") || url.endsWith("/.ky") || url.endsWith("/ky")) {
                this.region = "Cayman Islands";
            } else if (url.contains(".cl.") || url.contains(".cl/") || url.contains("/cl/") || url.contains("/.cl.") || url.contains("/cl.") || url.endsWith("/.cl") || url.endsWith("/cl")) {
                this.region = "Chile";
            } else if (url.contains(".cc.") || url.contains(".cc/") || url.contains("/cc/") || url.contains("/.cc.") || url.contains("/cc.") || url.endsWith("/.cc") || url.endsWith("/cc")) {
                this.region = "Cocos Islands";
            } else if (url.contains(".cg.") || url.contains(".cg/") || url.contains("/cg/") || url.contains("/.cg.") || url.contains("/cg.") || url.endsWith("/.cg") || url.endsWith("/cg")) {
                this.region = "Congo";
            } else if (url.contains(".hr.") || url.contains(".hr/") || url.contains("/hr/") || url.contains("/.hr.") || url.contains("/hr.") || url.endsWith("/.hr") || url.endsWith("/hr")) {
                this.region = "Croatia";
            } else if (url.contains(".cs.") || url.contains(".cs/") || url.contains("/cs/") || url.contains("/.cs.") || url.contains("/cs.") || url.endsWith("/.cs") || url.endsWith("/cs")) {
                this.region = "Czechoslovakia";
            } else if (url.contains(".ca.") || url.contains(".ca/") || url.contains("/ca/") || url.contains("/.ca.") || url.contains("/ca.") || url.endsWith("/.ca") || url.endsWith("/ca")) {
                this.region = "Canada";
            } else if (url.contains(".cf.") || url.contains(".cf/") || url.contains("/cf/") || url.contains("/.cf.") || url.contains("/cf.") || url.endsWith("/.cf") || url.endsWith("/cf")) {
                this.region = "Central African Republic";
            } else if (url.contains(".cn.") || url.contains(".cn/") || url.contains("/cn/") || url.contains("/.cn.") || url.contains("/cn.") || url.endsWith("/.cn") || url.endsWith("/cn")) {
                this.region = "China";
            } else if (url.contains(".co.") || url.contains(".co/") || url.contains("/co/") || url.contains("/.co.") || url.contains("/co.") || url.endsWith("/.co") || url.endsWith("/co")) {
                this.region = "Colombia";
            } else if (url.contains(".ck.") || url.contains(".ck/") || url.contains("/ck/") || url.contains("/.ck.") || url.contains("/ck.") || url.endsWith("/.ck") || url.endsWith("/ck")) {
                this.region = "Cook Islands";
            } else if (url.contains(".cu.") || url.contains(".cu/") || url.contains("/cu/") || url.contains("/.cu.") || url.contains("/cu.") || url.endsWith("/.cu") || url.endsWith("/cu")) {
                this.region = "Cuba";
            } else if (url.contains(".dk.") || url.contains(".dk/") || url.contains("/dk/") || url.contains("/.dk.") || url.contains("/dk.") || url.endsWith("/.dk") || url.endsWith("/dk")) {
                this.region = "Denmark";
            } else if (url.contains(".do.") || url.contains(".do/") || url.contains("/do/") || url.contains("/.do.") || url.contains("/do.") || url.endsWith("/.do") || url.endsWith("/do")) {
                this.region = "Dominican Republic";
            } else if (url.contains(".dj.") || url.contains(".dj/") || url.contains("/dj/") || url.contains("/.dj.") || url.contains("/dj.") || url.endsWith("/.dj") || url.endsWith("/dj")) {
                this.region = "Djibouti";
            } else if (url.contains(".dm.") || url.contains(".dm/") || url.contains("/dm/") || url.contains("/.dm.") || url.contains("/dm.") || url.endsWith("/.dm") || url.endsWith("/dm")) {
                this.region = "Dominica";
            } else if (url.contains(".tp.") || url.contains(".tp/") || url.contains("/tp/") || url.contains("/.tp.") || url.contains("/tp.") || url.endsWith("/.tp") || url.endsWith("/tp")) {
                this.region = "East Timor";
            } else if (url.contains(".sv.") || url.contains(".sv/") || url.contains("/sv/") || url.contains("/.sv.") || url.contains("/sv.") || url.endsWith("/.sv") || url.endsWith("/sv")) {
                this.region = "El Salvador";
            } else if (url.contains(".et.") || url.contains(".et/") || url.contains("/et/") || url.contains("/.et.") || url.contains("/et.") || url.endsWith("/.et") || url.endsWith("/et")) {
                this.region = "Ethiopia";
            } else if (url.contains(".ec.") || url.contains(".ec/") || url.contains("/ec/") || url.contains("/.ec.") || url.contains("/ec.") || url.endsWith("/.ec") || url.endsWith("/ec")) {
                this.region = "Ecuador";
            } else if (url.contains(".gq.") || url.contains(".gq/") || url.contains("/gq/") || url.contains("/.gq.") || url.contains("/gq.") || url.endsWith("/.gq") || url.endsWith("/gq")) {
                this.region = "Equatorial Guinea";
            } else if (url.contains(".eg.") || url.contains(".eg/") || url.contains("/eg/") || url.contains("/.eg.") || url.contains("/eg.") || url.endsWith("/.eg") || url.endsWith("/eg")) {
                this.region = "Egypt";
            } else if (url.contains(".ee.") || url.contains(".ee/") || url.contains("/ee/") || url.contains("/.ee.") || url.contains("/ee.") || url.endsWith("/.ee") || url.endsWith("/ee")) {
                this.region = "Estonia";
            } else if (url.contains(".fk.") || url.contains(".fk/") || url.contains("/fk/") || url.contains("/.fk.") || url.contains("/fk.") || url.endsWith("/.fk") || url.endsWith("/fk")) {
                this.region = "Falkland Islands";
            } else if (url.contains(".fi.") || url.contains(".fi/") || url.contains("/fi/") || url.contains("/.fi.") || url.contains("/fi.") || url.endsWith("/.fi") || url.endsWith("/fi")) {
                this.region = "Finland";
            } else if (url.contains(".pf.") || url.contains(".pf/") || url.contains("/pf/") || url.contains("/.pf.") || url.contains("/pf.") || url.endsWith("/.pf") || url.endsWith("/pf")) {
                this.region = "French Polynesia";
            } else if (url.contains(".fo.") || url.contains(".fo/") || url.contains("/fo/") || url.contains("/.fo.") || url.contains("/fo.") || url.endsWith("/.fo") || url.endsWith("/fo")) {
                this.region = "Faroe Islands";
            } else if (url.contains(".fr.") || url.contains(".fr/") || url.contains("/fr/") || url.contains("/.fr.") || url.contains("/fr.") || url.endsWith("/.fr") || url.endsWith("/fr")) {
                this.region = "France";
            } else if (url.contains(".tf.") || url.contains(".tf/") || url.contains("/tf/") || url.contains("/.tf.") || url.contains("/tf.") || url.endsWith("/.tf") || url.endsWith("/tf")) {
                this.region = "French Southern Territories";
            } else if (url.contains(".fj.") || url.contains(".fj/") || url.contains("/fj/") || url.contains("/.fj.") || url.contains("/fj.") || url.endsWith("/.fj") || url.endsWith("/fj")) {
                this.region = "Fiji";
            } else if (url.contains(".gf.") || url.contains(".gf/") || url.contains("/gf/") || url.contains("/.gf.") || url.contains("/gf.") || url.endsWith("/.gf") || url.endsWith("/gf")) {
                this.region = "French Guiana";
            } else if (url.contains(".ga.") || url.contains(".ga/") || url.contains("/ga/") || url.contains("/.ga.") || url.contains("/ga.") || url.endsWith("/.ga") || url.endsWith("/ga")) {
                this.region = "Gabon";
            } else if (url.contains(".de.") || url.contains(".de/") || url.contains("/de/") || url.contains("/.de.") || url.contains("/de.") || url.endsWith("/.de") || url.endsWith("/de")) {
                this.region = "Germany";
            } else if (url.contains(".gr.") || url.contains(".gr/") || url.contains("/gr/") || url.contains("/.gr.") || url.contains("/gr.") || url.endsWith("/.gr") || url.endsWith("/gr")) {
                this.region = "Greece";
            } else if (url.contains(".gp.") || url.contains(".gp/") || url.contains("/gp/") || url.contains("/.gp.") || url.contains("/gp.") || url.endsWith("/.gp") || url.endsWith("/gp")) {
                this.region = "Guadeloupe";
            } else if (url.contains(".gn.") || url.contains(".gn/") || url.contains("/gn/") || url.contains("/.gn.") || url.contains("/gn.") || url.endsWith("/.gn") || url.endsWith("/gn")) {
                this.region = "Guinea";
            } else if (url.contains(".gm.") || url.contains(".gm/") || url.contains("/gm/") || url.contains("/.gm.") || url.contains("/gm.") || url.endsWith("/.gm") || url.endsWith("/gm")) {
                this.region = "Gambia";
            } else if (url.contains(".gh.") || url.contains(".gh/") || url.contains("/gh/") || url.contains("/.gh.") || url.contains("/gh.") || url.endsWith("/.gh") || url.endsWith("/gh")) {
                this.region = "Ghana";
            } else if (url.contains(".gl.") || url.contains(".gl/") || url.contains("/gl/") || url.contains("/.gl.") || url.contains("/gl.") || url.endsWith("/.gl") || url.endsWith("/gl")) {
                this.region = "Greenland";
            } else if (url.contains(".gu.") || url.contains(".gu/") || url.contains("/gu/") || url.contains("/.gu.") || url.contains("/gu.") || url.endsWith("/.gu") || url.endsWith("/gu")) {
                this.region = "Guam";
            } else if (url.contains(".gw.") || url.contains(".gw/") || url.contains("/gw/") || url.contains("/.gw.") || url.contains("/gw.") || url.endsWith("/.gw") || url.endsWith("/gw")) {
                this.region = "Guinea-bissau";
            } else if (url.contains(".ge.") || url.contains(".ge/") || url.contains("/ge/") || url.contains("/.ge.") || url.contains("/ge.") || url.endsWith("/.ge") || url.endsWith("/ge")) {
                this.region = "Georgia";
            } else if (url.contains(".gi.") || url.contains(".gi/") || url.contains("/gi/") || url.contains("/.gi.") || url.contains("/gi.") || url.endsWith("/.gi") || url.endsWith("/gi")) {
                this.region = "Gibraltar";
            } else if (url.contains(".gd.") || url.contains(".gd/") || url.contains("/gd/") || url.contains("/.gd.") || url.contains("/gd.") || url.endsWith("/.gd") || url.endsWith("/gd")) {
                this.region = "Grenada";
            } else if (url.contains(".gt.") || url.contains(".gt/") || url.contains("/gt/") || url.contains("/.gt.") || url.contains("/gt.") || url.endsWith("/.gt") || url.endsWith("/gt")) {
                this.region = "Guatemala";
            } else if (url.contains(".gy.") || url.contains(".gy/") || url.contains("/gy/") || url.contains("/.gy.") || url.contains("/gy.") || url.endsWith("/.gy") || url.endsWith("/gy")) {
                this.region = "Guyana";
            } else if (url.contains(".ht.") || url.contains(".ht/") || url.contains("/ht/") || url.contains("/.ht.") || url.contains("/ht.") || url.endsWith("/.ht") || url.endsWith("/ht")) {
                this.region = "Haiti";
            } else if (url.contains(".hk.") || url.contains(".hk/") || url.contains("/hk/") || url.contains("/.hk.") || url.contains("/hk.") || url.endsWith("/.hk") || url.endsWith("/hk")) {
                this.region = "Hong Kong";
            } else if (url.contains(".hm.") || url.contains(".hm/") || url.contains("/hm/") || url.contains("/.hm.") || url.contains("/hm.") || url.endsWith("/.hm") || url.endsWith("/hm")) {
                this.region = "Heard and Mc Donald Islands";
            } else if (url.contains(".hu.") || url.contains(".hu/") || url.contains("/hu/") || url.contains("/.hu.") || url.contains("/hu.") || url.endsWith("/.hu") || url.endsWith("/hu")) {
                this.region = "Hungary";
            } else if (url.contains(".hn.") || url.contains(".hn/") || url.contains("/hn/") || url.contains("/.hn.") || url.contains("/hn.") || url.endsWith("/.hn") || url.endsWith("/hn")) {
                this.region = "Honduras";
            } else if (url.contains(".is.") || url.contains(".is/") || url.contains("/is/") || url.contains("/.is.") || url.contains("/is.") || url.endsWith("/.is") || url.endsWith("/is")) {
                this.region = "Iceland";
            } else if (url.contains(".ir.") || url.contains(".ir/") || url.contains("/ir/") || url.contains("/.ir.") || url.contains("/ir.") || url.endsWith("/.ir") || url.endsWith("/ir")) {
                this.region = "Iran";
            } else if (url.contains(".il.") || url.contains(".il/") || url.contains("/il/") || url.contains("/.il.") || url.contains("/il.") || url.endsWith("/.il") || url.endsWith("/il")) {
                this.region = "Israel";
            } else if (url.contains(".in.") || url.contains(".in/") || url.contains("/in/") || url.contains("/.in.") || url.contains("/in.") || url.endsWith("/.in") || url.endsWith("/in")) {
                this.region = "India";
            } else if (url.contains(".iq.") || url.contains(".iq/") || url.contains("/iq/") || url.contains("/.iq.") || url.contains("/iq.") || url.endsWith("/.iq") || url.endsWith("/iq")) {
                this.region = "Iraq";
            } else if (url.contains(".it.") || url.contains(".it/") || url.contains("/it/") || url.contains("/.it.") || url.contains("/it.") || url.endsWith("/.it") || url.endsWith("/it")) {
                this.region = "Italy";
            } else if (url.contains(".id.") || url.contains(".id/") || url.contains("/id/") || url.contains("/.id.") || url.contains("/id.") || url.endsWith("/.id") || url.endsWith("/id")) {
                this.region = "Indonesia";
            } else if (url.contains(".ie.") || url.contains(".ie/") || url.contains("/ie/") || url.contains("/.ie.") || url.contains("/ie.") || url.endsWith("/.ie") || url.endsWith("/ie")) {
                this.region = "Ireland";
            } else if (url.contains(".ci.") || url.contains(".ci/") || url.contains("/ci/") || url.contains("/.ci.") || url.contains("/ci.") || url.endsWith("/.ci") || url.endsWith("/ci")) {
                this.region = "Ivory Coast";
            } else if (url.contains(".jm.") || url.contains(".jm/") || url.contains("/jm/") || url.contains("/.jm.") || url.contains("/jm.") || url.endsWith("/.jm") || url.endsWith("/jm")) {
                this.region = "Jamaica";
            } else if (url.contains(".jp.") || url.contains(".jp/") || url.contains("/jp/") || url.contains("/.jp.") || url.contains("/jp.") || url.endsWith("/.jp") || url.endsWith("/jp")) {
                this.region = "Japan";
            } else if (url.contains(".jo.") || url.contains(".jo/") || url.contains("/jo/") || url.contains("/.jo.") || url.contains("/jo.") || url.endsWith("/.jo") || url.endsWith("/jo")) {
                this.region = "Jordan";
            } else if (url.contains(".kz.") || url.contains(".kz/") || url.contains("/kz/") || url.contains("/.kz.") || url.contains("/kz.") || url.endsWith("/.kz") || url.endsWith("/kz")) {
                this.region = "Kazakhstan";
            } else if (url.contains(".kw.") || url.contains(".kw/") || url.contains("/kw/") || url.contains("/.kw.") || url.contains("/kw.") || url.endsWith("/.kw") || url.endsWith("/kw")) {
                this.region = "Kuwait";
            } else if (url.contains(".ke.") || url.contains(".ke/") || url.contains("/ke/") || url.contains("/.ke.") || url.contains("/ke.") || url.endsWith("/.ke") || url.endsWith("/ke")) {
                this.region = "Kenya";
            } else if (url.contains(".kg.") || url.contains(".kg/") || url.contains("/kg/") || url.contains("/.kg.") || url.contains("/kg.") || url.endsWith("/.kg") || url.endsWith("/kg")) {
                this.region = "Kyrgyzstan";
            } else if (url.contains(".ki.") || url.contains(".ki/") || url.contains("/ki/") || url.contains("/.ki.") || url.contains("/ki.") || url.endsWith("/.ki") || url.endsWith("/ki")) {
                this.region = "Kiribati";
            } else if (url.contains(".la.") || url.contains(".la/") || url.contains("/la/") || url.contains("/.la.") || url.contains("/la.") || url.endsWith("/.la") || url.endsWith("/la")) {
                this.region = "Laos";
            } else if (url.contains(".ls.") || url.contains(".ls/") || url.contains("/ls/") || url.contains("/.ls.") || url.contains("/ls.") || url.endsWith("/.ls") || url.endsWith("/ls")) {
                this.region = "Lesotho";
            } else if (url.contains(".li.") || url.contains(".li/") || url.contains("/li/") || url.contains("/.li.") || url.contains("/li.") || url.endsWith("/.li") || url.endsWith("/li")) {
                this.region = "Lichtenstein";
            } else if (url.contains(".lv.") || url.contains(".lv/") || url.contains("/lv/") || url.contains("/.lv.") || url.contains("/lv.") || url.endsWith("/.lv") || url.endsWith("/lv")) {
                this.region = "Latvia";
            } else if (url.contains(".lr.") || url.contains(".lr/") || url.contains("/lr/") || url.contains("/.lr.") || url.contains("/lr.") || url.endsWith("/.lr") || url.endsWith("/lr")) {
                this.region = "Liberia";
            } else if (url.contains(".lt.") || url.contains(".lt/") || url.contains("/lt/") || url.contains("/.lt.") || url.contains("/lt.") || url.endsWith("/.lt") || url.endsWith("/lt")) {
                this.region = "Lithuania";
            } else if (url.contains(".lb.") || url.contains(".lb/") || url.contains("/lb/") || url.contains("/.lb.") || url.contains("/lb.") || url.endsWith("/.lb") || url.endsWith("/lb")) {
                this.region = "Lebanon";
            } else if (url.contains(".ly.") || url.contains(".ly/") || url.contains("/ly/") || url.contains("/.ly.") || url.contains("/ly.") || url.endsWith("/.ly") || url.endsWith("/ly")) {
                this.region = "Libya";
            } else if (url.contains(".lu.") || url.contains(".lu/") || url.contains("/lu/") || url.contains("/.lu.") || url.contains("/lu.") || url.endsWith("/.lu") || url.endsWith("/lu")) {
                this.region = "Luxembourg";
            } else if (url.contains(".mo.") || url.contains(".mo/") || url.contains("/mo/") || url.contains("/.mo.") || url.contains("/mo.") || url.endsWith("/.mo") || url.endsWith("/mo")) {
                this.region = "Macau";
            } else if (url.contains(".my.") || url.contains(".my/") || url.contains("/my/") || url.contains("/.my.") || url.contains("/my.") || url.endsWith("/.my") || url.endsWith("/my")) {
                this.region = "Malaysia";
            } else if (url.contains(".mt.") || url.contains(".mt/") || url.contains("/mt/") || url.contains("/.mt.") || url.contains("/mt.") || url.endsWith("/.mt") || url.endsWith("/mt")) {
                this.region = "Malta";
            } else if (url.contains(".mr.") || url.contains(".mr/") || url.contains("/mr/") || url.contains("/.mr.") || url.contains("/mr.") || url.endsWith("/.mr") || url.endsWith("/mr")) {
                this.region = "Mauritania";
            } else if (url.contains(".fm.") || url.contains(".fm/") || url.contains("/fm/") || url.contains("/.fm.") || url.contains("/fm.") || url.endsWith("/.fm") || url.endsWith("/fm")) {
                this.region = "Micronesia";
            } else if (url.contains(".mn.") || url.contains(".mn/") || url.contains("/mn/") || url.contains("/.mn.") || url.contains("/mn.") || url.endsWith("/.mn") || url.endsWith("/mn")) {
                this.region = "Mongolia";
            } else if (url.contains(".mz.") || url.contains(".mz/") || url.contains("/mz/") || url.contains("/.mz.") || url.contains("/mz.") || url.endsWith("/.mz") || url.endsWith("/mz")) {
                this.region = "Mozambique";
            } else if (url.contains(".mg.") || url.contains(".mg/") || url.contains("/mg/") || url.contains("/.mg.") || url.contains("/mg.") || url.endsWith("/.mg") || url.endsWith("/mg")) {
                this.region = "Madagascar";
            } else if (url.contains(".mv.") || url.contains(".mv/") || url.contains("/mv/") || url.contains("/.mv.") || url.contains("/mv.") || url.endsWith("/.mv") || url.endsWith("/mv")) {
                this.region = "Maldives";
            } else if (url.contains(".mh.") || url.contains(".mh/") || url.contains("/mh/") || url.contains("/.mh.") || url.contains("/mh.") || url.endsWith("/.mh") || url.endsWith("/mh")) {
                this.region = "Marshall Islands";
            } else if (url.contains(".mu.") || url.contains(".mu/") || url.contains("/mu/") || url.contains("/.mu.") || url.contains("/mu.") || url.endsWith("/.mu") || url.endsWith("/mu")) {
                this.region = "Mauritius";
            } else if (url.contains(".md.") || url.contains(".md/") || url.contains("/md/") || url.contains("/.md.") || url.contains("/md.") || url.endsWith("/.md") || url.endsWith("/md")) {
                this.region = "Moldova Republic";
            } else if (url.contains(".ms.") || url.contains(".ms/") || url.contains("/ms/") || url.contains("/.ms.") || url.contains("/ms.") || url.endsWith("/.ms") || url.endsWith("/ms")) {
                this.region = "Montserrat";
            } else if (url.contains(".mm.") || url.contains(".mm/") || url.contains("/mm/") || url.contains("/.mm.") || url.contains("/mm.") || url.endsWith("/.mm") || url.endsWith("/mm")) {
                this.region = "Myanmar";
            } else if (url.contains(".mw.") || url.contains(".mw/") || url.contains("/mw/") || url.contains("/.mw.") || url.contains("/mw.") || url.endsWith("/.mw") || url.endsWith("/mw")) {
                this.region = "Malawi";
            } else if (url.contains(".ml.") || url.contains(".ml/") || url.contains("/ml/") || url.contains("/.ml.") || url.contains("/ml.") || url.endsWith("/.ml") || url.endsWith("/ml")) {
                this.region = "Mali";
            } else if (url.contains(".mq.") || url.contains(".mq/") || url.contains("/mq/") || url.contains("/.mq.") || url.contains("/mq.") || url.endsWith("/.mq") || url.endsWith("/mq")) {
                this.region = "Martinique";
            } else if (url.contains(".mx.") || url.contains(".mx/") || url.contains("/mx/") || url.contains("/.mx.") || url.contains("/mx.") || url.endsWith("/.mx") || url.endsWith("/mx")) {
                this.region = "Mexico";
            } else if (url.contains(".mc.") || url.contains(".mc/") || url.contains("/mc/") || url.contains("/.mc.") || url.contains("/mc.") || url.endsWith("/.mc") || url.endsWith("/mc")) {
                this.region = "Monaco";
            } else if (url.contains(".ma.") || url.contains(".ma/") || url.contains("/ma/") || url.contains("/.ma.") || url.contains("/ma.") || url.endsWith("/.ma") || url.endsWith("/ma")) {
                this.region = "Morocco";
            } else if (url.contains(".na.") || url.contains(".na/") || url.contains("/na/") || url.contains("/.na.") || url.contains("/na.") || url.endsWith("/.na") || url.endsWith("/na")) {
                this.region = "Namibia";
            } else if (url.contains(".nl.") || url.contains(".nl/") || url.contains("/nl/") || url.contains("/.nl.") || url.contains("/nl.") || url.endsWith("/.nl") || url.endsWith("/nl")) {
                this.region = "Netherlands";
            } else if (url.contains(".nc.") || url.contains(".nc/") || url.contains("/nc/") || url.contains("/.nc.") || url.contains("/nc.") || url.endsWith("/.nc") || url.endsWith("/nc")) {
                this.region = "New Caledonia";
            } else if (url.contains(".ne.") || url.contains(".ne/") || url.contains("/ne/") || url.contains("/.ne.") || url.contains("/ne.") || url.endsWith("/.ne") || url.endsWith("/ne")) {
                this.region = "Niger";
            } else if (url.contains(".nf.") || url.contains(".nf/") || url.contains("/nf/") || url.contains("/.nf.") || url.contains("/nf.") || url.endsWith("/.nf") || url.endsWith("/nf")) {
                this.region = "Norfolk Island";
            } else if (url.contains(".no.") || url.contains(".no/") || url.contains("/no/") || url.contains("/.no.") || url.contains("/no.") || url.endsWith("/.no") || url.endsWith("/no")) {
                this.region = "Norway";
            } else if (url.contains(".nr.") || url.contains(".nr/") || url.contains("/nr/") || url.contains("/.nr.") || url.contains("/nr.") || url.endsWith("/.nr") || url.endsWith("/nr")) {
                this.region = "Nauru";
            } else if (url.contains(".an.") || url.contains(".an/") || url.contains("/an/") || url.contains("/.an.") || url.contains("/an.") || url.endsWith("/.an") || url.endsWith("/an")) {
                this.region = "Netherlands Antilles";
            } else if (url.contains(".nz.") || url.contains(".nz/") || url.contains("/nz/") || url.contains("/.nz.") || url.contains("/nz.") || url.endsWith("/.nz") || url.endsWith("/nz")) {
                this.region = "New Zealand";
            } else if (url.contains(".ng.") || url.contains(".ng/") || url.contains("/ng/") || url.contains("/.ng.") || url.contains("/ng.") || url.endsWith("/.ng") || url.endsWith("/ng")) {
                this.region = "Nigeria";
            } else if (url.contains(".kp.") || url.contains(".kp/") || url.contains("/kp/") || url.contains("/.kp.") || url.contains("/kp.") || url.endsWith("/.kp") || url.endsWith("/kp")) {
                this.region = "North Korea";
            } else if (url.contains(".np.") || url.contains(".np/") || url.contains("/np/") || url.contains("/.np.") || url.contains("/np.") || url.endsWith("/.np") || url.endsWith("/np")) {
                this.region = "Nepal";
            } else if (url.contains(".nt.") || url.contains(".nt/") || url.contains("/nt/") || url.contains("/.nt.") || url.contains("/nt.") || url.endsWith("/.nt") || url.endsWith("/nt")) {
                this.region = "Neutral Zone";
            } else if (url.contains(".ni.") || url.contains(".ni/") || url.contains("/ni/") || url.contains("/.ni.") || url.contains("/ni.") || url.endsWith("/.ni") || url.endsWith("/ni")) {
                this.region = "Nicaragua";
            } else if (url.contains(".nu.") || url.contains(".nu/") || url.contains("/nu/") || url.contains("/.nu.") || url.contains("/nu.") || url.endsWith("/.nu") || url.endsWith("/nu")) {
                this.region = "Niue";
            } else if (url.contains(".mp.") || url.contains(".mp/") || url.contains("/mp/") || url.contains("/.mp.") || url.contains("/mp.") || url.endsWith("/.mp") || url.endsWith("/mp")) {
                this.region = "Northern Mariana Islands";
            } else if (url.contains(".om.") || url.contains(".om/") || url.contains("/om/") || url.contains("/.om.") || url.contains("/om.") || url.endsWith("/.om") || url.endsWith("/om")) {
                this.region = "Oman";
            } else if (url.contains(".pk.") || url.contains(".pk/") || url.contains("/pk/") || url.contains("/.pk.") || url.contains("/pk.") || url.endsWith("/.pk") || url.endsWith("/pk")) {
                this.region = "Pakistan";
            } else if (url.contains(".pg.") || url.contains(".pg/") || url.contains("/pg/") || url.contains("/.pg.") || url.contains("/pg.") || url.endsWith("/.pg") || url.endsWith("/pg")) {
                this.region = "Papua New Guinea";
            } else if (url.contains(".ph.") || url.contains(".ph/") || url.contains("/ph/") || url.contains("/.ph.") || url.contains("/ph.") || url.endsWith("/.ph") || url.endsWith("/ph")) {
                this.region = "Philippines";
            } else if (url.contains(".pt.") || url.contains(".pt/") || url.contains("/pt/") || url.contains("/.pt.") || url.contains("/pt.") || url.endsWith("/.pt") || url.endsWith("/pt")) {
                this.region = "Portugal";
            } else if (url.contains(".pw.") || url.contains(".pw/") || url.contains("/pw/") || url.contains("/.pw.") || url.contains("/pw.") || url.endsWith("/.pw") || url.endsWith("/pw")) {
                this.region = "Palau";
            } else if (url.contains(".py.") || url.contains(".py/") || url.contains("/py/") || url.contains("/.py.") || url.contains("/py.") || url.endsWith("/.py") || url.endsWith("/py")) {
                this.region = "Paraguay";
            } else if (url.contains(".pn.") || url.contains(".pn/") || url.contains("/pn/") || url.contains("/.pn.") || url.contains("/pn.") || url.endsWith("/.pn") || url.endsWith("/pn")) {
                this.region = "Pitcairn";
            } else if (url.contains(".pr.") || url.contains(".pr/") || url.contains("/pr/") || url.contains("/.pr.") || url.contains("/pr.") || url.endsWith("/.pr") || url.endsWith("/pr")) {
                this.region = "Puerto Rico";
            } else if (url.contains(".pa.") || url.contains(".pa/") || url.contains("/pa/") || url.contains("/.pa.") || url.contains("/pa.") || url.endsWith("/.pa") || url.endsWith("/pa")) {
                this.region = "Panama";
            } else if (url.contains(".pe.") || url.contains(".pe/") || url.contains("/pe/") || url.contains("/.pe.") || url.contains("/pe.") || url.endsWith("/.pe") || url.endsWith("/pe")) {
                this.region = "Peru";
            } else if (url.contains(".pl.") || url.contains(".pl/") || url.contains("/pl/") || url.contains("/.pl.") || url.contains("/pl.") || url.endsWith("/.pl") || url.endsWith("/pl")) {
                this.region = "Poland";
            } else if (url.contains(".qa.") || url.contains(".qa/") || url.contains("/qa/") || url.contains("/.qa.") || url.contains("/qa.") || url.endsWith("/.qa") || url.endsWith("/qa")) {
                this.region = "Qatar";
            } else if (url.contains(".kn.") || url.contains(".kn/") || url.contains("/kn/") || url.contains("/.kn.") || url.contains("/kn.") || url.endsWith("/.kn") || url.endsWith("/kn")) {
                this.region = "Saint Kitts and Nevis";
            } else if (url.contains(".ws.") || url.contains(".ws/") || url.contains("/ws/") || url.contains("/.ws.") || url.contains("/ws.") || url.endsWith("/.ws") || url.endsWith("/ws")) {
                this.region = "Samoa";
            } else if (url.contains(".sa.") || url.contains(".sa/") || url.contains("/sa/") || url.contains("/.sa.") || url.contains("/sa.") || url.endsWith("/.sa") || url.endsWith("/sa")) {
                this.region = "Saudi Arabia";
            } else if (url.contains(".sl.") || url.contains(".sl/") || url.contains("/sl/") || url.contains("/.sl.") || url.contains("/sl.") || url.endsWith("/.sl") || url.endsWith("/sl")) {
                this.region = "Sierra Leone";
            } else if (url.contains(".sb.") || url.contains(".sb/") || url.contains("/sb/") || url.contains("/.sb.") || url.contains("/sb.") || url.endsWith("/.sb") || url.endsWith("/sb")) {
                this.region = "Solomon Islands";
            } else if (url.contains(".kr.") || url.contains(".kr/") || url.contains("/kr/") || url.contains("/.kr.") || url.contains("/kr.") || url.endsWith("/.kr") || url.endsWith("/kr")) {
                this.region = "South Korea";
            } else if (url.contains(".sh.") || url.contains(".sh/") || url.contains("/sh/") || url.contains("/.sh.") || url.contains("/sh.") || url.endsWith("/.sh") || url.endsWith("/sh")) {
                this.region = "St. Helena";
            } else if (url.contains(".sr.") || url.contains(".sr/") || url.contains("/sr/") || url.contains("/.sr.") || url.contains("/sr.") || url.endsWith("/.sr") || url.endsWith("/sr")) {
                this.region = "Suriname";
            } else if (url.contains(".se.") || url.contains(".se/") || url.contains("/se/") || url.contains("/.se.") || url.contains("/se.") || url.endsWith("/.se") || url.endsWith("/se")) {
                this.region = "Sweden";
            } else if (url.contains(".lc.") || url.contains(".lc/") || url.contains("/lc/") || url.contains("/.lc.") || url.contains("/lc.") || url.endsWith("/.lc") || url.endsWith("/lc")) {
                this.region = "Saint Lucia";
            } else if (url.contains(".sm.") || url.contains(".sm/") || url.contains("/sm/") || url.contains("/.sm.") || url.contains("/sm.") || url.endsWith("/.sm") || url.endsWith("/sm")) {
                this.region = "San Marino";
            } else if (url.contains(".sn.") || url.contains(".sn/") || url.contains("/sn/") || url.contains("/.sn.") || url.contains("/sn.") || url.endsWith("/.sn") || url.endsWith("/sn")) {
                this.region = "Senegal";
            } else if (url.contains(".sg.") || url.contains(".sg/") || url.contains("/sg/") || url.contains("/.sg.") || url.contains("/sg.") || url.endsWith("/.sg") || url.endsWith("/sg")) {
                this.region = "Singapore";
            } else if (url.contains(".so.") || url.contains(".so/") || url.contains("/so/") || url.contains("/.so.") || url.contains("/so.") || url.endsWith("/.so") || url.endsWith("/so")) {
                this.region = "Somalia";
            } else if (url.contains(".es.") || url.contains(".es/") || url.contains("/es/") || url.contains("/.es.") || url.contains("/es.") || url.endsWith("/.es") || url.endsWith("/es")) {
                this.region = "Spain";
            } else if (url.contains(".pm.") || url.contains(".pm/") || url.contains("/pm/") || url.contains("/.pm.") || url.contains("/pm.") || url.endsWith("/.pm") || url.endsWith("/pm")) {
                this.region = "St. Pierre and Miquelon";
            } else if (url.contains(".sj.") || url.contains(".sj/") || url.contains("/sj/") || url.contains("/.sj.") || url.contains("/sj.") || url.endsWith("/.sj") || url.endsWith("/sj")) {
                this.region = "Svalbard and Jan Mayen Islands";
            } else if (url.contains(".ch.") || url.contains(".ch/") || url.contains("/ch/") || url.contains("/.ch.") || url.contains("/ch.") || url.endsWith("/.ch") || url.endsWith("/ch")) {
                this.region = "Switzerland";
            } else if (url.contains(".vc.") || url.contains(".vc/") || url.contains("/vc/") || url.contains("/.vc.") || url.contains("/vc.") || url.endsWith("/.vc") || url.endsWith("/vc")) {
                this.region = "Saint Vincent, Grenadines";
            } else if (url.contains(".st.") || url.contains(".st/") || url.contains("/st/") || url.contains("/.st.") || url.contains("/st.") || url.endsWith("/.st") || url.endsWith("/st")) {
                this.region = "Sao Tome and Principe";
            } else if (url.contains(".sc.") || url.contains(".sc/") || url.contains("/sc/") || url.contains("/.sc.") || url.contains("/sc.") || url.endsWith("/.sc") || url.endsWith("/sc")) {
                this.region = "Seychelles";
            } else if (url.contains(".si.") || url.contains(".si/") || url.contains("/si/") || url.contains("/.si.") || url.contains("/si.") || url.endsWith("/.si") || url.endsWith("/si")) {
                this.region = "Slovenia";
            } else if (url.contains(".za.") || url.contains(".za/") || url.contains("/za/") || url.contains("/.za.") || url.contains("/za.") || url.endsWith("/.za") || url.endsWith("/za")) {
                this.region = "South Africa";
            } else if (url.contains(".lk.") || url.contains(".lk/") || url.contains("/lk/") || url.contains("/.lk.") || url.contains("/lk.") || url.endsWith("/.lk") || url.endsWith("/lk")) {
                this.region = "Sri Lanka";
            } else if (url.contains(".sd.") || url.contains(".sd/") || url.contains("/sd/") || url.contains("/.sd.") || url.contains("/sd.") || url.endsWith("/.sd") || url.endsWith("/sd")) {
                this.region = "Sudan";
            } else if (url.contains(".sz.") || url.contains(".sz/") || url.contains("/sz/") || url.contains("/.sz.") || url.contains("/sz.") || url.endsWith("/.sz") || url.endsWith("/sz")) {
                this.region = "Swaziland";
            } else if (url.contains(".sy.") || url.contains(".sy/") || url.contains("/sy/") || url.contains("/.sy.") || url.contains("/sy.") || url.endsWith("/.sy") || url.endsWith("/sy")) {
                this.region = "Syria";
            } else if (url.contains(".tw.") || url.contains(".tw/") || url.contains("/tw/") || url.contains("/.tw.") || url.contains("/tw.") || url.endsWith("/.tw") || url.endsWith("/tw")) {
                this.region = "Taiwan";
            } else if (url.contains(".th.") || url.contains(".th/") || url.contains("/th/") || url.contains("/.th.") || url.contains("/th.") || url.endsWith("/.th") || url.endsWith("/th")) {
                this.region = "Thailand";
            } else if (url.contains(".to.") || url.contains(".to/") || url.contains("/to/") || url.contains("/.to.") || url.contains("/to.") || url.endsWith("/.to") || url.endsWith("/to")) {
                this.region = "Tonga";
            } else if (url.contains(".tr.") || url.contains(".tr/") || url.contains("/tr/") || url.contains("/.tr.") || url.contains("/tr.") || url.endsWith("/.tr") || url.endsWith("/tr")) {
                this.region = "Turkey";
            } else if (url.contains(".tv.") || url.contains(".tv/") || url.contains("/tv/") || url.contains("/.tv.") || url.contains("/tv.") || url.endsWith("/.tv") || url.endsWith("/tv")) {
                this.region = "Tuvalu";
            } else if (url.contains(".tj.") || url.contains(".tj/") || url.contains("/tj/") || url.contains("/.tj.") || url.contains("/tj.") || url.endsWith("/.tj") || url.endsWith("/tj")) {
                this.region = "Tajikistan";
            } else if (url.contains(".tg.") || url.contains(".tg/") || url.contains("/tg/") || url.contains("/.tg.") || url.contains("/tg.") || url.endsWith("/.tg") || url.endsWith("/tg")) {
                this.region = "Togo";
            } else if (url.contains(".tt.") || url.contains(".tt/") || url.contains("/tt/") || url.contains("/.tt.") || url.contains("/tt.") || url.endsWith("/.tt") || url.endsWith("/tt")) {
                this.region = "Trinidad, Tobago";
            } else if (url.contains(".tm.") || url.contains(".tm/") || url.contains("/tm/") || url.contains("/.tm.") || url.contains("/tm.") || url.endsWith("/.tm") || url.endsWith("/tm")) {
                this.region = "Turkmenistan";
            } else if (url.contains(".tz.") || url.contains(".tz/") || url.contains("/tz/") || url.contains("/.tz.") || url.contains("/tz.") || url.endsWith("/.tz") || url.endsWith("/tz")) {
                this.region = "Tanzania";
            } else if (url.contains(".tk.") || url.contains(".tk/") || url.contains("/tk/") || url.contains("/.tk.") || url.contains("/tk.") || url.endsWith("/.tk") || url.endsWith("/tk")) {
                this.region = "Tokelau";
            } else if (url.contains(".tn.") || url.contains(".tn/") || url.contains("/tn/") || url.contains("/.tn.") || url.contains("/tn.") || url.endsWith("/.tn") || url.endsWith("/tn")) {
                this.region = "Tunisia";
            } else if (url.contains(".tc.") || url.contains(".tc/") || url.contains("/tc/") || url.contains("/.tc.") || url.contains("/tc.") || url.endsWith("/.tc") || url.endsWith("/tc")) {
                this.region = "Turks and Caicos Islands";
            } else if (url.contains(".ug.") || url.contains(".ug/") || url.contains("/ug/") || url.contains("/.ug.") || url.contains("/ug.") || url.endsWith("/.ug") || url.endsWith("/ug")) {
                this.region = "Uganda";
            } else if (url.contains(".uk.") || url.contains(".uk/") || url.contains("/uk/") || url.contains("/.uk.") || url.contains("/uk.") || url.endsWith("/.uk") || url.endsWith("/uk")) {
                this.region = "United Kingdom";
            } else if (url.contains(".uy.") || url.contains(".uy/") || url.contains("/uy/") || url.contains("/.uy.") || url.contains("/uy.") || url.endsWith("/.uy") || url.endsWith("/uy")) {
                this.region = "Uruguay";
            } else if (url.contains(".ua.") || url.contains(".ua/") || url.contains("/ua/") || url.contains("/.ua.") || url.contains("/ua.") || url.endsWith("/.ua") || url.endsWith("/ua")) {
                this.region = "Ukraine";
            } else if (url.contains(".us.") || url.contains(".us/") || url.contains("/us/") || url.contains("/.us.") || url.contains("/us.") || url.endsWith("/.us") || url.endsWith("/us")) {
                this.region = "United States";
            } else if (url.contains(".uz.") || url.contains(".uz/") || url.contains("/uz/") || url.contains("/.uz.") || url.contains("/uz.") || url.endsWith("/.uz") || url.endsWith("/uz")) {
                this.region = "Uzbekistan";
            } else if (url.contains(".ae.") || url.contains(".ae/") || url.contains("/ae/") || url.contains("/.ae.") || url.contains("/ae.") || url.endsWith("/.ae") || url.endsWith("/ae")) {
                this.region = "United Arab Emirates";
            } else if (url.contains(".um.") || url.contains(".um/") || url.contains("/um/") || url.contains("/.um.") || url.contains("/um.") || url.endsWith("/.um") || url.endsWith("/um")) {
                this.region = "United States Minor Islands";
            } else if (url.contains(".vu.") || url.contains(".vu/") || url.contains("/vu/") || url.contains("/.vu.") || url.contains("/vu.") || url.endsWith("/.vu") || url.endsWith("/vu")) {
                this.region = "Vanuatu";
            } else if (url.contains(".vn.") || url.contains(".vn/") || url.contains("/vn/") || url.contains("/.vn.") || url.contains("/vn.") || url.endsWith("/.vn") || url.endsWith("/vn")) {
                this.region = "Viet Nam";
            } else if (url.contains(".va.") || url.contains(".va/") || url.contains("/va/") || url.contains("/.va.") || url.contains("/va.") || url.endsWith("/.va") || url.endsWith("/va")) {
                this.region = "Vatican City";
            } else if (url.contains(".vg.") || url.contains(".vg/") || url.contains("/vg/") || url.contains("/.vg.") || url.contains("/vg.") || url.endsWith("/.vg") || url.endsWith("/vg")) {
                this.region = "Virgin Islands (British)";
            } else if (url.contains(".ve.") || url.contains(".ve/") || url.contains("/ve/") || url.contains("/.ve.") || url.contains("/ve.") || url.endsWith("/.ve") || url.endsWith("/ve")) {
                this.region = "Venezuela";
            } else if (url.contains(".vi.") || url.contains(".vi/") || url.contains("/vi/") || url.contains("/.vi.") || url.contains("/vi.") || url.endsWith("/.vi") || url.endsWith("/vi")) {
                this.region = "Virgin Islands (U.S.)";
            } else if (url.contains(".wf.") || url.contains(".wf/") || url.contains("/wf/") || url.contains("/.wf.") || url.contains("/wf.") || url.endsWith("/.wf") || url.endsWith("/wf")) {
                this.region = "Wallis and Futuna Islands";
            } else if (url.contains(".eh.") || url.contains(".eh/") || url.contains("/eh/") || url.contains("/.eh.") || url.contains("/eh.") || url.endsWith("/.eh") || url.endsWith("/eh")) {
                this.region = "Western Sahara";
            } else if (url.contains(".ye.") || url.contains(".ye/") || url.contains("/ye/") || url.contains("/.ye.") || url.contains("/ye.") || url.endsWith("/.ye") || url.endsWith("/ye")) {
                this.region = "Yemen";
            } else if (url.contains(".yu.") || url.contains(".yu/") || url.contains("/yu/") || url.contains("/.yu.") || url.contains("/yu.") || url.endsWith("/.yu") || url.endsWith("/yu")) {
                this.region = "Yugoslavia";
            } else if (url.contains(".zr.") || url.contains(".zr/") || url.contains("/zr/") || url.contains("/.zr.") || url.contains("/zr.") || url.endsWith("/.zr") || url.endsWith("/zr")) {
                this.region = "Zaire";
            } else if (url.contains(".zm.") || url.contains(".zm/") || url.contains("/zm/") || url.contains("/.zm.") || url.contains("/zm.") || url.endsWith("/.zm") || url.endsWith("/zm")) {
                this.region = "Zambia";
            } else if (url.contains(".zw.") || url.contains(".zw/") || url.contains("/zw/") || url.contains("/.zw.") || url.contains("/zw.") || url.endsWith("/.zw") || url.endsWith("/zw")) {
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
