package poc.util;

import poc.model.Speciality;
import java.util.List;

public class SpecialityUtils {

    public static int GetIdWithSpecialityNameFromFile(String specialityName, List<Speciality> allSpecialities) {
        return GetIdWithSpecialityNamefilterSpecialitiesByName(specialityName, allSpecialities);
    }

    public static int GetIdWithSpecialityNameFromDataBase(String specialityName) {
        List<Speciality> allSpecialities = DatabaseUtils.ConnectToGetSpecialitiesDatas();
        return GetIdWithSpecialityNamefilterSpecialitiesByName(specialityName, allSpecialities);
    }

    public static int GetIdWithSpecialityNamefilterSpecialitiesByName(String specialityName, List<Speciality> allSpecialities) {
        return allSpecialities.stream()
                .filter(n -> n.getName()
                        .equals(specialityName))
                .findFirst()
                .orElse(new poc.model.Speciality(0, "Pas de groupe", "Pas en base"))
                .getId();
    }
}
