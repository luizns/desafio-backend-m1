package validations;

import exceptions.NumeroNegativoException;
import exceptions.StringVaziaException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validacao {


    public static Integer validarNumero() {
        Scanner sc = new Scanner(System.in);
        boolean numero = true;
        int num = 0;

        do {
            try {
                System.out.print("Quantidade: ");
                num = sc.nextInt();
                numero = false;

                if (num < 0) {
                    throw new NumeroNegativoException("num");
                }

            } catch (NumeroNegativoException e) {
                System.out.println("O NÚMERO NÃO PODE SER MENOR QUE ZERO -[SOMENTE NÚMEROS INTEIROS POSITIVOS (0-9)]");
                sc.nextLine();
                numero = true;
            } catch (InputMismatchException err) {
                System.out.println("Error! O valor digitado é inválido. Tente novamente!");
                sc.nextLine();
                numero = true;
            }

        } while (numero);


        return num;
    }

    public static BigDecimal validarBigNumero(String stringValor) {
        Scanner scanner = new Scanner(System.in);
        boolean isValido = true;
        BigDecimal valorBruto = null;
        String valorPreco;
        do {
            try {
                final String REG_PATTERN_VALID_DECIMAL_NUMBER = "\\d+(?:,\\d+ |.\\d+)?";
                System.out.printf("%s: ", stringValor);
                valorPreco = scanner.nextLine();
                valorBruto = new BigDecimal(valorPreco
                        .replace(",", ".")
                        .replace("\"", ""))
                        .setScale(2, RoundingMode.HALF_EVEN);
                System.out.println(valorBruto);


                if (valorBruto.signum() < 0) {
                    throw new NumeroNegativoException("num");
                }

                if (!valorBruto.toString().matches(REG_PATTERN_VALID_DECIMAL_NUMBER)) {
                    throw new NumberFormatException("Invalid decimal number");
                }

                isValido = false;


            } catch (NumeroNegativoException e) {
                System.out.println("O NÚMERO NÃO PODE SER MENOR QUE ZERO");
                // scanner.nextLine();
                isValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Digite um número válido");
                // scanner.nextLine();
                isValido = true;
            } catch (Exception ex) {
                return BigDecimal.ZERO;
            }

        } while (isValido);

        return valorBruto;
    }

    public static LocalDate localDatFormat(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (date.equals("n/a") || date == null) {
            return null;
        } else {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
    }

    public static String validarString(String nome) {
        Scanner scanner = new Scanner(System.in);
        boolean numero;
        String dados = "";
        do {
            try {
                System.out.printf("%s: ", nome);
                dados = scanner.nextLine();
                numero = false;

                if (dados == null || dados.isBlank() || dados.length() < 3) {
                    throw new StringVaziaException();
                }
            } catch (StringVaziaException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                // scanner.nextLine();
                numero = true;
            }
        } while (numero);
        return dados;
    }


//GERADORES

    public static String getRandomString() {
        int tamanhoString = 8;
        String alfaNumericos = "abcdefghijklmnopqrstuvwxyz" + "0123456789";
        StringBuilder builder = new StringBuilder(tamanhoString);
        for (int i = 0; i < tamanhoString; i++) {
            int index = (int) (alfaNumericos.length() * Math.random());
            builder.append(alfaNumericos.charAt(index));
        }
        return builder.toString();
    }

    public static String gerarCodeBarras() {

        String numeros = "0123456789";
        StringBuilder builder = new StringBuilder(12);
        for (int i = 0; i < 12; i++) {
            int index = (int) (numeros.length() * Math.random());
            builder.append(numeros.charAt(index));
        }
        return builder.toString();
    }

    public static String gerarSerie() {
        LocalDate date = LocalDate.now(); // sua instancia Date

        int mes = date.getMonthValue();
        int ano = date.getYear();
        String serie = mes + "/" + ano;
        return serie;
    }


    public static BigDecimal toBigDecimal(String valor) {
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


