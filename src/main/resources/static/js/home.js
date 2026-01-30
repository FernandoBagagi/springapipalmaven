
console.log("JS carregado com sucesso");

function completarComZero(el) {

    const texto = el.textContent.trim();

    const pad = texto.endsWith('B') ? 4 : 3;
    
    el.textContent = texto.padStart(pad, "0");

}

document.addEventListener("DOMContentLoaded", () => {

    document
        .querySelectorAll(".container-numero h2")
        .forEach(completarComZero);

});