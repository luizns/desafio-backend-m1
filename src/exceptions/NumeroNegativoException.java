package exceptions;

public class NumeroNegativoException extends Exception {

    private final String nomeDoAtributo;

    private static final long serialVersionUID = 6700519256871374478L;

    public NumeroNegativoException(String nomeDoAtributo) {
        this.nomeDoAtributo = nomeDoAtributo;
    }

    public String getMessage() {
        return String.format("O campo %s está negativo ",nomeDoAtributo);
    }
}