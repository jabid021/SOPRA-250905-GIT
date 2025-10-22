//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX=0;
var posY=0;
var mouvement=30;
var pokemon="pikachu";
var direction="Down";
imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

document.getElementById("inputName").onkeyup=verifInput;
btnStart.onclick=startGame;
document.getElementById("imgPikachu").onmouseover=displayTitle;

function displayTitle(event){
  document.getElementById("imgPikachu").setAttribute("title", document.getElementById("inputName").value)
}

function verifInput(event)
{
  let name=document.getElementById("inputName").value;
  if(name=="")
  {
    btnStart.disabled=true;
  }
  else{
      if(event.keyCode==13 || event.key=="Enter"){
        startGame();
      }
      else{
        btnStart.disabled=false;
      }
}
}

function startGame(event){

  document.getElementById("grass").style.display= "inline-block";
  document.getElementById("formStart").style.display= "none";
  document.body.onkeydown=deplacement;
}

function deplacement(event)
{
  if(event.key=="ArrowDown" || event.key=="s" )
  {
    if(posY<660){
    posY+=mouvement;
    
    }
    imgPikachu.setAttribute("src", "assets/img/pikachuDown.png");
  }
  else if(event.key=="ArrowRight" || event.key=="d" )
  {
    if(posX<660){
    posX+=mouvement;
    }
    imgPikachu.setAttribute("src", "assets/img/pikachuRight.png");
  }

  else if(event.key=="ArrowLeft" || event.key=="q")
  {
    if(posX>0){
    posX-=mouvement;
    
    }
    imgPikachu.setAttribute("src", "assets/img/pikachuLeft.png");
  }

  else if(event.key=="ArrowUp" || event.key=="z")
  {
    if(posY>0){
    posY-=mouvement;
    
    }
    imgPikachu.setAttribute("src", "assets/img/pikachuUp.png");
  }
  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
  console.log(`position x et y  : ${posX} et ${posY}`);
 

}
