package poc.apiError;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
        System.out.println("La page demandées est introuvable.");
    }
}
