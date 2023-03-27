package poc.util;

import java.util.List;

public class SpecialityUtils {

    public static int GetIdWithSpecialityNameFromFile(String specialityName, List< poc.model.Speciality > allSpecialities) {
        return GetIdWithSpecialityNamefilterSpecialitiesByName(specialityName, allSpecialities);
    }

    public static int GetIdWithSpecialityNameFromDataBase(String specialityName) {
        List<poc.model.Speciality> allSpecialities = DatabaseUtils.ConnectToGetSpecialitiesDatas();
        return GetIdWithSpecialityNamefilterSpecialitiesByName(specialityName, allSpecialities);
    }

    public static int GetIdWithSpecialityNamefilterSpecialitiesByName(String specialityName, List< poc.model.Speciality > allSpecialities) {
        return allSpecialities.stream()
                .filter(n -> n.getName()
                        .equals(specialityName))
                .findFirst()
                .orElse(new poc.model.Speciality(0, "Pas en base"))
                .getId();
    }
}
