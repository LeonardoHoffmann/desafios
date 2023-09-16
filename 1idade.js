function verificarIdade() {
    const idadeInput = document.getElementById("idade");
    const resultadoElement = document.getElementById("resultado");

    const idade = parseInt(idadeInput.value);

    if (isNaN(idade)) {
        resultadoElement.textContent = "Por favor, digite uma idade válida.";
        resultadoElement.style.color = "red";
    } else if (idade >= 18) {
        resultadoElement.textContent = "Você é maior de idade.";
        resultadoElement.style.color = "green";
    } else {
        resultadoElement.textContent = "Você é menor de idade.";
        resultadoElement.style.color = "red";
    }
}