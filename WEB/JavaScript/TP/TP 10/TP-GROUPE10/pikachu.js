//5) Verifier que pikachu ne sort pas de la div grass

document.getElementById("inputName").onkeyup=verifInput;
document.getElementById("btnStart").onclick=debutJeu;

var posX=0;
var posY=0;
var mouvement=30;
var countY = 0;
var countX = 0;
var tentativesSortie = 0;
var maxTentatives = 3;
var pokemon="pikachu";
var direction="Down";
imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

function verifInput(event)
{
  let prenom=document.getElementById("inputName").value;
  if(prenom=="")
  {
    btnStart.disabled=true;
  }
  else
  {
    if(event.key=="Enter")
    {
      debutJeu();
    }
    else{
      btnStart.disabled=false;
    }
  }
}

function debutJeu()
{
  pikachu.setAttribute("title",document.getElementById("inputName").value);
  document.getElementById("grass").style.display = "block";
  document.getElementById("info").style.display = "block";
  document.getElementById("formStart").style.display = "none";
  //document.getElementById("pikachu").onmouseover = displayPrenom;
  document.addEventListener("keydown", deplacement);
  document.getElementById("grass").style.height = "700px";
  document.getElementById("grass").style.width = "700px";
  themePokemon.play();
}
/*function displayPrenom{
  pikachu
}*/

function deplacement(event)
{
  let countX = 0;
  let countY = 0;

  let height = grass.style.height.slice(0,grass.style.height.length-2);
  let width = grass.style.width.slice(0,grass.style.width.length-2);
  
  var newPosX = posX;
  var newPosY = posY;

  if(event.key=="ArrowDown" || event.key=="s" )
  {
    newPosY += mouvement;
    direction = "Down";
  }
  else if(event.key=="ArrowRight" || event.key=="d" )
  {
    newPosX += mouvement;
    direction = "Right";
  }
  else if(event.key=="ArrowLeft" || event.key=="q" )
  {
    newPosX -= mouvement;
    direction = "Left";
  }
  else if(event.key=="ArrowUp" || event.key=="z" )
  {
    newPosY -= mouvement;
    direction = "Up";
  }

  // Vérifier les limites de la div grass (700px x 700px)
  if(newPosX >= 0 && newPosX <= 670 && newPosY >= 0 && newPosY <= 670)
  {
    posX = newPosX;
    posY = newPosY;
    pikachu.style.top=posY+"px";
    pikachu.style.left=posX+"px";
  }
  else
  {
    // Tentative de sortie du cadre
    tentativesSortie++;
    if(tentativesSortie >= maxTentatives)
    {
      meme();
    }
  }

  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
  imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");
  

}

//ajoute une fonction qui lorsqu'on est en jeu, en faisant haut haut bas bas gauche droite gauche droite ouvre une fenetre dans un lien
document.addEventListener("keydown", (function() {
  var konamiCode = ['ArrowUp', 'ArrowUp', 'ArrowDown', 'ArrowDown', 'ArrowLeft', 'ArrowRight', 'ArrowLeft', 'ArrowRight'];
  var index = 0;
  return function(event) {
    if (event.key === konamiCode[index]) {
      index++;
      if (index === konamiCode.length) {
        window.open('https://www.linkedin.com/in/jordan-abid-711365a6/?originalSubdomain=fr');
        index = 0;
      }
    } else {
      index = 0;
    }
  };
})());

function meme() {

  document.body.style.backgroundImage = "url('assets/img/meme.png')";
  document.body.style.backgroundSize = "500px 500px";
  //document.body.style.backgroundRepeat = "repeat";
  themePokemon.src = "assets/audio/meme.mp3";
  themePokemon.play();
}