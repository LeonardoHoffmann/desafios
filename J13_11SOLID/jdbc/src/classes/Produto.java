package classes;

class Produto {
    private String nome;
    private String descricao;
    private double valorUnitario;
    private int estoque;

    public Produto(String nome, String descricao, double valorUnitario, int estoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public int getEstoque() {
        return estoque;
    }

    @Override
    public String toString() {
    	return nome + " | " + descricao + " | " + valorUnitario + " | " + estoque;
    }
}
