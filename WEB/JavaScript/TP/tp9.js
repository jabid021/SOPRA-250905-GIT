var min=0;
var sec=0;
var monTimer;

document.getElementById("btnStart").onclick=startChrono;
btnStop.onclick=stopChrono;
btnReset.onclick=resetChrono;

function startChrono()
{
  btnStart.disabled=true;
  btnStop.disabled=false;
  monTimer=setInterval(updateChrono,1000);
}

function stopChrono()
{
  btnStart.disabled=false;
  btnStop.disabled=true;
  clearInterval(monTimer);
}

function resetChrono()
{
  sec=0;
  min=0;
  //On force un reset à 00:00 de l'affichage
  chrono.innerHTML="00:00";
}

function updateChrono()
{
  //Incrementer puis verifier minute / seconde
  sec++;
  if(sec==60)
  {
    min++;
    sec=0;
    if(min==60)
    {
      min=0;
    }
  }
  let minAffiche = (min<10)? "0"+min : ""+min;
  let secAffiche = (sec<10)? "0"+sec : ""+sec;
  chrono.innerHTML=minAffiche+":"+secAffiche;
}
