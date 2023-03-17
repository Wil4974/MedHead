package poc.util;

public class GetDistance {
    public static double BetweenTwoPoints(double latitude1, double longitude1, double latitude2, double longitude2) {
        return Math.sqrt(Math.pow((latitude2 - latitude1), 2) + Math.pow((longitude2 - longitude1), 2));
    }
}