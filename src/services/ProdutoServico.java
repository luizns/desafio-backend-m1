package services;

import entities.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static validations.Validacao.*;


public class ProdutoServico {

    // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Scanner scanner = new Scanner(System.in);

    List<Produto> produtos = new ArrayList<>();


    public static void incluir() {
        Scanner scanner = new Scanner(System.in);
        List<Produto> produto;
        BuscarLista incluir = new BuscarLista();
        produto = incluir.getProducts();

        System.out.println("*".repeat(50));
        System.out.println(" ".repeat(15) + "Cadastro de Produtos".toUpperCase());
        System.out.println("*".repeat(50));
        System.out.println();
        System.out.println("Digite os dados do produtos que desejar cadastrar:");

        String nome = validarString("Nome");
        BigDecimal valorPreco = validarBigNumero("Preço do Produto");
        int quantidade = validarNumero();
        String categoria = validarString("Categoria").toUpperCase();
        String codigo = getRandomString();
        String codigoDeBarras = gerarCodeBarras();
        String serie = gerarSerie();
        String descricao = null;

        BigDecimal impostos = BigDecimal.valueOf(1.0);
        LocalDate dataDeFabricacao = LocalDate.now();
        LocalDate dataDeValidade = null;
        String cor = "n/a";
        String material = "n/a";


        produto.add(new Produto(codigo, codigoDeBarras, serie, nome, descricao, categoria, valorPreco, impostos, dataDeFabricacao, dataDeValidade, cor, material, quantidade));

        System.out.println("Desejar Salvar o arquivo: [S/N]");
        char salvar = scanner.next().charAt(0);
        if (salvar == 's' || salvar == 'S') {
            SalvarArquivo.salvar(produto);
        } else {
            System.out.println("Operação Cancelada");
        }


    }

    public static void alterar() {
        listar();
        List<Produto> produto;
        BuscarLista alteracao = new BuscarLista();
        produto = alteracao.getProducts();

        System.out.println();
        System.out.println("Informe o código do produto que desejar alterar");
        String code = scanner.nextLine();

        // var prod = produto.stream().filter(x -> x.getCodigo().contains(code)).findFirst();
        var prod = produto.stream().filter(item -> item.getCodigo().equals(code)).findAny();

        if (prod.isPresent()) {

            System.out.println("Escolhar o opção que deseja alterar");
            System.out.println("[1] - Nome" +
                    "\t[2] - Preço" +
                    "\t[3] - Quantidade" +
                    "\t[4] - Categoria" +
                    "\t[5] - Sair"
            );
            int num;
            System.out.print("Operação: ");
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    String novoNome = validarString("Novo nome");
                    prod.get().setNome(novoNome);
                    break;
                case 2:
                    System.out.print("Novo Preço: ");
                    prod.get().setValorBruto(toBigDecimal(scanner.next()));
                    break;
                case 3:
                    int quantidade = validarNumero();
                    prod.get().setQuantidade(quantidade);
                    break;
                case 4:
                    String novaCategoria = validarString("Nova categoria");
                    prod.get().setNome(novaCategoria);
                    System.out.print("Categoria: ");
                    scanner.nextLine();
                    prod.get().setCategoria(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("Desejar Salvar o arquivo: [S/N]");
            char salvar = scanner.next().charAt(0);
            if (salvar == 's' || salvar == 'S') {
                SalvarArquivo.salvar(produto);

            } else {
                System.out.println("Operação Cancelada");
            }


        } else {

            System.out.println("Nao encontrado");
        }


    }


    public static void listar() {
        System.out.println();
        System.out.println("**** LISTA DE PRODUTOS ");
        List<Produto> result;
        BuscarLista lista = new BuscarLista();
        result = lista.getProducts();
        System.out.println("-".repeat(99));
        System.out.println("| "+"CODIGO"+" ".repeat(5)+"\tNome Produto"+" ".repeat(17)+"Categoria"+" ".repeat(12)+"\tQuantidade"+"\t\tPreço"+" ".repeat(9)+"|");
        System.out.println("-".repeat(99));
        result.forEach(v -> System.out.println("| "+v.getCodigo() + " | " + v.getNome()+" ".repeat(25-v.getNome().length()) + "| " + v.getCategoria()+" ".repeat(22-v.getCategoria().length()) + " | " + "\t\t"+v.getQuantidade()+" ".repeat(9-(""+v.getQuantidade()).length()) + " | " + String.format("R$ %.2f", v.getValorBruto())+" ".repeat(14-String.format("R$ %.2f", v.getValorBruto()).length())+"|"));
        System.out.println("-".repeat(99));
        System.out.println();
    }

    public static void excluir() {
        listar();
        System.out.println("****** EXCLUI DE PRODUTOS *****");
        System.out.println("*".repeat(35));
        System.out.println();
        System.out.println("Informe o produto que desejar excluir".toUpperCase());
        String code = scanner.nextLine();

        List<Produto> produto;
        BuscarLista exclui = new BuscarLista();
        produto = exclui.getProducts();

        var prod = produto.stream().filter(x -> x.getCodigo().equals(code)).findAny();;
        if (prod.isPresent()) {
            produto.remove(prod.get());
            System.out.println("Produto removido com sucesso");
        } else {
            System.out.println("Nao encontrado");
        }

        System.out.println("Desejar Salvar o arquivo: [S/N]");
        char salvar = scanner.next().charAt(0);
        if (salvar == 's' || salvar == 'S') {
            SalvarArquivo.salvar(produto);

        } else {
            System.out.println("Operação Cancelada");
        }

    }

    public static void importar() {
        System.out.println();
        System.out.println("-".repeat(45));
        System.out.println(" ****** IMPORTAR CATALOGO DE PRODUTOS *****");
        System.out.println("-".repeat(45));
        System.out.println("Digite caminho do arquivo: Ex: '/home/pc/desktop/arquivo.csv' ");
        SalvarArquivo.lerArquivo();
    }


}