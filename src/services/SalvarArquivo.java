package services;

import entities.Produto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static validations.Validacao.localDatFormat;
import static validations.Validacao.toBigDecimal;

public class SalvarArquivo {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void lerArquivo() {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();

        List<Produto> result;
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            result = lines.skip(1)
                    .map(line -> line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"))
                    .map(str -> new Produto(str[0], str[1], str[2], str[3], str[4], str[5], toBigDecimal(str[6]), toBigDecimal(str[7]), localDatFormat(str[8]), localDatFormat(str[9]), str[10], str[11]))
                    .collect(Collectors.toList());

            System.out.println("Desejar Salvar o arquivo: [S/N]");
            char salvar = sc.next().charAt(0);
            if (salvar == 's' || salvar == 'S') {
                salvar(result);
            } else {
                System.out.println("Operação Cancelada");
            }

        } catch (IOException ignored) {
            System.out.println("Caminho inválido: Tente novamente");
        }

    }


    public static void salvar(List<Produto> list) {

        BuscarLista lista = new BuscarLista();

        String path = lista.path();
        ProdutoServico servicos = new ProdutoServico();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {


            for (Produto item : list) {
                bw.write(item.getCodigo() +
                        "," + item.getCodigoDeBarras() +
                        "," + item.getSerie() +
                        "," + item.getNome() +
                        "," + item.getDescricao() +
                        "," + item.getCategoria().toUpperCase() +
                        "," + item.getValorBruto() +
                        "," + item.getImpostos() +
                        "," + item.getDataDeFabricacao().format(formatter) +
                        "," + (item.getDataDeValidade() != (null) ? item.getDataDeValidade().format(formatter) : "n/a") +
                        "," + item.getCor() +
                        "," + item.getMaterial() +
                        "," + (item.getQuantidade() <= 0 ? 1 : item.getQuantidade()) +
                        "," + String.format("%.2f", item.valoFinal()));
                bw.newLine();
            }

            System.out.println(path + " CREATED!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
