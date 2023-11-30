package classeProduto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorProduto gerenciador = new GerenciadorProduto();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Inserir produto");
            System.out.println("2. Alterar produto");
            System.out.println("3. Excluir produto");
            System.out.println("4. Selecionar todos os produtos");
            System.out.println("5. Selecionar produto por nome");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerenciador.inserirProduto();
                    break;
                case 2:
                    gerenciador.alterarProduto();
                    break;
                case 3:
                    gerenciador.excluirProduto();
                    break;
                case 4:
                    gerenciador.selecionarTodos();
                    break;
                case 5:
                    Produto produtoSelecionado = gerenciador.selecionarProduto();
                    if (produtoSelecionado != null) {
                        System.out.println("Produto selecionado: " + produtoSelecionado);
                    }
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
}