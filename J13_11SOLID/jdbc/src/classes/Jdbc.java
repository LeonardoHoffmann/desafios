package classes;

import java.sql.*;
import java.util.HashSet;
import java.util.Scanner;

public class Jdbc {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sys";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        criarTabela();

        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Alterar Produto");
        System.out.println("4 - Excluir Produto");
        System.out.println("5 - Sair");

        while (true) {
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProduto(scanner);
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    alterarProduto(scanner);
                    break;
                case 4:
                    excluirProduto(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void adicionarProduto(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor Unitário: ");
        double valorUnitario = scanner.nextDouble();
        System.out.print("Estoque: ");
        int estoque = scanner.nextInt();

        Produto produto = new Produto(nome, descricao, valorUnitario, estoque);
        inserirProduto(produto);
    }

    private static void listarProdutos() {
        HashSet<Produto> produtos = carregarProdutos();

        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private static void alterarProduto(Scanner scanner) {
        listarProdutos();

        System.out.print("Digite o nome do produto que deseja alterar: ");
        String nomeAntigo = scanner.nextLine();

        System.out.print("Novo Nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Nova Descrição: ");
        String novaDescricao = scanner.nextLine();
        System.out.print("Novo Valor Unitário: ");
        double novoValorUnitario = scanner.nextDouble();
        System.out.print("Novo Estoque: ");
        int novoEstoque = scanner.nextInt();

        alterarProduto(nomeAntigo, novoNome, novaDescricao, novoValorUnitario, novoEstoque);
    }

    private static void excluirProduto(Scanner scanner) {
        listarProdutos();

        System.out.print("Digite o nome do produto que deseja excluir: ");
        String nomeExcluir = scanner.nextLine();

        excluirProduto(nomeExcluir);
    }

    private static void criarTabela() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS produtos (" +
                         "nome VARCHAR(255) PRIMARY KEY," +
                         "descricao TEXT," +
                         "valorUnitario DOUBLE," +
                         "estoque INTEGER)";
            statement.execute(sql);

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    private static void inserirProduto(Produto produto) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO produtos (nome, descricao, valorUnitario, estoque) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setDouble(3, produto.getValorUnitario());
            preparedStatement.setInt(4, produto.getEstoque());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    private static HashSet<Produto> carregarProdutos() {
        HashSet<Produto> produtos = new HashSet<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM produtos")) {

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String descricao = resultSet.getString("descricao");
                double valorUnitario = resultSet.getDouble("valorUnitario");
                int estoque = resultSet.getInt("estoque");

                produtos.add(new Produto(nome, descricao, valorUnitario, estoque));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao carregar produtos: " + e.getMessage());
        }

        return produtos;
    }

    private static void alterarProduto(String nomeAntigo, String novoNome, String novaDescricao,
                                       double novoValorUnitario, int novoEstoque) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE produtos SET nome=?, descricao=?, valorUnitario=?, estoque=? WHERE nome=?")) {

            preparedStatement.setString(1, novoNome);
            preparedStatement.setString(2, novaDescricao);
            preparedStatement.setDouble(3, novoValorUnitario);
            preparedStatement.setInt(4, novoEstoque);
            preparedStatement.setString(5, nomeAntigo);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao alterar produto: " + e.getMessage());
        }
    }

    private static void excluirProduto(String nome) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM produtos WHERE nome=?")) {

            preparedStatement.setString(1, nome);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao excluir produto: " + e.getMessage());
        }
    }
}
