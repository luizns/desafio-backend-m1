package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Produto {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String codigo;
    private String codigoDeBarras;
    private String serie;
    private String nome;
    private String descricao;
    private String categoria;
    private BigDecimal valorBruto;
    private BigDecimal impostos;
    private LocalDate dataDeFabricacao;
    private LocalDate dataDeValidade;
    private String cor;
    private String material;
    private int quantidade;

    public Produto() {
    }


    public Produto(String codigo, String codigoDeBarras, String serie, String nome, String descricao, String categoria, BigDecimal valorBruto, BigDecimal impostos, LocalDate dataDeFabricacao, LocalDate dataDeValidade, String cor, String material, int quantidade) {
        this.codigo = codigo;
        this.codigoDeBarras = codigoDeBarras;
        this.serie = serie;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valorBruto = valorBruto;
        this.impostos = impostos;
        this.dataDeFabricacao = dataDeFabricacao;
        this.dataDeValidade = dataDeValidade;
        this.cor = cor;
        this.material = material;
        this.quantidade = quantidade;
    }


    public Produto(String codigo, String codigoDeBarras, String serie, String nome, String descricao, String categoria, BigDecimal valorBruto, BigDecimal impostos, LocalDate dataDeFabricacao, LocalDate dataDeValidade, String cor, String material) {
        this.codigo = codigo;
        this.codigoDeBarras = codigoDeBarras;
        this.serie = serie;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valorBruto = valorBruto;
        this.impostos = impostos;
        this.dataDeFabricacao = dataDeFabricacao;
        this.dataDeValidade = dataDeValidade;
        this.cor = cor;
        this.material = material;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public BigDecimal getImpostos() {
        return impostos;
    }

    public void setImpostos(BigDecimal impostos) {
        this.impostos = impostos;
    }

    public LocalDate getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    public void setDataDeFabricacao(LocalDate dataDeFabricacao) {
        this.dataDeFabricacao = dataDeFabricacao;
    }

    public LocalDate getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public BigDecimal valoFinal() {

        BigDecimal porcentos = new BigDecimal("100.0");
        BigDecimal taxa = new BigDecimal("45.0").divide(porcentos);

        BigDecimal valorImposto = valorBruto.multiply((impostos.divide(porcentos)));

        BigDecimal calculoTaxa = (valorImposto.add(valorBruto)).multiply(taxa);

        BigDecimal valor = valorBruto.add(valorImposto).add(calculoTaxa);

        return (valor).setScale(2, RoundingMode.HALF_EVEN);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }


}
