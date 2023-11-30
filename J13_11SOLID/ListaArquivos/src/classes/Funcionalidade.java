package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Funcionalidade {
	
	public static class CadastroProdutos {
	    private static final String FILE_PATH = "produtos.txt";

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        HashSet<Produto> produtos = new HashSet<>();

	        carregarProdutos(produtos);

	        int opcao;
	        do {
	            System.out.println("1. Cadastrar Produto");
	            System.out.println("2. Listar Produtos");
	            System.out.println("3. Alterar Estoque");
	            System.out.println("4. Remover Produto");
	            System.out.println("5. Sair");
	            System.out.print("Escolha uma opção: ");
	            opcao = scanner.nextInt();

	            switch (opcao) {
	                case 1:
	                    cadastrarProduto(scanner, produtos);
	                    break;
	                case 2:
	                    listarProdutos(produtos);
	                    break;
	                case 3:
	                    alterarEstoque(scanner, produtos);
	                    break;
	                case 4:
	                    removerProduto(scanner, produtos);
	                    break;
	                case 5:
	                    System.out.println("Saindo...");
	                    break;
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	            }
	        } while (opcao != 5);

	        salvarProdutos(produtos);

	        scanner.close();
	    }
	}

	    private static void cadastrarProduto(Scanner scanner, HashSet<Produto> produtos) {
	        System.out.print("Digite o nome do produto: ");
	        String nome = scanner.next();
	        if (buscarProduto(nome, produtos) != null) {
	        	System.out.println("Produto já existente.");
	        } else {
	        System.out.print("Digite a descrição do produto: ");
	        String descricao = scanner.next();
	        System.out.print("Digite o valor unitário do produto: ");
	        double valorUnitario = scanner.nextDouble();
	        System.out.print("Digite o estoque inicial do produto: ");
	        int estoque = scanner.nextInt();
	        
	        Produto novoProduto = new Produto(nome, descricao, valorUnitario, estoque);
	        if (produtos.add(novoProduto)) {
	            System.out.println("Produto cadastrado com sucesso!");
	        } else {
	            System.out.println("Produto já cadastrado.");
	        }
	    }
	  }
	    
	      private static Produto buscarProduto(String nome, HashSet<Produto> produtos) {
	            for (Produto produto : produtos) {
	                if (produto.getNome().equalsIgnoreCase(nome)) {
	                    return produto;
	                }
	            }
	            return null;
	        }

        private static void listarProdutos(HashSet<Produto> produtos) {
        	if (produtos.isEmpty()) {
                System.out.println("Nenhum produto cadastrado.");
            } else {
                System.out.println("Lista de Produtos:");
                for (Produto produto : produtos) {
                    System.out.println(
                            produto.getNome() + " - " + produto.getDescricao() + " - R$" + produto.getValorUnitario() +
                            " - Estoque: " + produto.getEstoque());
                }
            }
        	
        }
        
        private static void alterarEstoque(Scanner scanner, HashSet<Produto> produtos) {
        	System.out.print("Digite o nome do produto: ");
            String nome = scanner.next();
            Produto produtoEncontrado = buscarProduto(nome, produtos);

            if (produtoEncontrado != null) {
                System.out.print("Digite a quantidade a ser adicionada/subtraída no estoque: ");
                int quantidade = scanner.nextInt();
                Produto produtoSubstituido = new Produto(
                        produtoEncontrado.getNome(),
                        produtoEncontrado.getDescricao(),
                        produtoEncontrado.getValorUnitario(),
                        produtoEncontrado.getEstoque() + quantidade
                );
                produtos.remove(produtoEncontrado);
                produtos.add(produtoSubstituido);
                System.out.println("Estoque alterado com sucesso!");
            } else {
                System.out.println("Produto não encontrado.");
            }
        }
        
        private static void removerProduto(Scanner scanner, HashSet<Produto> produtos) {
        	System.out.print("Digite o nome do produto: ");
            String nome = scanner.next();
            Produto produtoEncontrado = buscarProduto(nome, produtos);

            if (produtoEncontrado != null) {
                produtos.remove(produtoEncontrado);
                System.out.println("Produto removido com sucesso!");
            } else {
                System.out.println("Produto não encontrado.");
            }
        }
        
        private static void carregarProdutos(HashSet<Produto> produtos) {
            try {
                File file = new File("produtos.txt");
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String[] dadosProduto = scanner.nextLine().split(";");

                    if (dadosProduto.length >= 4) {
                        String nome = dadosProduto[0];
                        String descricao = dadosProduto[1];
                        double valorUnitario = Double.parseDouble(dadosProduto[2]);
                        int estoque = Integer.parseInt(dadosProduto[3]);

                        Produto produto = new Produto(nome, descricao, valorUnitario, estoque);
                        produtos.add(produto);
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado. Criando novo arquivo.");
            } catch (Exception e) {
                System.out.println("Erro ao carregar produtos: " + e.getMessage());
            }
        }

        private static void salvarProdutos(HashSet<Produto> produtos) {
            try (FileWriter writer = new FileWriter("produtos.txt")) {
                for (Produto produto : produtos) {
                    writer.write(produto.getNome() + ";" +
                            produto.getDescricao() + ";" +
                            produto.getValorUnitario() + ";" +
                            produto.getEstoque() + "\n");
                }
            } catch (IOException e) {
                System.out.println("Erro ao salvar produtos: " + e.getMessage());
            }
        }
}