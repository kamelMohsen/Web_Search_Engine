const inputQuery = document.querySelector('.box');
  const suggestionsPanel = document.querySelector('.Suggestions');
 inputQuery.addEventListener('keyup',function(){
   const input = inputQuery.value;
   suggestionsPanel.innerHTML="";
   const sug = myList.filter(function(country){
     return country.name.toLowerCase().startsWith(input);
   });
   sug.forEach(function(suggested){
     const div = document.createElement('div');
     div.innerHTML = suggested.name;
     suggestionsPanel.appendChild(div);
   });
   if(input=="")
   {
     suggestionsPanel.innerHTML="";
   }
 });