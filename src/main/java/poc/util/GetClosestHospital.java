package poc.util;

import poc.model.Hospital;
import java.util.List;

public class GetClosestHospital {

    public static Hospital FromFile(double latitudePosition, double longitudePosition, List<Hospital> allHospitals) {

        double shortestDistance = 100;
        Hospital closestHospital = new Hospital();

        for(Hospital hospital : allHospitals){
            double distanceToHospital = GetDistance.BetweenTwoPoints(latitudePosition, longitudePosition, hospital.getLatitude(), hospital.getLongitude());
            if (shortestDistance > distanceToHospital)
            {
                closestHospital = hospital;
            }
        }
        return closestHospital;
    }
}
