 //getStates = async () =>  {
  //const res = await fetch('C:\Users\Yara\Downloads\APT\Web_Search_Engine\queryProcesser\Data.json');
   //const states = await res.json();
   //return states;
 //}
 //const states = getStates('C:\Users\Yara\Downloads\APT\Web_Search_Engine\queryProcesser\Data.json');
 //------------------
 const listItems = ["item1","item2"]; //gahz el 7aga ely hatet3rd
const place = document.getElementById('suggestionsList'); //at html , get from html , l makan ely htet3rd fihh
place.innerHTML =""; // make sure enena nefdeeha fl awaal
// document.querySelector('.box').addEventListener('keyup', async ()=>{
const suggestions = jQuery.getJSON('http://localhost:8080/suggestions');
Console.log(suggestions);
  let item_element = document.createElement('div');
		item_element.classList.add('item');
		item_element.innerText = item;
		
	wrapper.appendChild(item_element);
  suggestions = JSON.parse;
  let suggestionHTML ='';
  suggestions.suggestionHTML;
  <ul>
    <li>suggestions[0]</li>
  </ul>
 
  const suggestionsPanel = document.querySelector('.Suggestions').innerHTML(suggestionHTML);
//})
//---------------------------------------

//   inputQuery.addEventListener('keyup', async (){
//   const input = inputQuery.value;
//   suggestionsPanel.innerHTML="";
//   const sug = myList.filter(function(states){
//     return states.data.toLowerCase().startsWith(inputQuery);
//   });
//   sug.forEach(function(suggested){
//     const div = document.createElement('div');
//     div.innerHTML = suggested.firststatement;
//     suggestionsPanel.appendChild(div);
//   });
//   if(input=="")
//   {
//     suggestionsPanel.innerHTML="";
//   }
// });



