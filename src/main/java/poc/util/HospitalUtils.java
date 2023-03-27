package poc.util;

import poc.model.Hospital;
import java.util.List;

public class HospitalUtils {

    public static List<Hospital> GetWithSpecialityIdFromDataBase(int specialityId) {

        List<Hospital> allHospitals = DatabaseUtils.ConnectToGetHospitalsWithSpecialitiesDatas();
        return allHospitals.stream()
                .filter(n -> n.getSpecialities()
                        .equals(Integer
                                .toString(specialityId)))
                .toList();
    }

    public static List<Hospital> GetHospitalsWithAvailableBedsFromFile(List<Hospital> filtredHospitalsWithSpecialities) {
        return filtredHospitalsWithSpecialities.stream()
                .filter(n -> n.getAvailableBeds() > 0)
                .toList();
    }

    public static Hospital GetClosestHospitalFromFile(double latitudePosition, double longitudePosition, List<Hospital> allHospitals) {

        double shortestDistance = 100;
        Hospital closestHospital = new Hospital();

        for(Hospital hospital : allHospitals){
            double distanceToHospital = DistanceUtils.CalculBetweenTwoPoints(latitudePosition, longitudePosition, hospital.getLatitude(), hospital.getLongitude());
            if (shortestDistance > distanceToHospital)
            {
                closestHospital = hospital;
            }
        }
        return closestHospital;
    }
}
