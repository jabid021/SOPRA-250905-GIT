const diapos = {
    sejour: [
        "https://i.pinimg.com/1200x/73/0e/cd/730ecd47aff5a4da514c0beaf4b6687d.jpg",
        "https://i.pinimg.com/1200x/4d/d9/ba/4dd9bab7882d120abfe6ebb6735fcead.jpg",
        "https://i.pinimg.com/1200x/17/08/2b/17082b254262236707dfad4f692d211d.jpg"
    ],
    cuisine: [
        "https://i.pinimg.com/1200x/fa/33/71/fa3371832e49bd7954f29edf0924967b.jpg",
        "https://i.pinimg.com/1200x/a0/22/96/a02296bd290e23c6d056a55dc09902ba.jpg",
        "https://i.pinimg.com/1200x/18/04/e3/1804e3c4f0aef522c0c26f0698cbb331.jpg"
    ],
    bureau:[
        "https://i.pinimg.com/736x/fc/82/83/fc82835118d0ace360a0f066db9c1a81.jpg",
        "https://i.pinimg.com/1200x/c7/76/de/c776de7de248ac8373de70f5b6309f1a.jpg",
        "https://i.pinimg.com/736x/ab/45/d2/ab45d2b80edbff59204a4866c47fd91a.jpg"
    ]
}

let indexDiapo = { sejour: 0, cuisine: 0, bureau: 0 };

function Changer(sens, piece) {
  
    const images = diapos[piece];
    let index = indexDiapo[piece];

    index += sens;
    if (index < 0) {
        index = images.length - 1;
    }
    if (index >= images.length) {
        index = 0;
    }

    indexDiapo[piece] = index;
    document.getElementById("img-" + piece).src = images[index];
}