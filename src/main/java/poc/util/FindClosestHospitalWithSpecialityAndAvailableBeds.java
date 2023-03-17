package poc.util;

import poc.model.Hospital;
import java.util.List;

public class FindClosestHospitalWithSpecialityAndAvailableBeds {

    public static String name(String args) {
        String[] positionAndSpecialities = args.split(":");
        double latitude = Double.parseDouble(positionAndSpecialities[0]);
        double longitude = Double.parseDouble(positionAndSpecialities[1]);
        String speciality = positionAndSpecialities[2];
        int specialityId = GetSpecialityIdWithSpecialityName.FromDataBase(speciality);
        List<Hospital> hospitalWithThisSpeciality = GetHospitalWithSpecialityId.FromDataBase(specialityId);

        if (hospitalWithThisSpeciality.size() > 1) {
            hospitalWithThisSpeciality = GetHospitalsWithAvailableBeds.FromFile(hospitalWithThisSpeciality);
        }

        Hospital closestHospital = GetClosestHospital.FromFile(latitude, longitude, hospitalWithThisSpeciality);

        return closestHospital.getName();
    }
}
