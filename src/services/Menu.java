package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void telaPrincipal() {
        System.out.println("*".repeat(50));
        System.out.println(" ".repeat(15) + "Controle de Produtos".toUpperCase());
        System.out.println("*".repeat(50));
        System.out.println();
        System.out.println(" [1] - Cadastro Produto");
        System.out.println(" [2] - Alterar Produto");
        System.out.println(" [3] - Excluir Produto");
        System.out.println(" [4] - Importar Produto Por Arquivo");
        System.out.println(" [5] - Listar Produtos Cadastrados");
        System.out.println(" [6] - Sair");
        System.out.print(" Opcao: ");
    }

    public void menu() {
        int opt = 0;
        do {
            telaPrincipal();

            try {
                opt = Integer.parseInt(reader.readLine());
                switch (opt) {

                    case 1:
                        ProdutoServico.incluir();
                        break;
                    case 2:
                        ProdutoServico.alterar();
                        break;
                    case 3:
                        ProdutoServico.excluir();
                        break;
                    case 4:
                        ProdutoServico.importar();
                        break;
                    case 5:
                        ProdutoServico.listar();
                        break;
                    case 6:
                        System.out.println("Sair");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Digite um número válido");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } while (opt != 6);
    }
}
