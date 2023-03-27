package poc.unitTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import poc.model.Speciality;
import poc.repository.SpecialityRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import poc.util.SpecialityUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GetSpecialityNameWithSpecialityIdTest {

    @Autowired
    private SpecialityRepository specialityRepository;
    static List<Speciality> allSpecialities = new ArrayList<>();
    static Instant startedAt;

    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
        allSpecialities.add(new Speciality(1, "Groupe de médecine générale", "Cardiologie"));
        allSpecialities.add(new Speciality(2,"Groupe de pathologie", "Immunologie"));
        allSpecialities.add(new Speciality(3, "Groupe de pathologie", "Neuropathologie diagnostique"));
    }

    @BeforeEach
    public void getSpecialityNameTest() {
        System.out.println("Début des tests");
    }

    @ParameterizedTest(name = "Id {0} pour la spécialité {1}")
    @CsvSource({"2, Immunologie", "0, Pas en base", "1, Cardiologie"})
    public void getSpecialityNameWithSpecialityIdFromFile(int expectResult, String specialityName){
        //Arrange - See @CsvSource
        int id;

        //Act
        id = SpecialityUtils.GetIdWithSpecialityNameFromFile(specialityName, allSpecialities);

        //Asserts
        assertEquals(expectResult, id);
    }
    @ParameterizedTest(name = "Id {0} pour la spécialité {1}")
    @CsvSource({"2, Immunologie", "0, Pas en base", "1, Cardiologie"})
    public void getSpecialityNameWithSpecialityIdFromDataBase(int expectResult, String specialityName){
        //Arrange - See @CsvSource
        int id;

        //Act
        id = SpecialityUtils.GetIdWithSpecialityNameFromDataBase(specialityName);

        //Asserts
        assertEquals(expectResult, id);
    }


    @AfterEach
    public void undefGetSpecialityNameTest() {
        System.out.println("Fin des tests");
    }

    @AfterAll
    static public void showTestDuration() {
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }
}