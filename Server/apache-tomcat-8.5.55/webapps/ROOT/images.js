var current_page = 1;
var records_per_page = 3;
var objJson = [
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Donald_Trump_star_Hollywood_Walk_of_Fame.JPG/130px-Donald_Trump_star_Hollywood_Walk_of_Fame.JPG"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Kim_and_Trump_shaking_hands_at_the_red_carpet_during_the_DPRK%E2%80%93USA_Singapore_Summit.jpg/220px-Kim_and_Trump_shaking_hands_at_the_red_carpet_during_the_DPRK%E2%80%93USA_Singapore_Summit.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Women%27s_March_on_Washington_%2832593123745%29.jpg/220px-Women%27s_March_on_Washington_%2832593123745%29.jpg"},
    { src: "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/President_Trump_Postlaunch_Remarks_%28NHQ202005300071%29.jpg/120px-President_Trump_Postlaunch_Remarks_%28NHQ202005300071%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/1/1d/JANUS-T%C3%AAte-%C3%A0-T%C3%AAte-_Sitting_President_%26_President-elect%2C_Barack_Obama_%26_Donald_Trump_squatting_next_to_each_other_on_arm-chairs_in_the_Oval_Office_on_November_10th_2016._%2831196987133%29.jpg/220px-thumbnail.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/4/44/President_Trump_Signs_the_Congressional_Funding_Bill_for_Coronavirus_Response_%2849627907646%29.jpg/220px-President_Trump_Signs_the_Congressional_Funding_Bill_for_Coronavirus_Response_%2849627907646%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/d/d9/White_House_Press_Briefing_%2849666120807%29.jpg/220px-White_House_Press_Briefing_%2849666120807%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/f/fb/President_Trump_Visits_St._John%27s_Episcopal_Church_%2849963649028%29.jpg/220px-President_Trump_Visits_St._John%27s_Episcopal_Church_%2849963649028%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/0/04/2017-_Donald_Trump_veracity_-_composite_graph.png/330px-2017-_Donald_Trump_veracity_-_composite_graph.png"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/8/8b/President_Trump_visit_to_Israel_May_22-23%2C_2017_DSC_3982F_%2834847749905%29.jpg/220px-President_Trump_visit_to_Israel_May_22-23%2C_2017_DSC_3982F_%2834847749905%29.jpg"},
    { src: "https://ichef.bbci.co.uk/news/200/cpsprodpb/1BEE/production/_112705170_p08g03wb.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Donald_Trump_speaking_at_CPAC_2011_by_Mark_Taylor_2.jpg/220px-Donald_Trump_speaking_at_CPAC_2011_by_Mark_Taylor_2.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Donald_Trump_Cabinet_meeting_2017-03-13_04.jpg/220px-Donald_Trump_Cabinet_meeting_2017-03-13_04.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Trump_AVM_opening_ceremony.jpg/220px-Trump_AVM_opening_ceremony.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/7/74/Donald_Trump_and_Mike_Pence_RNC_July_2016.jpg/220px-Donald_Trump_and_Mike_Pence_RNC_July_2016.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Abdel_Fattah_el-Sisi%2C_King_Salman_of_Saudi_Arabia%2C_Melania_Trump%2C_and_Donald_Trump%2C_May_2017.jpg/220px-Abdel_Fattah_el-Sisi%2C_King_Salman_of_Saudi_Arabia%2C_Melania_Trump%2C_and_Donald_Trump%2C_May_2017.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/5/53/Donald_Trump_official_portrait_%28cropped%29.jpg/75px-Donald_Trump_official_portrait_%28cropped%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/4/40/President_Trump_Visits_with_the_Interim_President_of_the_Bolivarian_Republic_of_Venezuela_to_the_White_House_%2849494079201%29.jpg/220px-President_Trump_Visits_with_the_Interim_President_of_the_Bolivarian_Republic_of_Venezuela_to_the_White_House_%2849494079201%29.jpg"},
    { src: "https://specials-images.forbesimg.com/imageserve/5e83e5ccdec0860006dbf54e/1920x0.jpg?fit=scale"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/3/36/Seal_of_the_President_of_the_United_States.svg/70px-Seal_of_the_President_of_the_United_States.svg.png"},
    { src: "https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/President_Trump_at_the_Kennedy_Space_Center_%2849945868427%29.jpg/120px-President_Trump_at_the_Kennedy_Space_Center_%2849945868427%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Donald_Trump_Signature.svg/128px-Donald_Trump_Signature.svg.png"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/d/d0/President_Trump_at_the_G20_%2848144045996%29.jpg/220px-President_Trump_at_the_G20_%2848144045996%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/e/ec/ElectoralCollege2016.svg/330px-ElectoralCollege2016.svg.png"},
    { src: "https://ichef.bbci.co.uk/news/240/cpsprodpb/10497/production/_112611766_gettyimages-1240552131.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/3/30/Trump_Tower_-_lower_part.jpg/170px-Trump_Tower_-_lower_part.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/3/3a/President_Trump_Meets_with_the_President_of_Turkey_%2849060819653%29.jpg/220px-President_Trump_Meets_with_the_President_of_Turkey_%2849060819653%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/7/75/Trump_Family_Hand_Up.jpg/220px-Trump_Family_Hand_Up.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/e/e5/President_Donald_Trump_suggests_measures_to_treat_COVID-19_during_Coronavirus_Task_Force_press_briefing.webm/220px-seek%3D59-President_Donald_Trump_suggests_measures_to_treat_COVID-19_during_Coronavirus_Task_Force_press_briefing.webm.jpg"},
    { src: "https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/President_Trump_Departs_for_Florida_%2849942688302%29.jpg/120px-President_Trump_Departs_for_Florida_%2849942688302%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/2/2b/58th_Presidential_Inaugural_Ceremony_170120-D-BP749-1327.jpg/220px-58th_Presidential_Inaugural_Ceremony_170120-D-BP749-1327.jpg"},
    { src: "https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/President_Trump_Postlaunch_Remarks_%28NHQ202005300033%29.jpg/120px-President_Trump_Postlaunch_Remarks_%28NHQ202005300033%29.jpg"},
    { src: "https://c.files.bbci.co.uk/0C4F/production/_112615130_trump_tweet.jpg?v=1.0.34"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Chicago_September_2016-2.jpg/170px-Chicago_September_2016-2.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Donald_Trump_NYMA.jpg/150px-Donald_Trump_NYMA.jpg"},
    { src: "https://s0.wp.com/wp-content/themes/vip/pmc-variety-2020/assets/public/lazyload-fallback.gif"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/3/33/-G7Biarritz_%2848616362963%29.jpg/220px--G7Biarritz_%2848616362963%29.jpg"},
    { src: "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/President_Trump_Postlaunch_Remarks_%28NHQ202005300070%29.jpg/120px-President_Trump_Postlaunch_Remarks_%28NHQ202005300070%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/4/46/Donald_Trump_visits_San_Diego_border_wall_prototypes.jpg/200px-Donald_Trump_visits_San_Diego_border_wall_prototypes.jpg"},
    { src: "https://s2.wp.com/wp-content/themes/vip/pmc-variety-2020/assets/public/lazyload-fallback.gif"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/8/88/Donald_Trump_and_Bill_Clinton.jpg/220px-Donald_Trump_and_Bill_Clinton.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/d/dc/President_Donald_Trump_and_Secretary_General_Jens_Stolenberg_Joint_Press_Conference%2C_April_12%2C_2017_%2801%29.jpg/220px-President_Donald_Trump_and_Secretary_General_Jens_Stolenberg_Joint_Press_Conference%2C_April_12%2C_2017_%2801%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Donald_Trump_in_Ypsilanti_%2833998674940%29_%28cropped2%29.jpg/220px-Donald_Trump_in_Ypsilanti_%2833998674940%29_%28cropped2%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/5/53/Donald_Trump_official_portrait_%28cropped%29.jpg/220px-Donald_Trump_official_portrait_%28cropped%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/d/d8/Mar-a-lago_in_2009.jpg/220px-Mar-a-lago_in_2009.jpg"},
    { src: "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/President_Trump_at_the_Kennedy_Space_Center_%2849945580396%29.jpg/120px-President_Trump_at_the_Kennedy_Space_Center_%2849945580396%29.jpg"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/0/04/President_Trump%27s_First_100_Days-_45_%2833573172373%29.jpg/220px-President_Trump%27s_First_100_Days-_45_%2833573172373%29.jpg"},
    { src: "https://c.files.bbci.co.uk/BF91/production/_112614094_trump_01june_epa.jpg?v=1.0.34"},
    { src: "//upload.wikimedia.org/wikipedia/commons/thumb/3/30/Ivana_Trump_shakes_hands_with_Fahd_of_Saudi_Arabia.jpg/220px-Ivana_Trump_shakes_hands_with_Fahd_of_Saudi_Arabia.jpg"},
    { src: "https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/President_Trump_Postlaunch_Remarks_%28NHQ202005300072%29.jpg/120px-President_Trump_Postlaunch_Remarks_%28NHQ202005300072%29.jpg"},
    { src:"https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/President_Trump_Postlaunch_Remarks_%28NHQ202005300069%29.jpg/120px-President_Trump_Postlaunch_Remarks_%28NHQ202005300069%29.jpg"}
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

    for (var i = (page-1) * records_per_page; i < ((page * records_per_page) ) && i < objJson.length-1; i+=2) {
        listing_table.innerHTML += "<img alt=\"no descrption\" src=\""+objJson[i].src+"\" class=\"img-itml\" >";
        listing_table.innerHTML += "<img alt=\"no descrption\" src=\""+objJson[i+1].src+"\" class=\"img-itmr\"><br>"+"";
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