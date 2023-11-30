package classes;

public class Produto {
    private String nome;
    private String descricao;
    private double valorUnitario;
    private int estoque;
    
    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public Produto(String nome, String descricao, double valorUnitario, int estoque) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.estoque = estoque;
	}
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", descricao=" + descricao + ", valorUnitario=" + valorUnitario + ", estoque="
				+ estoque + "]";
	}
}
