package poc.util;

import poc.model.Hospital;
import java.util.List;

public class FindClosestHospitalWithSpecialityAndAvailableBeds {

    public static String name(Double latitude, Double longitude, String specialityName) {

        int specialityId = GetSpecialityIdWithSpecialityName.FromDataBase(specialityName);
        List<Hospital> hospitalWithThisSpeciality = GetHospitalWithSpecialityId.FromDataBase(specialityId);

        if (hospitalWithThisSpeciality.size() > 1) {
            hospitalWithThisSpeciality = GetHospitalsWithAvailableBeds.FromFile(hospitalWithThisSpeciality);
        }

        Hospital closestHospital = GetClosestHospital.FromFile(latitude, longitude, hospitalWithThisSpeciality);

        return closestHospital.getName();
    }
}
