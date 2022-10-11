package services;

import entities.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductService {

   // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Scanner scanner = new Scanner(System.in);

    List<Product> products = new ArrayList<>();


    public void incluir() {

        Scanner sc = new Scanner(System.in);

        System.out.println("*".repeat(50));
        System.out.println(" ".repeat(15) + "Cadastro de Produtos".toUpperCase());
        System.out.println("*".repeat(50));
        System.out.println();
        System.out.println("Digite os dados do produtos que desejar cadastrar:");

       // boolean validaCampos;


        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Preco: ");
            BigDecimal preco = scanner.nextBigDecimal();
            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            System.out.print("Categoria: ");
            scanner.nextLine();
            String categoria = scanner.nextLine();

            Product product = new Product(nome, categoria, preco, quantidade);

            products.add(product);
            SalvarArquivo.salvar(products);


        } catch (Exception e) {
            System.out.println("");

        }

    }


    public void alterar() {
        listar();
        List<Product> produto;
        BuscarLista exclui = new BuscarLista();
        produto = exclui.getProducts();

        System.out.println();
        System.out.println("Informe o produto que desejar alterar");
        String code = scanner.nextLine();

        for (Product prod : produto) {
            if (prod.getCodigo().contains(code)) {
                System.out.println("Escolhar o opçao que deseja alterar");
                System.out.println("[1] - Nome" +
                        "\n[2] - Preço" +
                        "\n[2] - Quantidade" +
                        "\n[3] - Categoria" +
                        "\n[4] - Cancelar"
                );

                int num;

                num = scanner.nextInt();
                switch (num) {
                    case 1:
                        System.out.print("Nome: ");
                        prod.setNome(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Preço: ");
                        prod.setValorBruto(toBigDecimal(scanner.next()));
                        break;
                    case 3:
                        System.out.print("Quantidade: ");
                        prod.setQuantidade(scanner.nextInt());
                        break;
                    case 4:
                        System.out.print("Categoria: ");
                        prod.setCategoria(scanner.nextLine());
                        break;
                    case 5:
                        System.out.println("Sair");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }

        }

    }


    public void listar() {
        System.out.println("****** LISTA DE PRODUTOS *****");
        System.out.println("*".repeat(35));
        System.out.println();

        List<Product> result;
        BuscarLista lista = new BuscarLista();
        result = lista.getProducts();
        result.forEach(v -> System.out.println(v.getCodigo() + " - " + v.getNome() + " - " + v.getCategoria() + " - " + v.getQuantidade() + " - " + String.format("R$ %.2f", v.getValorBruto())));

    }

    public void excluir() {
        listar();
        System.out.println("****** EXCLUI DE PRODUTOS *****");
        System.out.println("*".repeat(35));
        System.out.println();
        System.out.println("Informe o produto que desejar excluir".toUpperCase());
        String code = scanner.nextLine();

        List<Product> produto;
        BuscarLista exclui = new BuscarLista();
        produto = exclui.getProducts();

        produto.removeIf(p -> p.getCodigo().equals(code));
        System.out.println("Produto removido com sucesso");

        produto.stream().filter(x -> x.getCodigo().contains(code)).map(x -> produto.remove(x));
        var prod = produto.stream().filter(x -> x.getCodigo().contains(code)).findFirst();
        if (prod.isPresent()) {
            produto.remove(prod.get());
            System.out.println("Produto removido com sucesso");
        } else {
            System.out.println("Nao encontrado");
        }

    }

    public void importar() {
        System.out.println();
        System.out.println("-".repeat(45));
        System.out.println(" ****** IMPORTAR CATALOGO DE PRODUTOS *****");
        System.out.println("-".repeat(45));
        System.out.println("Digite caminho do arquivo: Ex: '/home/pc/desktop/arquivo.csv' ");
        SalvarArquivo.lerArquivo();
    }


    static BigDecimal toBigDecimal(String valor) {
        try {
            return new BigDecimal(valor
                    .replace(",", ".")
                    .replace("\"", ""))
                    .setScale(2, RoundingMode.HALF_EVEN);
        } catch (Exception ex) {
            return BigDecimal.ZERO;
        }
    }


}