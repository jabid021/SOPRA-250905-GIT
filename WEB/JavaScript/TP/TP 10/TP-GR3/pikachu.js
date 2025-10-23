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
var myInterval;
var laDancePika = "assets/img/pikachuBack.png";
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
  
  if(posX == 330 && posY == 330){
      jigglypuffSings();
      setTimeout(stopDance, 10000);
      var myInterval;
      jouerMusique2();
      } else {
      jouerMusique1();
    }

}

function jigglypuffSings(){
  document.getElementById("imgPikachu").setAttribute("width","50px");
  document.getElementById("imgPikachu").setAttribute("height","50px");
  console.log("On rentre dans la fonction");
  myInterval = setInterval(dancePika, 250);
  
}

function dancePika(){
    laDancePika=(laDancePika=="assets/img/pikachuBack.png")? "assets/img/pikachuBackRight.png":"assets/img/pikachuBack.png";
    imgPikachu.setAttribute("src", laDancePika);
}

function stopDance (){
  clearInterval(myInterval);
  document.getElementById("imgJigglypuff").setAttribute("src","assets/img/jigglypuffGoogles.png");
}

document.getElementById("btnStart").addEventListener("click", () => {
let m1 = document.getElementById("music1");
m1.play();
m1.volume = 0.1;
});


function jouerMusique1() {
  let m1 = document.getElementById("music1");
  let m2 = document.getElementById("music2");

  
  if (m1.paused) {
    m1.pause();
    m1.play();
    m1.volume = 0.1;
  }
}

function jouerMusique2() {
  let m1 = document.getElementById("music1");
  let m2 = document.getElementById("music2");

  if (m2.paused) {
    m1.pause();
    m2.currentTime =45;
    m2.play();
    m2.volume=0.1;
  }
}
