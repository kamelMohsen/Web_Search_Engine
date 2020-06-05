var current_page = 1;
var records_per_page = 10;
var objJson = [
    { title: "The Official Home of CBBC - CBBC - BBC" , statement:"Copyright   2020 BBC  The BBC is not responsible for the content of external sites  Read about our approach to external linking..." , url:"https://www.bbc.co.uk/cbbc"},
    { title: "Games for kids and early years activities - CBeebies - BBC" , statement:"Copyright   2020 BBC  The BBC is not responsible for the content of external sites  Read about our approach to external linking..." , url:"https://www.bbc.co.uk/cbeebies"},
    { title: "BBC Food - Recipes and inspiration from your favourite BBC programmes and chefs" , statement:"Home News Sport Weather iPlayer Sounds CBBC CBeebies Food Bitesize Arts Taster Local Three Men..." , url:"https://www.bbc.co.uk/food"},
    { title: "Culture in Quarantine - BBC Arts" , statement:"Home News Sport Weather iPlayer Sounds CBBC CBeebies Food Bitesize Arts Taster Local Three Men..." , url:"https://www.bbc.co.uk/arts"},
    { title: "BBC Weather" , statement:"Vote for your favourite Weather Watchers photo of spring from our ten shortlisted images..." , url:"https://www.bbc.co.uk/weather"},
    { title: "BBC - Search" , statement:"Home News Sport Reel Worklife Travel Future Culture Music TV Weather Sound..." , url:"https://search.bbc.co.uk/search"},
    { title: "George Floyd: How the USA's history has shaped today's police brutality - BBC News" , statement:"Home News Sport Weather iPlayer Sounds CBBC CBeebies Food Bitesize Arts Taster Local Three Men..." , url:"https://www.bbc.com/news/52921989"},
    { title: "Coronavirus: Could more UK lives have been saved? - BBC News" , statement:"Home News Sport Weather iPlayer Sounds CBBC CBeebies Food Bitesize Arts Taster Local Three Men..." , url:"https://www.bbc.com/news/health-52926198"},
    { title: "George Floyd: Videos of police brutality during protests shock US - BBC News" , statement:"Home News Sport Weather iPlayer Sounds CBBC CBeebies Food Bitesize Arts Taster Local Three Men..." , url:"https://www.bbc.com/news/world-us-canada-52932611"},
    { title: "Africa's week in pictures: 29 May - 4 June 2020 - BBC News" , statement:"Home News Sport Weather iPlayer Sounds CBBC CBeebies Food Bitesize Arts Taster Local Three Men..." , url:"https://www.bbc.com/news/world-africa-52920374"},
    { title: "Coronavirus: Madagascar minister fired over $2m lollipop order - BBC News" , statement:"Home News Sport Weather iPlayer Sounds CBBC CBeebies Food Bitesize Arts Taster Local Three Men..." , url:"https://www.bbc.com/news/world-africa-52929925"},
    { title: "Premier League fixtures: BBC to show Bournemouth v Crystal Palace, Norwich v Everton - BBC Sport" , statement:"Home News Sport Weather iPlayer Sounds CBBC CBeebies Food Bitesize Arts Taster Local Three Men..." , url:"https://www.bbc.com/sport/football/52889445"},
    { title:"Jadon Sancho: Borussia Dortmund forward unhappy over haircut picture fine - BBC Sport" , statement:"Copyright   2020 BBC  The BBC is not responsible for the content of external sites  Read about our approach to external linking..." , url:"https://www.bbc.com/sport/football/52940654"}
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
        listing_table.innerHTML += "<div class=\"links\"><font color=\"green\">"+objJson[i].url+"</font></div>";
        listing_table.innerHTML += "<div class=\"description\"><font color=\"black\" size=\"3\">"+objJson[i].statement+"</font></div>"+ "<br>";
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