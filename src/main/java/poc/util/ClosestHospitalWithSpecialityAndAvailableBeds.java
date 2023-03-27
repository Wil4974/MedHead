package poc.util;

import poc.model.Hospital;
import java.util.List;

public class ClosestHospitalWithSpecialityAndAvailableBeds {

    public static String name(Double latitude, Double longitude, String specialityName) {

        int specialityId = SpecialityUtils.GetIdWithSpecialityNameFromDataBase(specialityName);
        List<Hospital> hospitalWithThisSpeciality = HospitalUtils.GetWithSpecialityIdFromDataBase(specialityId);

        if (hospitalWithThisSpeciality.size() > 1) {
            hospitalWithThisSpeciality = HospitalUtils.GetHospitalsWithAvailableBedsFromFile(hospitalWithThisSpeciality);
        }

        Hospital closestHospital = HospitalUtils.GetClosestHospitalFromFile(latitude, longitude, hospitalWithThisSpeciality);

        return closestHospital.getName();
    }
}
