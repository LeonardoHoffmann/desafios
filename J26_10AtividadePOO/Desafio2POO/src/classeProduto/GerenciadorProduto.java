package classeProduto;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorProduto {
	public ArrayList<Produto> produtos = new ArrayList<Produto>();

    public void inserirProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição do produto: ");
        String descricao = scanner.nextLine();

        System.out.print("Valor unitário do produto: ");
        double valorUnitario = scanner.nextDouble();

        System.out.print("Estoque do produto: ");
        int estoque = scanner.nextInt();

        Produto novoProduto = new Produto(nome, descricao, valorUnitario, estoque);
        produtos.add(novoProduto);
        System.out.println("Produto inserido com sucesso.");
    }

    public void alterarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do produto a ser alterado: ");
        String nomeAntigo = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.nome.equals(nomeAntigo)) {
                System.out.print("Novo nome do produto: ");
                String novoNome = scanner.nextLine();

                System.out.print("Nova descrição do produto: ");
                String novaDescricao = scanner.nextLine();

                System.out.print("Novo valor unitário do produto: ");
                double novoValorUnitario = scanner.nextDouble();

                System.out.print("Novo estoque do produto: ");
                int novoEstoque = scanner.nextInt();

                produto.nome = novoNome;
                produto.descricao = novaDescricao;
                produto.valorUnitario = novoValorUnitario;
                produto.estoque = novoEstoque;
                System.out.println("Produto alterado com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void excluirProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do produto a ser excluído: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.nome.equals(nome)) {
                produtos.remove(produto);
                System.out.println("Produto excluído com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void selecionarTodos() {
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    public Produto selecionarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do produto a ser selecionado: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.nome.equals(nome)) {
                return produto;
            }
        }
        System.out.println("Produto não encontrado.");
        return null;
    }
}