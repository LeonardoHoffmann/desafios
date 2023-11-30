package classeProduto;

public class Produto {
    public String nome;
    public String descricao;
    public double valorUnitario;
    public int estoque;

    public Produto(String nome, String descricao, double valorUnitario, int estoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Descrição: " + descricao + ", Valor Unitário: " + valorUnitario + ", Estoque: " + estoque;
    }
}