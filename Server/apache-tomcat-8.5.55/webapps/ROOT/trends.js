anychart.onDocumentReady(function() {

 var data = {
    header: ["Name", "Hits"],
   rows: [
["DONALD TRUMP",24],
["MOHAMMED HAKEEM",21],
["KAMEL MOHSEN",16],
["AHMED NADER",11],
["OMAR TAHER",10],
["YARA SALEM",9],
["JOHN WATSON",6],
["MESSI",4],
["KAMEL",2],
["ANGELINA JOLIE",1]
]};    var chart = anychart.column();
    chart.data(data);
    chart.title("Trends in : Afghanistan");
    chart.container("container");
    chart.draw();
  });