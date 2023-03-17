package poc.util;

import poc.model.Speciality;
import java.util.List;

public class GetSpecialityIdWithSpecialityName {

    public static int FromFile(String specialityName, List<Speciality> allSpecialities) {
        return filterSpecialitiesByName(specialityName, allSpecialities);
    }

    public static int FromDataBase(String specialityName) {
        List<Speciality> allSpecialities = poc.util.ConnectToPostgreSQL.ToGetSpecialitiesDatas();
        return filterSpecialitiesByName(specialityName, allSpecialities);
    }

    public static int filterSpecialitiesByName(String specialityName, List<Speciality> allSpecialities) {
        return allSpecialities.stream()
                .filter(n -> n.getName()
                        .equals(specialityName))
                .findFirst()
                .orElse(new Speciality(0, "Pas en base"))
                .getId();
    }
}
