var current_page = 1;
var records_per_page = 10;
var objJson = [
    { title: "Thailand's 50 Richest List" , statement:"   2020 Forbes Media LLC  All Rights Reserved..." , url:"https://www.forbes.com/thailand-billionaires/list/"},
    { title: "South Korea’s 50 Richest List" , statement:"   2020 Forbes Media LLC  All Rights Reserved..." , url:"https://www.forbes.com/korea-billionaires/list/"},
    { title: "Japan’s 50 Richest List" , statement:"   2020 Forbes Media LLC  All Rights Reserved..." , url:"https://www.forbes.com/japan-billionaires/list/"},
    { title: "Indonesia’s Richest 2019: Nation’s Wealthiest See Gains Despite Subdued Year" , statement:"Sign in to your Forbes account o..." , url:"https://www.forbes.com/indonesia-billionaires/"},
    { title: "Australia's Richest 2019: In A Down Year, Two Miners Break Back Into The Top 50" , statement:"Sign in to your Forbes account o..." , url:"https://www.forbes.com/australia-billionaires/"},
    { title: "India's Richest 2019: Fortune Favors A Few As Growth Slows" , statement:"Sign in to your Forbes account o..." , url:"https://www.forbes.com/india-billionaires/"},
    { title: "Philippines' Richest 2019: With A Notable Five Deceased, A New Generation Takes The Helm" , statement:"Sign in to your Forbes account o..." , url:"https://www.forbes.com/philippines-billionaires/"},
    { title: "Taiwan’s Richest 2020: Modest Gains For The 50 Richest" , statement:"Sign in to your Forbes account o..." , url:"https://www.forbes.com/taiwan-billionaires/"},
    { title: "Malaysia's Richest 2019: Multiple Factors Erode Fortunes Of Nation's Wealthiest" , statement:"Sign in to your Forbes account o..." , url:"https://www.forbes.com/malaysia-billionaires/"},
    { title: "The Net Worth Of Every 2020 Presidential Candidate" , statement:"Sign in to your Forbes account o..." , url:"https://www.forbes.com/sites/danalexander/2019/08/14/heres-the-net-worth-of-every-2020-presidential-candidate/"},
    { title: "Forbes" , statement:"  2020 Forbes Media LLC  All Rights Reserved  Terms and ConditionsPrivacy StatementMarket Data by MorningstarAdChoice..." , url:"https://www.forbes.com/"},
    { title: "Enterprise Tech" , statement:"Billionaires All Billionaires World s Billionaires Forbes 400 America s Richest Self Made Women China s Richest India s Richest Indonesia s ..." , url:"https://www.forbes.com/enterprise-tech/"},
    { title: "Worlds Billionaires" , statement:"Billionaires All Billionaires World s Billionaires Forbes 400 America s Richest Self Made Women China s Richest India s Richest Indonesia s ..." , url:"https://www.forbes.com/worlds-billionaires/"},
    { title: "Innovation" , statement:"Billionaires All Billionaires World s Billionaires Forbes 400 America s Richest Self Made Women China s Richest India s Richest Indonesia s ..." , url:"https://www.forbes.com/innovation/"},
    { title: "Money & Politics" , statement:"Billionaires All Billionaires World s Billionaires Forbes 400 America s Richest Self Made Women China s Richest India s Richest Indonesia s ..." , url:"https://www.forbes.com/money-politics/"},
    { title: "5G" , statement:"Billionaires All Billionaires World s Billionaires Forbes 400 America s Richest Self Made Women China s Richest India s Richest Indonesia s ..." , url:"https://www.forbes.com/5g/"},
    { title: "Big Data" , statement:"Billionaires All Billionaires World s Billionaires Forbes 400 America s Richest Self Made Women China s Richest India s Richest Indonesia s ..." , url:"https://www.forbes.com/big-data/"},
    { title: "Cybersecurity" , statement:"Billionaires All Billionaires World s Billionaires Forbes 400 America s Richest Self Made Women China s Richest India s Richest Indonesia s ..." , url:"https://www.forbes.com/cybersecurity/"},
    { title: "AI" , statement:"Billionaires All Billionaires World s Billionaires Forbes 400 America s Richest Self Made Women China s Richest India s Richest Indonesia s ..." , url:"https://www.forbes.com/ai/"},
    { title: "Consumer Tech" , statement:"Billionaires All Billionaires World s Billionaires Forbes 400 America s Richest Self Made Women China s Richest India s Richest Indonesia s ..." , url:"https://www.forbes.com/consumer-tech/"},
    { title: "Cloud" , statement:"Billionaires All Billionaires World s Billionaires Forbes 400 America s Richest Self Made Women China s Richest India s Richest Indonesia s ..." , url:"https://www.forbes.com/cloud/"},
    { title:"Everbridge BrandVoice" , statement:"Billionaires All Billionaires World s Billionaires Forbes 400 America s Richest Self Made Women China s Richest India s Richest Indonesia s Richest K..." , url:"https://www.forbes.com/sites/everbridge/#de1e83e640f6"}
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