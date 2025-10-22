btnAddTab.onclick=ajouterTableau;


document.getElementById("input-prenom").onkeyup=verifInput;

function verifInput(event)
{
  let prenom=document.getElementById("input-prenom").value;
  if(prenom=="")
  {
    btnAddTab.disabled=true;
    prenomStatut.style.backgroundColor="red";
  }
  else
  {
    if(event.keyCode==13 || event.key=="Enter")
    {
      ajouterTableau();
    }
    else{
      btnAddTab.disabled=false;
      prenomStatut.style.backgroundColor="green";
    }
  }
}

function ajouterTableau()
{
let prenom=document.getElementById("input-prenom").value;
demoTableau.innerHTML+=`<tr><td>${prenom}</td></tr>`;
document.getElementById("input-prenom").value="";
btnAddTab.disabled=true;
prenomStatut.style.backgroundColor="red";
}
