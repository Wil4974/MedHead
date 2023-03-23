package poc.util;

import poc.model.Hospital;
import java.util.List;

public class GetHospitalsWithAvailableBeds {

    public static List<Hospital> FromFile(List<Hospital> filtredHospitalsWithSpecialities) {
        return filtredHospitalsWithSpecialities.stream()
                .filter(n -> n.getAvailableBeds() > 0)
                .toList();
    }
}
