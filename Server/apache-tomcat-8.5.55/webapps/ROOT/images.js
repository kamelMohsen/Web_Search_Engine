var current_page = 1;
var records_per_page = 3;
var objJson = [
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-ck/400xn/amz/cbeebies/numberblocks-make-and-play-v2.jpg"},
    { src: "https://a1.api.bbc.co.uk/hit.xiti?&col=1&from=p&ptag=js&s=598253&p=world::us_and_canada::news.world.us_and_canada.story.52932611.page&x1=[urn:bbc:cps:6a7354af-0a9f-6747-9481-23b74bcd4872]&x2=[responsive]&x3=[bbc_website]&x4=[en]&x7=[article]&x8=[reverb-1.4.0-nojs]&x11=[NEWS_GNL]&x12=[NEWS]"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-live/r/400/1x/cbeebies/Dragons1.png"},
    { src: "https://childrens-web.files.bbci.co.uk/cbeebies/www/assets/bdc03c8/images/feedback/feedbackImage.png"},
    { src: "https://a1.api.bbc.co.uk/hit.xiti?&col=1&from=p&ptag=js&s=598253&p=health::news.health.correspondent_story.52926198.page&x1=[urn:bbc:cps:d0bbcb21-1e48-414c-8a92-56b6793e5a8d]&x2=[responsive]&x3=[bbc_website]&x4=[en]&x7=[article-correspondent]&x8=[reverb-1.4.0-nojs]&x11=[NEWS_GNL]&x12=[NEWS]"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-live/r/400/1x/cbbc/6-badges-of-summer-green-badge-promo_B.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p085vxd2.jpg"},
    { src: "https://ichef.bbci.co.uk//food/ic/food_16x9_832/chefs/rick_stein_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/lemon_and_poppy_seed_34146_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/halloumi_salad_19294_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/escalopeofchickenwit_92046_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/prawn_linguine_02687_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/grilledvegetableswit_91417_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p085vrjt.jpg"},
    { src: "https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/warm_orzo_prawn_and_feta_96794_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-ck/400xn/amz/cbeebies/dm-dash-game-cc-2017.jpg"},
    { src: "https://ichef.bbci.co.uk/news/832/cpsprodpb/DFAD/production/_112616275_hi024323144.jpg"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-ck/400xn/amz/cbeebies/hey-duggee-ivor-cc.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/720x405/p08fsnwq.jpg"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-live/r/400/1x/cbbc/BSP_a_z_index_template_SMU_S3_1.png"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-ck/400xn/amz/cbeebies/waffle-and-friends-game-cbeebies-cc.jpg"},
    { src: "https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/thai_chicken_curry_06763_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p08fqbs4.jpg"},
    { src: "https://ichef.bbci.co.uk//food/ic/food_16x9_832/chefs/rachel_phipps_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-live/r/400/1x/cbbc/BP-rally-racing-PromoB.jpg"},
    { src: "https://ichef.bbci.co.uk//food/ic/food_16x9_832/chefs/sumayya_usmani_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-live/r/400/1x/cbeebies/peter-rabbit-brand-shelf.png"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p0592zgs.jpg"},
    { src: "https://static.bbc.co.uk/news/1.315.03594/img/correspondents/circles/nicktriggle.png"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p08ffynn.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p019yg64.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p02c6m2k.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p08dy099.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/720x405/p08c9ppd.jpg"},
    { src: "https://a1.api.bbc.co.uk/hit.xiti?&col=1&from=p&ptag=js&s=598253&p=football::european::sport.football.european.story.52940654.page&x1=[urn:bbc:cps:35ee7106-2a1c-ed46-8c61-7414a91d3f96]&x2=[responsive]&x3=[bbc_website]&x4=[en]&x7=[article]&x8=[reverb-1.4.0-nojs]&x11=[SPORT_GNL]&x12=[SPORT]"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-live/r/400/1x/cbeebies/cbeebiesradio_treasurechamps_generic2_secondarypromo.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/720x405/p08g3cst.jpg"},
    { src: "https://ichef.bbci.co.uk/news/832/cpsprodpb/F8A9/production/_107775636_gettyimages-1069039692.jpg"},
    { src: "https://ichef.bbci.co.uk//food/ic/food_16x9_832/chefs/rupy_aujla_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p01h81hm.jpg"},
    { src: "https://childrens-web.files.bbci.co.uk/cbbc/www/assets/bdc03c8/images/feedback/feedbackImage.png"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-live/r/400/1x/cbeebies/Shaun-the-sheep.png"},
    { src: "//ssc.api.bbc.com/?c1=2&c2=19293874&ns_site=bbc&name="},
    { src: "https://a1.api.bbc.co.uk/hit.xiti?&col=1&from=p&ptag=js&s=598253&p=football::premier_league::sport.football.premier_league.story.52889445.page&x1=[urn:bbc:cps:c59dd46d-2e6c-5e41-bf0a-d708b9b4a6d0]&x2=[responsive]&x3=[bbc_website]&x4=[en]&x7=[article]&x8=[reverb-1.4.0-nojs]&x11=[SPORT_GNL]&x12=[SPORT]"},
    { src: "https://ichef.bbci.co.uk/onesport/cps/480/cpsprodpb/197F/production/_97772560_bbcsport_marketingpromo_generic.png"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p08fhx18.jpg"},
    { src: "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7"},
    { src: "https://ichef.bbci.co.uk/news/832/cpsprodpb/17041/production/_112637249_p08fvrj9.jpg"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-ck/400xn/amz/cbeebies/waffle-ivor-splash-cc.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p08g48mz.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/720x405/p08g68yv.jpg"},
    { src: "https://a1.api.bbc.co.uk/hit.xiti?&col=1&from=p&ptag=js&s=598253&p=world::africa::news.world.africa.story.52920374.page&x1=[urn:bbc:cps:74b968ed-2555-8b4e-942b-70c9e6d3706e]&x2=[responsive]&x3=[bbc_website]&x4=[en]&x7=[article]&x8=[reverb-1.4.0-nojs]&x11=[NEWS_GNL]&x12=[NEWS]"},
    { src: "https://a1.api.bbc.co.uk/hit.xiti?&col=1&from=p&ptag=js&s=598253&p=world::africa::news.world.africa.story.52929925.page&x1=[urn:bbc:cps:315fe8e2-c48b-c046-a1d8-478c69c9ba22]&x2=[responsive]&x3=[bbc_website]&x4=[en]&x7=[article]&x8=[reverb-1.4.0-nojs]&x11=[NEWS_GNL]&x12=[NEWS]"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p01b04sp.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/720x405/p08g4cm9.jpg"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-live/r/400/1x/cbeebies/something-special-stay-healthy-promo-b.jpg"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-ck/400xn/amz/cbeebies/Shining-stars-index2.jpg"},
    { src: "https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/slow-cooker_spring_09191_16x9.jpg"},
    { src: "https://a1.api.bbc.co.uk/hit.xiti?&col=1&from=p&ptag=js&s=598253&p=kl.arts.index.home.page&x1=[urn:bbc:arts:home]&x2=[responsive]&x3=[bbc_website]&x4=[en]&x7=[index-home]&x8=[reverb-1.4.0-nojs]&x11=[DEFAULT]&x12=[BBC]"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-ck/400xn/amz/cbbc/bp-spystory-masterclass.jpg"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-live/r/400/1x/cbeebies/numberblocks-egg-v4.png"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p06gqtp0.jpg"},
    { src: "http://b.scorecardresearch.com/p?c1=2&c2=17986528&cv=2.0&cj=1"},
    { src: "https://a1.api.bbc.co.uk/hit.xiti?&col=1&from=p&ptag=js&s=598253&p=unknown&x1=[urn:bbc:childrens:cbbc.page]&x2=[responsive]&x3=[bbc_website]&x4=[en]&x7=[index-home]&x8=[reverb-1.4.0-nojs]&x11=[cbbc]&x12=[cbbc]"},
    { src: "https://a1.api.bbc.co.uk/hit.xiti?&col=1&from=p&ptag=js&s=598253&p=unknown&x2=[responsive]&x3=[bbc_website]&x4=[en]&x8=[reverb-1.4.0-nojs]&x11=[weather_gnl]&x12=[weather]"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-live/r/400/1x/cbeebies/Dm-crossover-panel2.png"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-ck/400xn/amz/cbbc/raven_game_index_image.jpg"},
    { src: "https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/eggfriedrice_67782_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p0819m19.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p05wwd3q.jpg"},
    { src: "https://a1.api.bbc.co.uk/hit.xiti?&col=1&from=p&ptag=js&s=598253&p=world::us_and_canada::news.world.us_and_canada.media_asset.52921989.page&x1=[urn:bbc:cps:8a0df68a-aae1-9743-b9b5-b7d62246b873]&x2=[responsive]&x3=[bbc_website]&x4=[en]&x7=[article-media-asset]&x8=[reverb-1.4.0-nojs]&x11=[NEWS_GNL]&x12=[NEWS]"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p0476l29.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p085rz72.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/400xn/p05wjp0r.jpg"},
    { src: "https://a1.api.bbc.co.uk/hit.xiti?&col=1&from=p&ptag=js&s=598253&p=unknown&x1=[urn:bbc:childrens:cbeebies.page]&x2=[responsive]&x3=[bbc_website]&x4=[en]&x7=[index-home]&x8=[reverb-1.4.0-nojs]&x11=[cbeebies]&x12=[cbeebies]"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-ck/400xn/amz/cbbc/Alexis-Sanchez-hidden.jpg"},
    { src: "https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/avocado_salad_60227_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/aubergine_and_mozzarella_51464_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/sweet_potato_tray_bake_12879_16x9.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p085vbdm.jpg"},
    { src: "https://a1.api.bbc.co.uk/hit.xiti?&col=1&from=p&ptag=js&s=598253&p=Home::food.page&x1=[urn:bbc:food:home]&x2=[responsive]&x3=[bbc_website]&x4=[en]&x7=[index-home]&x8=[reverb-1.4.0-nojs]&x11=[FOOD]&x12=[FOOD]"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-live/r/400/1x/cbbc/tns-take-it-to-the-streets-dance-studio-promo_B.jpg"},
    { src: "https://ichef.bbci.co.uk/childrens-responsive-ichef-ck/400xn/amz/cbeebies/a_year_on_your_farm_content_card.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p08cytdm.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p05qs5zk.jpg"},
    { src: "https://ichef.bbci.co.uk/images/ic/832xn/p08fxphq.jpg"},
    { src:"https://ichef.bbci.co.uk/childrens-responsive-ichef-ck/400xn/amz/cbbc/elecktra-fruit-kebabs-cm_1024x576.jpg"}
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