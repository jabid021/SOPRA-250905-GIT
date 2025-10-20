// script qui insère un memory game dans la page homepage.html avec les images des ressources du jeu Anno 1800 : ../source/poisson.png, eau_de_vie, vetement_de_travail, saucisse, savon, pain, biere, manteau, machine_a_coudre, conserve, rhum, bijoux, café, champagne, chocolat, cigare, lunettes, gramophone, montre, velo, voiture, ampoule
// et avec un back de carte : ../source/fermier.png pour poisson, eau_de_vie, vetement_de_travail
// ../source/ouvrier.png pour saucisse, savon, pain, biere
// ../source/artisant.png pour manteau, machine_a_coudre, conserve, rhum
// ../source/ingenieur.png pour lunettes, café, ampoule, montre, velo
// ../source/investisseur.png pour bijoux, champagne, chocolat, cigare, voiture, gramophone 
// fait 4 lignes de 11 colonnes
(function () {
    // Resource definitions (front image filename -> back group)
    const resources = [
        { name: 'poisson', back: 'fermier' },
        { name: 'eau_de_vie', back: 'fermier' },
        { name: 'vetement_de_travail', back: 'fermier' },

        { name: 'saucisse', back: 'ouvrier' },
        { name: 'savon', back: 'ouvrier' },
        { name: 'pain', back: 'ouvrier' },
        { name: 'biere', back: 'ouvrier' },

        { name: 'manteau', back: 'artisant' },
        { name: 'machine_a_coudre', back: 'artisant' },
        { name: 'conserve', back: 'artisant' },
        { name: 'rhum', back: 'artisant' },

        { name: 'lunettes', back: 'ingenieur' },
        { name: 'cafe', back: 'ingenieur' },
        { name: 'ampoule', back: 'ingenieur' },
        { name: 'montre', back: 'ingenieur' },
        { name: 'velo', back: 'ingenieur' },

        { name: 'bijoux', back: 'investisseur' },
        { name: 'champagne', back: 'investisseur' },
        { name: 'chocolat', back: 'investisseur' },
        { name: 'cigare', back: 'investisseur' },
        { name: 'voiture', back: 'investisseur' },
        { name: 'gramophone', back: 'investisseur' },
    ];

    const SOURCE_DIR = 'source/';
    const FLIP_DELAY = 800;

    // create deck (duplicate each resource to make pairs)
    function createDeck() {
        const deck = [];
        resources.forEach((r) => {
            const cardA = { id: `${r.name}-a`, name: r.name, back: r.back };
            const cardB = { id: `${r.name}-b`, name: r.name, back: r.back };
            deck.push(cardA, cardB);
        });
        return shuffle(deck);
    }

    // Fisher-Yates shuffle
    function shuffle(array) {
        for (let i = array.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [array[i], array[j]] = [array[j], array[i]];
        }
        return array;
    }

    // Inject minimal styles so the board is usable without external CSS
    function injectStyles() {
        const css = `
            .memory-container { max-width: 1210px; margin: 12px auto; font-family: sans-serif; position: sticky; top: 0; z-index: 1000; }
            .memory-controls { display:flex; justify-content:space-between; align-items:center; margin-bottom:8px; }
            .memory-grid { display:grid; grid-template-columns: repeat(11, 1fr); gap:8px; }
            .card { position:relative; width:100%; padding-top:100%; cursor:pointer; perspective:800px; }
            .card-inner { position:absolute; inset:0; transition: transform 0.45s; transform-style: preserve-3d; }
            .card.flipped .card-inner { transform: rotateY(180deg); }
            .card-face { position:absolute; inset:0; backface-visibility:hidden; border-radius:6px; overflow:hidden; display:flex; align-items:center; justify-content:center; background:#eee; border:1px solid #ccc; }
            .card-face img { width:100%; height:100%; object-fit:cover; display:block; }
            .card-front { transform: rotateY(180deg); }
            .card.matched { visibility:visible; opacity:0.6; pointer-events:none; }
            .btn { padding:6px 14px; border-radius:4px; border:1px solid #888; background:#fff; cursor:pointer; }
            .info { font-size:16px; color:#ffffff; }
        `;
        const style = document.createElement('style');
        style.textContent = css;
        document.head.appendChild(style);
    }

    // Build DOM for the game
    function buildBoard(root, deck) {
        root.innerHTML = ''; // clear

        const container = document.createElement('div');
        container.className = 'memory-container';

        const controls = document.createElement('div');
        controls.className = 'memory-controls';

        const info = document.createElement('div');
        info.className = 'info';
        info.textContent = 'Moves: 0 — Matches: 0';

        const restartBtn = document.createElement('button');
        restartBtn.className = 'btn';
        restartBtn.textContent = 'Restart';

        controls.appendChild(info);
        controls.appendChild(restartBtn);

        const grid = document.createElement('div');
        grid.className = 'memory-grid';
        grid.setAttribute('role', 'grid');

        container.appendChild(controls);
        container.appendChild(grid);
        root.appendChild(container);

        return { grid, info, restartBtn };
    }

    function cardElement(card) {
        const wrapper = document.createElement('div');
        wrapper.className = 'card';
        wrapper.dataset.id = card.id;
        wrapper.dataset.name = card.name;

        const inner = document.createElement('div');
        inner.className = 'card-inner';

        const front = document.createElement('div');
        front.className = 'card-face card-front';
        const frontImg = document.createElement('img');
        frontImg.src = `${SOURCE_DIR}${card.name}.png`;
        frontImg.alt = card.name;
        front.appendChild(frontImg);

        const back = document.createElement('div');
        back.className = 'card-face card-back';
        const backImg = document.createElement('img');
        backImg.src = `${SOURCE_DIR}${card.back}.png`;
        backImg.alt = card.back;
        back.appendChild(backImg);

        inner.appendChild(front);
        inner.appendChild(back);
        wrapper.appendChild(inner);

        return wrapper;
    }

    // Main game logic
    function setupGame(rootElement) {
        injectStyles();
        let deck = createDeck();
        const { grid, info, restartBtn } = buildBoard(rootElement, deck);

        let moves = 0;
        let matches = 0;
        let first = null;
        let second = null;
        let busy = false;

        function updateInfo() {
            info.textContent = `Moves: ${moves} — Matches: ${matches}/${resources.length}`;
        }

        function resetRound() {
            first = null;
            second = null;
            busy = false;
        }

        function onCardClick(e) {
            const cardEl = e.currentTarget;
            if (busy) return;
            if (cardEl.classList.contains('flipped') || cardEl.classList.contains('matched')) return;

            cardEl.classList.add('flipped');

            if (!first) {
                first = cardEl;
                return;
            }
            if (cardEl === first) return;
            second = cardEl;
            moves++;
            updateInfo();

            const nameA = first.dataset.name;
            const nameB = second.dataset.name;

            if (nameA === nameB) {
                // match
                first.classList.add('matched');
                second.classList.add('matched');
                matches++;
                resetRound();
                updateInfo();
                if (matches === resources.length) {
                    setTimeout(() => {
                        alert(`Félicitations ! Vous avez gagné en ${moves} mouvements.`);
                    }, 250);
                }
                return;
            }

            // not a match
            busy = true;
            setTimeout(() => {
                first.classList.remove('flipped');
                second.classList.remove('flipped');
                resetRound();
            }, FLIP_DELAY);
        }

        function render() {
            grid.innerHTML = '';
            deck.forEach((c) => {
                const el = cardElement(c);
                el.addEventListener('click', onCardClick);
                grid.appendChild(el);
            });
            moves = 0;
            matches = 0;
            updateInfo();
            resetRound();
        }

        restartBtn.addEventListener('click', () => {
            deck = shuffle(createDeck());
            render();
        });

        render();
    }

    // Find or create root container
    document.addEventListener('DOMContentLoaded', () => {
    let root = document.getElementById('script-content'); 
    if (!root) {
        root = document.createElement('div');
        root.id = 'script-content';
        document.body.appendChild(root);
    }
    setupGame(root);
});
})();