package poc.apiError;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
        //System.out.println("Notre site rencontre un problème. Nous le traitons dans les meilleurs délais");
    }
}
