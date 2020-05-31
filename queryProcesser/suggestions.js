 //getStates = async () =>  {
  //const res = await fetch('C:\Users\Yara\Downloads\APT\Web_Search_Engine\queryProcesser\Data.json');
   //const states = await res.json();
   //return states;
 //}
 jQuery.getJSON('C:\Users\Yara\Downloads\APT\Web_Search_Engine\queryProcesser\Data.json');
//const states = getStates('C:\Users\Yara\Downloads\APT\Web_Search_Engine\queryProcesser\Data.json');
const inputQuery = document.querySelector('.box');
 const suggestionsPanel = document.querySelector('.Suggestions');
inputQuery.addEventListener('keyup',function(){
  const input = inputQuery.value;
  suggestionsPanel.innerHTML="";
  const sug = myList.filter(function(states){
    return states.data.toLowerCase().startsWith(inputQuery);
  });
  sug.forEach(function(suggested){
    const div = document.createElement('div');
    div.innerHTML = suggested.firststatement;
    suggestionsPanel.appendChild(div);
  });
  if(input=="")
  {
    suggestionsPanel.innerHTML="";
  }
});


