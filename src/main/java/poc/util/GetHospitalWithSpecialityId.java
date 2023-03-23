package poc.util;

import poc.model.Hospital;
import java.util.List;

public class GetHospitalWithSpecialityId {

    public static List<Hospital> FromDataBase(int specialityId) {

        List<Hospital> allHospitals = ConnectToPostgreSQL.ToGetHospitalsWithSpecialitiesDatas();
        return allHospitals.stream()
                .filter(n -> n.getSpecialities()
                .equals(Integer
                .toString(specialityId)))
                .toList();
    }
}
