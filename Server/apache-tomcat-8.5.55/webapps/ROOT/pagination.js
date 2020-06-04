var current_page = 1;
var records_per_page = 10;
var objJson = [
    { title: "Media & Entertainment Directory - 247WebDirectory.com" , statement:"BBC Freesat-AerialForce co uk..." , url:"https://www.247webdirectory.com/media-entertainment.htm"},
    { title: "YouTube TV - Watch & DVR Live Sports, Shows & News" , statement:"BBC..." , url:"https://tv.youtube.com/"},
    { title: "Google Play" , statement:"As seen on Netflix and BBC around the world ..." , url:"https://play.google.com/?hl=en&tab=u8"},
    { title: "Corona Virus (COVID-19) Official Resources" , statement:"BBC News..." , url:"https://www.dirjournal.com/health/corona_virus_resources/"},
    { title: "?Saatchi Gallery - ?????? ???????? | ???????" , statement:"British Museum             MoMA The Museum of Modern Art                  Saatchi Art          National Gallery          Royal Academy of Ar..." , url:"https://www.facebook.com/saatchigalleryofficial/"},
    { title: "United Kingdom - Wikipedia" , statement:"The term  Britain  is used both as a synonym for Great Britain  54  55  56  and as a synonym for the United Kingdom  57  56  Usage is mixed ..." , url:"https://en.wikipedia.org/wiki/United_Kingdom"},
    { title: "November 8 - Wikimedia Commons" , statement:"BBC News..." , url:"https://commons.wikimedia.org/wiki/November_8"},
    { title: "November 30 - Wikimedia Commons" , statement:"BBC News..." , url:"https://commons.wikimedia.org/wiki/November_30"},
    { title: "November 3 - Wikimedia Commons" , statement:"BBC News..." , url:"https://commons.wikimedia.org/wiki/November_3"},
    { title: "Violence against women - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Violence_against_women"},
    { title: "Programmer - Wikipedia" , statement:"According to BBC News  17  of computer science students could not find work in their field 6 months after graduation in 2009 which was the h..." , url:"https://en.wikipedia.org/wiki/Software_developer"},
    { title: "YouTube TV - Watch & DVR Live Sports, Shows & News" , statement:"BBC..." , url:"https://tv.youtube.com/welcome/?utm_source=ads-en-ha-na-sem&utm_campaign=youtubetv&utm_medium=text&utm_term=ds_kwdid&utm_content=new-dr-bkws"},
    { title: "Child abuse - Wikipedia" , statement:"In 1999 the BBC reported on the RAHI Foundation s survey of sexual abuse in India  in which 76  of respondents said they had been abused as ..." , url:"https://en.wikipedia.org/wiki/Child_abuse"},
    { title: "Wikipedia administrators - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Wikipedia_administrators#cite_note-WP-2"},
    { title: "Wikipedia administrators - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Wikipedia_administrators#cite_note-8"},
    { title: "Wikipedia administrators - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Wikipedia_administrators#References"},
    { title: "Wikipedia administrators - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Wikipedia_administrators"},
    { title: "Mizuho Fukushima - Wikipedia" , statement:"  a b  1   in Japanese    House of Councillors website List of the Members Archived 2011-07-16 at the Wayback Machine   The Foreign Correspo..." , url:"https://en.wikipedia.org/wiki/Mizuho_Fukushima"},
    { title: "Northgrippian - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Northgrippian"},
    { title: "Portal:Society - Wikipedia" , statement:"BBC History Home Page   Industrial Revolution National Museum of Science and Industry website   machines and personalities Industrial Revolu..." , url:"https://en.wikipedia.org/wiki/Portal:Society"},
    { title: "Wikipedia - Wikipedia" , statement:"In July 2007  Wikipedia was the focus of a 30-minute documentary on BBC Radio 4 333  which argued that  with increased usage and awareness  ..." , url:"https://en.wikipedia.org/wiki/Wikipedia#cite_note-3"},
    { title: "Wikipedia - Wikipedia" , statement:"In July 2007  Wikipedia was the focus of a 30-minute documentary on BBC Radio 4 333  which argued that  with increased usage and awareness  ..." , url:"https://en.wikipedia.org/wiki/Wikipedia"},
    { title: "Wikipedia - Wikipedia" , statement:"In July 2007  Wikipedia was the focus of a 30-minute documentary on BBC Radio 4 333  which argued that  with increased usage and awareness  ..." , url:"http://en.wikipedia.org/wiki/Wikipedia"},
    { title: "Austrians - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Austrians"},
    { title: "Devonian - Wikipedia" , statement:"bbc co uk..." , url:"https://en.wikipedia.org/wiki/Devonian"},
    { title: "Germans - Wikipedia" , statement:"Since the 2006 FIFA World Cup  the internal and external evaluation of Germany s national image has changed  123  In the annual Nation Brand..." , url:"https://en.wikipedia.org/wiki/Germans"},
    { title: "List of sovereign states - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/List_of_sovereign_states"},
    { title: "Liberal Democratic Party (Japan) - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Liberal_Democratic_Party_(Japan)"},
    { title: "Amateur sports - Wikipedia" , statement:"BBC Sport..." , url:"https://en.wikipedia.org/wiki/Amateur_sports"},
    { title: "Matching funds - Wikipedia" , statement:"Presidential Election Campaign Fund  PECF  information and Public Funding of Presidential Elections brochure  Federal Election Commission we..." , url:"https://en.wikipedia.org/wiki/Matching_funds"},
    { title: "Earth - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Earth"},
    { title: "Brazil - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Brasil"},
    { title: "Social Democratic Party (Japan) - Wikipedia" , statement:"   Shakai Minshu-t  towa                                kotobank jp  in Japanese   Retrieved May 29  2020   from Microp dia     The politica..." , url:"https://en.wikipedia.org/wiki/Social_Democratic_Party_of_Japan"},
    { title: "Discovery Channel - Wikipedia" , statement:"John Hendricks founded the channel and its parent company  Cable Educational Network Inc   in 1982  8  Several investors  including the BBC ..." , url:"https://en.wikipedia.org/wiki/Discovery_Channel"},
    { title: "Ferris wheel - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Ferris_wheel#Early_history"},
    { title: "Ferris wheel - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Ferris_wheel"},
    { title: "Holocene - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Holocene"},
    { title: "Cruelty to animals - Wikipedia" , statement:"BBC News Online..." , url:"https://en.wikipedia.org/wiki/Cruelty_to_animals"},
    { title: "United States - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/United_States"},
    { title: "GIF - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Animated_GIF"},
    { title: "Computer - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Computer"},
    { title: "Satellite navigation - Wikipedia" , statement:"  a b  Beidou satellite navigation system to cover whole world in 2020   Eng chinamil com cn  Retrieved 2011-12-30    a b  Galileo goes live..." , url:"https://en.wikipedia.org/wiki/Satellite_navigation"},
    { title: "Country code top-level domain - Wikipedia" , statement:"   the Domain Name Industry Report     1   ICANN ccTLD     2   ccTLD Stats     3   kredit de Sale Record     4   cruises co uk Sale Record  ..." , url:"https://en.wikipedia.org/wiki/Country_code_top-level_domain"},
    { title: "Creative Commons - Wikipedia" , statement:"Ardito  Stephanie C   2003    Public-Domain Advocacy Flourishes   Information Today  20  7   17  19  Asschenfeldt  Christiane   Copyright an..." , url:"https://en.wikipedia.org/wiki/en:Creative_Commons"},
    { title: "Creative Commons - Wikipedia" , statement:"Ardito  Stephanie C   2003    Public-Domain Advocacy Flourishes   Information Today  20  7   17  19  Asschenfeldt  Christiane   Copyright an..." , url:"https://en.wikipedia.org/wiki/Creative_Commons#p-search"},
    { title: "Creative Commons - Wikipedia" , statement:"Ardito  Stephanie C   2003    Public-Domain Advocacy Flourishes   Information Today  20  7   17  19  Asschenfeldt  Christiane   Copyright an..." , url:"https://en.wikipedia.org/wiki/Creative_Commons#mw-head"},
    { title: "Creative Commons - Wikipedia" , statement:"Ardito  Stephanie C   2003    Public-Domain Advocacy Flourishes   Information Today  20  7   17  19  Asschenfeldt  Christiane   Copyright an..." , url:"https://en.wikipedia.org/wiki/Creative_Commons#cite_note-nonprofit-explorer-2"},
    { title: "Creative Commons - Wikipedia" , statement:"Ardito  Stephanie C   2003    Public-Domain Advocacy Flourishes   Information Today  20  7   17  19  Asschenfeldt  Christiane   Copyright an..." , url:"https://en.wikipedia.org/wiki/Creative_Commons#cite_note-6"},
    { title: "Creative Commons - Wikipedia" , statement:"Ardito  Stephanie C   2003    Public-Domain Advocacy Flourishes   Information Today  20  7   17  19  Asschenfeldt  Christiane   Copyright an..." , url:"https://en.wikipedia.org/wiki/Creative_Commons#cite_note-5"},
    { title: "Creative Commons - Wikipedia" , statement:"Ardito  Stephanie C   2003    Public-Domain Advocacy Flourishes   Information Today  20  7   17  19  Asschenfeldt  Christiane   Copyright an..." , url:"https://en.wikipedia.org/wiki/Creative_Commons#cite_note-4"},
    { title: "Creative Commons - Wikipedia" , statement:"Ardito  Stephanie C   2003    Public-Domain Advocacy Flourishes   Information Today  20  7   17  19  Asschenfeldt  Christiane   Copyright an..." , url:"https://en.wikipedia.org/wiki/Creative_Commons#cite_note-3"},
    { title: "Creative Commons - Wikipedia" , statement:"Ardito  Stephanie C   2003    Public-Domain Advocacy Flourishes   Information Today  20  7   17  19  Asschenfeldt  Christiane   Copyright an..." , url:"https://en.wikipedia.org/wiki/Creative_Commons#cite_note-1"},
    { title: "Creative Commons - Wikipedia" , statement:"Ardito  Stephanie C   2003    Public-Domain Advocacy Flourishes   Information Today  20  7   17  19  Asschenfeldt  Christiane   Copyright an..." , url:"https://en.wikipedia.org/wiki/Creative_Commons"},
    { title: "Hubble Space Telescope - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Hubble_Space_Telescope"},
    { title: "Hero - Wikipedia" , statement:"The British Hero   online exhibition from screenonline  a website of the British Film Institute  looking at British heroes of film and telev..." , url:"https://en.wikipedia.org/wiki/Hero"},
    { title: "French people - Wikipedia" , statement:"   D mographie   Population au d but du mois   France   Insee fr  Institut national de la statistique et des  tudes  conomiques  Retrieved 2..." , url:"https://en.wikipedia.org/wiki/French_people"},
    { title: "Rights - Wikipedia" , statement:"  a b c d  Stanford Encyclopedia of Philosophy   Stanford University  July 9  2007  Retrieved 2009-12-21  Rights dominate most modern unders..." , url:"https://en.wikipedia.org/wiki/Rights"},
    { title: "House of Representatives (Japan) - Wikipedia" , statement:"bbc com news world-asia-41423848   https   www reuters com article us-japan-election japan-parliament-dissolved-snap-october-22-election-exp..." , url:"https://en.wikipedia.org/wiki/House_of_Representatives_(Japan)"},
    { title: "Longitude - Wikipedia" , statement:"   Definition of LONGITUDE   www merriam-webster com  Merriam-Webster  Retrieved 14 March 2018    Oxford English Dictionary    Collecion de ..." , url:"https://en.wikipedia.org/wiki/Longitude"},
    { title: "Carbon dioxide - Wikipedia" , statement:"etrieved 14 October 2019    https   www bbc co uk news world-europe-51680049   a b  ABG  Arterial Blood Gas    Brookside Associates  Retriev..." , url:"https://en.wikipedia.org/wiki/Carbon_dioxide"},
    { title: "Film - Wikipedia" , statement:"  Severny  Andrei  September 5  2013    The Movie Theater of the Future Will Be In Your Mind   Tribeca  Archived from the original on Septem..." , url:"https://en.wikipedia.org/wiki/Motion_picture"},
    { title: "Film - Wikipedia" , statement:"  Severny  Andrei  September 5  2013    The Movie Theater of the Future Will Be In Your Mind   Tribeca  Archived from the original on Septem..." , url:"https://en.wikipedia.org/wiki/Film"},
    { title: "Fungus - Wikipedia" , statement:"BBC News..." , url:"https://en.wikipedia.org/wiki/Fungus"},
    { title: "Irish people - Wikipedia" , statement:"titled to an Irish passport     via www bbc co uk     Department of Foreign Affairs - Emigrant Grants   28 July 2013  Archived from the orig..." , url:"https://en.wikipedia.org/wiki/Irish_people"},
    { title: "Pacific Ocean - Wikipedia" , statement:"  a b c  Pacific Ocean   Britannica Concise  2008  Encyclop dia Britannica  Inc    International Hydrographic Organization  1953    Limits o..." , url:"https://en.wikipedia.org/wiki/Pacific_Ocean"},
    { title: "Creativity - Wikipedia" , statement:"wined with mental illness   https   www bbc co uk news health-19959565  16 October 2012     The science of creativity   apa org    Flood  Me..." , url:"https://en.wikipedia.org/wiki/Creativity"},
    { title: "Conservatism - Wikipedia" , statement:"ying or being alert to God   http   www bbc co uk schools gcsebitesize rs sanctity chdrugsrev2 shtml Archived 2017-10-20 at the Wayback Mach..." , url:"https://en.wikipedia.org/wiki/Conservatism"},
    { title: "HIV/AIDS - Wikipedia" , statement:"Some religious organizations have claimed that prayer can cure HIV AIDS  In 2011  the BBC reported that some churches in London were claimin..." , url:"https://en.wikipedia.org/wiki/HIV/AIDS#cite_note-WHO2015Fact-4"},
    { title: "HIV/AIDS - Wikipedia" , statement:"Some religious organizations have claimed that prayer can cure HIV AIDS  In 2011  the BBC reported that some churches in London were claimin..." , url:"https://en.wikipedia.org/wiki/HIV/AIDS#cite_note-3"},
    { title: "HIV/AIDS - Wikipedia" , statement:"Some religious organizations have claimed that prayer can cure HIV AIDS  In 2011  the BBC reported that some churches in London were claimin..." , url:"https://en.wikipedia.org/wiki/HIV/AIDS"},
    { title: "User talk:Jdx/Archive 4 - Wikimedia Commons" , statement:"Did you know  Newest properties  General datatypes  none External identifiers  The Washington Post contributor ID  DoME artist ID  ArchiWebt..." , url:"https://commons.wikimedia.org/wiki/User_talk:Jdx/Archive_4#Category"},
    { title: "User talk:Jdx/Archive 4 - Wikimedia Commons" , statement:"Did you know  Newest properties  General datatypes  none External identifiers  The Washington Post contributor ID  DoME artist ID  ArchiWebt..." , url:"https://commons.wikimedia.org/wiki/User_talk:Jdx/Archive_4"},
    { title: "Wikipedia:Wikipedia Signpost/2020-05-31/In the media - Wikipedia" , statement:"Wikipedia sets new rule to combat  toxic behaviour  on the BBC  following a WMF press release  outlines how harassment and other abuse will ..." , url:"https://en.wikipedia.org/wiki/Wikipedia:Wikipedia_Signpost/2020-05-31/In_the_media"},
    { title:"Wikipedia:Wikipedia Signpost/2020-05-31/Op-Ed - Wikipedia" , statement:"BBC article Wikipedia sets new rule to combat  toxic behaviour   Gender bias on Wikipedia - you ll find your answers in those 2 articles  Bl..." , url:"https://en.wikipedia.org/wiki/Wikipedia:Wikipedia_Signpost/2020-05-31/Op-Ed"}
];function prevPage()
{
    if (current_page > 1) {
        current_page--;
        changePage(current_page);
    }
}function nextPage()
{
    if (current_page < numPages()) {
        current_page++;
        changePage(current_page);
    }
}function changePage(page)
{
    var btn_next = document.getElementById("btn_next");
    var btn_prev = document.getElementById("btn_prev");
    var listing_table = document.getElementById("listingTable");
    var page_span = document.getElementById("page");

    // Validate page
    if (page < 1) page = 1;
    if (page > numPages()) page = numPages();

    listing_table.innerHTML = "";

    for (var i = (page-1) * records_per_page; i < (page * records_per_page) && i < objJson.length; i++) {
        listing_table.innerHTML += "<b><a href=\""+objJson[i].url+"\"><font size=\"5\">"+objJson[i].title+"</font></a>"+ "</b><br>";
        listing_table.innerHTML += "<font color=\"green\">"+objJson[i].url+"</font><br>";
        listing_table.innerHTML += "<font color=\"black\" size=\"3\">"+objJson[i].statement+"</font><br>"+ "<br>";
    }
    page_span.innerHTML = page;

    if (page == 1) {
        btn_prev.style.visibility = "hidden";
    } else {
        btn_prev.style.visibility = "visible";
    }

    if (page == numPages()) {
        btn_next.style.visibility = "hidden";
    } else {
        btn_next.style.visibility = "visible";
    }
}
function numPages()
{
    return Math.ceil(objJson.length / records_per_page);
}

window.onload = function() {
    changePage(1);
};