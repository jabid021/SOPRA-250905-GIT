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
let angleToupie = 0;
let intervalPikachu;
var angle=0;
var timeout;
let delta = 1; // valeur d'agrandissement en px
let taille = 44; // taille en px


let newX = posX;
let newY = posY;

const bonus = document.querySelector("#bonus");

let hyperX = 500;
let hyperY = 500;
const hyperSpeed = 1;

const selectPerso = document.getElementById('personnages');


selectPerso.addEventListener('change', () => {
    pokemon = selectPerso.value;
    imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");
  });

inputName.addEventListener("input", () => {
  btnStart.disabled = inputName.value.trim() === "";
});

btnStart.addEventListener("click",function(){
  formStart.style.display="none";
  //btnToupie.style.display="block";
  //btnStopSpin.style.display="block";
  grass.style.display="block";
  pikachu.setAttribute("title",inputName.value);
  pokemonName.textContent = inputName.value;
  document.addEventListener("keydown",deplacement);
});


btnToupie.addEventListener("click",startCombat);

function startCombat() {
  toupis.style.display = "block";
  setTimeout(3000);
  movetoupis();
  intervalPikachu = setInterval(tournoyer, 5);
}

//pikachu.addEventListener("click", tournoyer);

function deplacement(event)
{

  
  if(event.key=="ArrowDown" || event.key=="s" )
  {
   posY = (posY>=660) ?  posY :  posY+mouvement;
   direction="Down";
  }
  else if(event.key=="ArrowRight" || event.key=="d" )
  {
    posX = (posX>=660) ?  posX : posX+mouvement;
    direction="Right";
  }

  else if(event.key=="ArrowLeft" || event.key=="q")
  {
    posX = (posX<=0) ?  posX : posX-mouvement;
    direction="Left";
  }

  else if(event.key=="ArrowUp" || event.key=="z")
  {
    posY = (posY<=0) ?  posY : posY-mouvement;
    direction="Up";
  }
  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
  imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

  checkBonusCollision();

}

function checkBonusCollision() {
    const bonusX = bonus.offsetLeft;
    const bonusY = bonus.offsetTop;
    if (Math.abs(posX - bonusX) < 32 && Math.abs(posY - bonusY) < 32) {
      bonus.remove();
      startCombat();
    }
  }


function tournoyer() {
  angle = (angle + 10) % 360;
  imgPikachu.style.transform = `rotate(${angle}deg)`;
  //console.log("tournoyer");
  if (taille < 120){
    agrandirImage();
  }
}

function resetTounoyer() {
  clearInterval(intervalPikachu);
  angle = 0;
  imgPikachu.style.transform = `rotate(${angle}deg)`;
  taille = 44;
  imgPikachu.style.width = taille + "px";
}

function agrandirImage() {
  taille += delta;
  imgPikachu.style.width = taille + "px";
  imgPikachu.style.height = "auto";
}

function movetoupis() {
  const dx = posX - hyperX;
  const dy = posY - hyperY;
  const distance = Math.sqrt(dx * dx + dy * dy);

  if (distance > 1) {
    hyperX += (dx / distance) * hyperSpeed;
    hyperY += (dy / distance) * hyperSpeed;
  }

  toupis.style.left = hyperX + "px";
  toupis.style.top = hyperY + "px";
  timeout = setTimeout(function (){
  angle = (angle + 10) % 360;
  toupis.style.transform = `rotate(${angle}deg)`;
  }, 5);
  

  if (Math.abs(posX - hyperX) < 40 && Math.abs(posY - hyperY) < 40) {
    //alert(`L'hyper vitesse de mon Pegasus t'a battue !`);
    toupis.setAttribute("src","assets/img/437e60c3fe83d636e7f514fac5a6e39e.gif");
    setTimeout(function(){toupis.style.display = "none"}, 1200);
    textAbove.innerHTML = `${inputName.value} a vaincu Pegasus !`;
    textAbove.style.display = "block";
    resetTounoyer();
    return;
  }

  requestAnimationFrame(movetoupis);
}






