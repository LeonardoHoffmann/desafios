function calcularIMC() {
    const peso = parseFloat(document.getElementById("peso").value);
    const altura = parseFloat(document.getElementById("altura").value);

    if (isNaN(peso) || isNaN(altura)) {
        alert("Por favor, insira valores numéricos válidos para peso e altura.");
        return;
    }

    if (altura <= 0 || peso <= 0) {
        alert("Por favor, insira valores válidos para peso e altura maiores que zero.");
        return;
    }

    const imc = peso / (altura * altura);
    const resultadoElement = document.getElementById("resultado");
    
    let situacao = "";

    if (imc < 17) {
        situacao = "Muito abaixo do peso";
    } else if (imc >= 17 && imc < 18.5) {
        situacao = "Abaixo do Peso";
    } else if (imc >= 18.5 && imc < 24.9) {
        situacao = "Peso Normal";
    } else if (imc >= 25 && imc < 29.9) {
        situacao = "Acima do peso";
    } else if (imc >= 30 && imc < 34.9) {
        situacao = "Obesidade Grau 1";
    } else if (imc >= 35 && imc < 39.9) {
        situacao = "Obesidade Grau 2";
    } else {
        situacao = "Obesidade Grau 3";
    }

    resultadoElement.textContent = `Seu IMC é: ${imc.toFixed(2)} | Situação: ${situacao}`;
}
