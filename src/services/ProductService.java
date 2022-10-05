package services;

import entities.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductService {

    Scanner scanner = new Scanner(System.in);

    List<Product> products = new ArrayList<>();

    public void incluir() {

        Scanner sc = new Scanner(System.in);

        System.out.println("*".repeat(50));
        System.out.println(" ".repeat(15) + "Cadastro de Produtos".toUpperCase());
        System.out.println("*".repeat(50));
        System.out.println();
        System.out.println("Digite os dados do produtos que desejar cadastrar:");

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

        } catch (Exception e) {
            System.out.println("");
        }

    }


    public void alterar() {
        listar();

    }

    public void listar() {

    }

    public void excluir() {
    }

    public void importar() {
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