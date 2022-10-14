package services;

import entities.Produto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static validations.Validacao.localDatFormat;
import static validations.Validacao.toBigDecimal;


public class BuscarLista {

    public List<Produto> getProducts() {
     //   Path path = Paths.get(path()).toAbsolutePath();
    //   String diretorio = String.valueOf(path);

        List<Produto> produtos;
        try (Stream<String> lines = Files.lines(Paths.get(path()).toAbsolutePath())) {
            produtos = lines
                    .map(line -> line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"))
                    .map(item -> new Produto(item[0], item[1], item[2], item[3], item[4], item[5], toBigDecimal(item[6]), toBigDecimal(item[7]), localDatFormat(item[8]), localDatFormat(item[9]), item[10], item[11], Integer.parseInt(item[12])))
                    .collect(Collectors.toList());
            return produtos;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public String path(){
        File sourceFile = new File("src/estoque.csv");
        String sourceFolderStr = sourceFile.getParent();

        boolean success = new File(sourceFolderStr + "/arquivos").mkdir();

        return sourceFolderStr + "/arquivos/estoque.csv";
    }
}
