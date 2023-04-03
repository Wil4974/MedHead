package poc.apiError;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
        //System.out.println("Votre requête est mal formatée ou contient des données invalides.");
    }
}
