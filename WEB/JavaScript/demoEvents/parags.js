
//titreEvent.onmousemove=function(){console.log("move sur titre");};
document.getElementById("titreEvent").onmouseover=zoomParag;
document.getElementById("titreEvent").onmouseout=zoomParag;
document.getElementById("titreEvent").onclick=zoomParag;
couleurParag.onchange=function()
{
  paragEvent.style.color = couleurParag.value
}
btnReset.onclick=function()
{
  paragEvent.style.color="#000000";
  couleurParag.value="#000000";
}

//Les fonctions demoInlineJS,ZoomParag sont à l'ecoute de certains events => Listener
function demoInlineJS(nb)
{
  alert("click sur le 1er parag avec "+nb);
}
function zoomParag(event)
{
  //console.log("On est dans la fonction")
  if(event.type=="mouseover")
  {
    document.getElementById("paragEvent").style.fontSize="35px";
  }
  else if(event.type=="mouseout")
  {
    document.getElementById("paragEvent").style.fontSize="16px";
  }
  else if(event.type=="click")
  {
    document.getElementById("paragEvent").style.border="solid black 1px";
  }
}
