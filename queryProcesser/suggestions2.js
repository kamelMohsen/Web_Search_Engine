
const inputQuery = document.getElementsByClassName('.box');
const suggestionsPanel = document.getElementById('.Suggestions');

const searchStates = async searchText =>{

//search Data,json file and filter it
const res = await fetch('C:\Users\Yara\Downloads\APT\Web_Search_Engine\queryProcesser\Data.json');
const states = await res.json();

//Get matches

let matches = states.filter(state => {
    const regex = new RegExp(`^${searchText}` , `gi`);
    return state.frequency.match(regex) || state.docID.match(regex);
});

if(searchText.length == 0)
{
    matches =[];
    suggestionsPanel.innerHTML ="";
}
 outputHtml(matches);
};

//show results in hTML
const outputHtml = matches => {
    if(matches.length >0)
    {
      const html = matches 
      .map(
          match => `<div class="card card-body mb-1">
          <h4>${match.docID} (${match.firststatement}) <span class="text-primary">
          ${match.firststatement}</span></h4>
          <small>lat: ${match.firststatement}/Long: ${match.firststatement}</small>
          </diV>`

      ).join('');
      suggestionsPanel.innerHTML = html;
    }
};
search.addEvenEventListner('input',()=> searchStates(search.value));