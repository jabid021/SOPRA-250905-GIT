//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX = 0;
var posY = 0;
var posXrandom = 0;
var posYrandom = 0;
var posYmin = 30;
var posYmax = 660;
var posXmin = 30;
var posXmax = 660;
var mouvement = 30;
var pokemon = "pikachu";
var direction = "Down";
var objectifOK = false;
var vies = 3;
var enLecture = false;

imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");

inputName.onkeyup = activerBtn;

function activerBtn() {
  if (inputName.value.trim() !== "") {
    btnStart.disabled = false;
  } else {
    btnStart.disabled = true; // sinon le garde désactivé
  }
}

btnStart.onclick = demarrerJeu;

function demarrerJeu() {
  vies = 3;
  formStart.style.display = "none";
  grass.style.display = "block";
  objectif.style.display = "block";
  timer.style.display = "block";
  nbvie.style.display = "block";
  //themePokemon.play();
  -
  document.addEventListener("keydown", deplacement);
  lanceTimer();

  deplacementObjectif();
}

function deplacement(event) {
  if (event.key == "ArrowDown" || event.key == "s") {
    if (posY < posYmax) {
      posY += mouvement;
      direction = "Down";
    }
  } else if (event.key == "ArrowRight" || event.key == "d") {
    if (posX < posXmax) {
      posX += mouvement;
      direction = "Right";
    }
  } else if (event.key == "ArrowLeft" || event.key == "q") {
    if (posX >= posXmin) {
      posX -= mouvement;
      direction = "Left";
    }
  } else if (event.key == "ArrowUp" || event.key == "z") {
    if (posY >= posYmin) {
      posY -= mouvement;
      direction = "Up";
    }
  }
  pikachu.style.top = posY + "px";
  pikachu.style.left = posX + "px";
  imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");

  atteinteObjectif();
}

function deplacementObjectif() {
  randomX = Math.floor(Math.random() * (posXmax - posXmin) + posXmin);
  randomY = Math.floor(Math.random() * (posYmax - posYmin) + posYmin);
  console.log(randomX);
  objectif.style.top = randomY + "px";
  objectif.style.left = randomX + "px";
}

function atteinteObjectif() {
  const pikachuBounding = pikachu.getBoundingClientRect();
  const objectifBounding = objectif.getBoundingClientRect();

  if (
    pikachuBounding.left < objectifBounding.right &&
    pikachuBounding.right > objectifBounding.left &&
    pikachuBounding.top < objectifBounding.bottom &&
    pikachuBounding.bottom > objectifBounding.top
  ) {
    objectifOK = true;
    deplacementObjectif();
    resetChrono();
  }
}
var min = 0;
var sec = 10;
var monTimer;
function lanceTimer() {
  monTimeout = setTimeout(finChrono, 10000);
  monTimer = setInterval(updateChrono, 1000);
  console.log(monTimer);
}

function updateChrono() {
  //Incrementer puis verifier minute / seconde
  sec--;
  console.log(sec);
  let minAffiche = min < 10 ? "0" + min : "" + min;
  let secAffiche = sec < 10 ? "0" + sec : "" + sec;
  timer.innerHTML = minAffiche + ":" + secAffiche;
}

function resetChrono() {
  sec = 10;
  min = 0;
  timer.innerHTML = "00:10";
}

function finChrono() {
  clearTimeout(monTimeout);
  clearInterval(monTimer);
  if(!objectifOK){
  vies--;
    nbvie.textContent = vies;
    if (vies == 0) {
      alert("perdu");
      formStart.style.display = "block";
      grass.style.display = "none";
      objectif.style.display = "none";
      timer.style.display = "none";
      nbvie.style.display = "none";
      
    }
  }
  
  objectifOK=false;
  resetChrono();
  lanceTimer();
  deplacementObjectif();
}
pikachu.onclick = lectureMusique;
document.onkeydown = entree;

function entree(){
if (event.key === "Enter") {
btnStart.click();
}
}

function lectureMusique(){
if (!enLecture){
themePokemon.play();
enLecture = true;
}
else{
themePokemon.pause();
enLecture=false;
}
}