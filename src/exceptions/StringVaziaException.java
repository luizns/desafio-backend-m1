package exceptions;


public class StringVaziaException extends Exception {

    public String getMessage() {
        return "Os dados informados está vazio";
    }
}