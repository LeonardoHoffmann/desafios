function calcularMedia() {
    const nota1 = parseFloat(document.getElementById("nota1").value);
    const nota2 = parseFloat(document.getElementById("nota2").value);
    const nota3 = parseFloat(document.getElementById("nota3").value);
    const frequencia = parseFloat(document.getElementById("frequencia").value);

    if (isNaN(nota1) || isNaN(nota2) || isNaN(nota3) || isNaN(frequencia)) {
        alert("Por favor, insira valores numéricos válidos para as notas e a frequência.");
        return;
    }

    const notaMaxima = 10;
    if (nota1 > notaMaxima || nota2 > notaMaxima || nota3 > notaMaxima) {
        alert(`Por favor, insira notas menores ou iguais a ${notaMaxima}.`);
        return;
    }

    const media = (nota1 + nota2 + nota3) / 3;

    let situacao = "";

    if (media >= 7 && frequencia >= 75) {
        situacao = "Aprovado";
    } else if (media >= 5 && frequencia >= 75) {
        situacao = "Recuperação";
    } else {
        situacao = "Reprovado";
    }

    const resultadoElement = document.getElementById("resultado");
    resultadoElement.textContent = `Média: ${media.toFixed(2)} | Frequência: ${frequencia}% | Situação: ${situacao}`;
}

