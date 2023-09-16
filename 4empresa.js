function calcularAumento() {
    const cargo = document.getElementById("cargo").value;
    const salario = parseFloat(document.getElementById("salario").value);

    if (isNaN(salario) || salario <= 0) {
        alert("Por favor, insira um salário válido maior que zero.");
        return;
    }

    let aumento = 0;
    let novoSalario = 0;

    switch (cargo) {
        case "gerente":
            aumento = salario * 0.05;
            break;
        case "supervisor":
            aumento = salario * 0.08;
            break;
        case "operador":
            aumento = salario * 0.09;
            break;
        case "outro":
            aumento = salario * 0.1;
            break;
        default:
            alert("Por favor, selecione um cargo válido.");
            return;
    }

    novoSalario = salario + aumento;

    const resultadoElement = document.getElementById("resultado");
    resultadoElement.innerHTML = `
        Salário Atual: R$ ${salario.toFixed(2)}<br>
        Aumento: R$ ${aumento.toFixed(2)}<br>
        Novo Salário: R$ ${novoSalario.toFixed(2)}
    `;
}