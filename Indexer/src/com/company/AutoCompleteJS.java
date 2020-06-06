package com.company;

import com.mongodb.*;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
@SuppressWarnings("All")
public class AutoCompleteJS {
    public static  String Path = "F:/Tech/CUFE_CHS/Spring 2020/Advance Programming Techniques/Project/Web_Search_Engine/Server/apache-tomcat-8.5.55/webapps/ROOT";

    public static void main(String[] args) throws IOException {
        MongoClient mongoClient;
        DB NGramDB;
        DBCollection NGramCollection;
        mongoClient = new com.mongodb.MongoClient("localhost", 27017);
        NGramDB = mongoClient.getDB("NGramDB");
        NGramCollection = NGramDB.getCollection("NGram_table");
        List<String> ngrams = new LinkedList<>();


        DBCursor cur = NGramCollection.find();
        int size = cur.size();
        for (int i = 0; i < size; i++) {
            DBObject doc = cur.next();
            String nGram = (String) doc.get("NGram");
            ngrams.add(nGram);

        }
        createAutoCompleteJSFile(ngrams,Path);

    }


    static void createAutoCompleteJSFile(@NotNull List<String> ngrams, String Path){


        try {

            FileWriter myWriter = new FileWriter(Path+"/autocomplete.js");
            myWriter.write("function autocomplete(inp, arr) {\n" +
                    "  /*the autocomplete function takes two arguments,\n" +
                    "  the text field element and an array of possible autocompleted values:*/\n" +
                    "  var currentFocus;\n" +
                    "  /*execute a function when someone writes in the text field:*/\n" +
                    "  inp.addEventListener(\"input\", function(e) {\n" +
                    "      var a, b, i, val = this.value;\n" +
                    "\t  var count = 0;" +
                    "      /*close any already open lists of autocompleted values*/\n" +
                    "      closeAllLists();\n" +
                    "      if (!val) { return false;}\n" +
                    "      currentFocus = -1;\n" +
                    "      /*create a DIV element that will contain the items (values):*/\n" +
                    "      a = document.createElement(\"DIV\");\n" +
                    "      a.setAttribute(\"id\", this.id + \"autocomplete-list\");\n" +
                    "      a.setAttribute(\"class\", \"autocomplete-items\");\n" +
                    "      /*append the DIV element as a child of the autocomplete container:*/\n" +
                    "      this.parentNode.appendChild(a);\n" +
                    "      /*for each item in the array...*/\n" +
                    "\t  count = 0 ;" +
                    "      for (i = 0; i < arr.length; i++) {\n" +
                    "        /*check if the item starts with the same letters as the text field value:*/\n" +
                    "        if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {\n" +
                    "\t\t  if(count<=3){"+
                    "          /*create a DIV element for each matching element:*/\n" +
                    "          b = document.createElement(\"DIV\");\n" +
                    "          /*make the matching letters bold:*/\n" +
                    "          b.innerHTML = \"<strong>\" + arr[i].substr(0, val.length) + \"</strong>\";\n" +
                    "          b.innerHTML += arr[i].substr(val.length);\n" +
                    "          /*insert a input field that will hold the current array item's value:*/\n" +
                    "          b.innerHTML += \"<input type='hidden' value='\" + arr[i] + \"'>\";\n" +
                    "          /*execute a function when someone clicks on the item value (DIV element):*/\n" +
                    "          b.addEventListener(\"click\", function(e) {\n" +
                    "              /*insert the value for the autocomplete text field:*/\n" +
                    "              inp.value = this.getElementsByTagName(\"input\")[0].value;\n" +
                    "              /*close the list of autocompleted values,\n" +
                    "              (or any other open lists of autocompleted values:*/\n" +
                    "              closeAllLists();\n" +
                    "          });\n" +
                    "          a.appendChild(b);\n" +
                    "\t\t  }\n" +
                    "\t\t  count = count + 1 ;" +
                    "        }\n" +
                    "      }\n" +
                    "  });\n" +
                    "  /*execute a function presses a key on the keyboard:*/\n" +
                    "  inp.addEventListener(\"keydown\", function(e) {\n" +
                    "      var x = document.getElementById(this.id + \"autocomplete-list\");\n" +
                    "      if (x) x = x.getElementsByTagName(\"div\");\n" +
                    "      if (e.keyCode == 40) {\n" +
                    "        /*If the arrow DOWN key is pressed,\n" +
                    "        increase the currentFocus variable:*/\n" +
                    "        currentFocus++;\n" +
                    "        /*and and make the current item more visible:*/\n" +
                    "        addActive(x);\n" +
                    "      } else if (e.keyCode == 38) { //up\n" +
                    "        /*If the arrow UP key is pressed,\n" +
                    "        decrease the currentFocus variable:*/\n" +
                    "        currentFocus--;\n" +
                    "        /*and and make the current item more visible:*/\n" +
                    "        addActive(x);\n" +
                    "      } else if (e.keyCode == 13) {\n" +
                    "        /*If the ENTER key is pressed, prevent the form from being submitted,*/\n" +
                    "        e.preventDefault();\n" +
                    "        if (currentFocus > -1) {\n" +
                    "          /*and simulate a click on the \"active\" item:*/\n" +
                    "          if (x) x[currentFocus].click();\n" +
                    "        }\n" +
                    "      }\n" +
                    "  });\n" +
                    "  function addActive(x) {\n" +
                    "    /*a function to classify an item as \"active\":*/\n" +
                    "    if (!x) return false;\n" +
                    "    /*start by removing the \"active\" class on all items:*/\n" +
                    "    removeActive(x);\n" +
                    "    if (currentFocus >= x.length) currentFocus = 0;\n" +
                    "    if (currentFocus < 0) currentFocus = (x.length - 1);\n" +
                    "    /*add class \"autocomplete-active\":*/\n" +
                    "    x[currentFocus].classList.add(\"autocomplete-active\");\n" +
                    "  }\n" +
                    "  function removeActive(x) {\n" +
                    "    /*a function to remove the \"active\" class from all autocomplete items:*/\n" +
                    "    for (var i = 0; i < x.length; i++) {\n" +
                    "      x[i].classList.remove(\"autocomplete-active\");\n" +
                    "    }\n" +
                    "  }\n" +
                    "  function closeAllLists(elmnt) {\n" +
                    "    /*close all autocomplete lists in the document,\n" +
                    "    except the one passed as an argument:*/\n" +
                    "    var x = document.getElementsByClassName(\"autocomplete-items\");\n" +
                    "    for (var i = 0; i < x.length; i++) {\n" +
                    "      if (elmnt != x[i] && elmnt != inp) {\n" +
                    "        x[i].parentNode.removeChild(x[i]);\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }\n" +
                    "  /*execute a function when someone clicks in the document:*/\n" +
                    "  document.addEventListener(\"click\", function (e) {\n" +
                    "      closeAllLists(e.target);\n" +
                    "  });\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "/* to show and hide the countries list */ \n" +
                    "function myFunction() {\n" +
                    "  var x = document.getElementById(\"Trends\").checked;\n" +
                    "   var i  = document.getElementById(\"ImagesSearch\").checked;\n" +
                    "   var s  = document.getElementById(\"Search\").checked;\n" +
                    "  var y = document.getElementById(\"country\");\n" +
                    " \n" +
                    "  if (x.style.display === \"none\") {\n" +
                    "    y.style.display = \"block\";\n" +
                    "  } else {\n" +
                    "    y.style.display = \"none\";\n" +
                    "  }\n" +
                    "}\n" +
                    "\n" +
                    "/*An array containing all the country names in the world:*/\n" +
                    "var countries = [\n");
            for(int i = 0 ; i < ngrams.size(); i++){
                if(i== ngrams.size()-1){

                    myWriter.write("    \"" + ngrams.get(i).replaceAll("\\n|\\\t","").replaceAll("\"","")+"\"\n");
                }
                else {
                    myWriter.write("    \"" + ngrams.get(i).replaceAll("\\n|\\\t","").replaceAll("\"","") + "\",\n");
                }
            }
            myWriter.write("];\n\n");
            myWriter.write("autocomplete(document.getElementById(\"myInput\"), countries);");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}

