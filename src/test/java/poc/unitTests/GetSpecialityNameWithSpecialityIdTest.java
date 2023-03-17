package poc.unitTests;

import jakarta.annotation.Resource;
import org.antlr.v4.runtime.misc.LogManager;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import poc.AppMedheadPoc;
import poc.H2JpaConfig;
import poc.model.Speciality;
import poc.repository.SpecialityRepository;
import poc.util.GetSpecialityIdWithSpecialityName;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = {AppMedheadPoc.class, H2JpaConfig.class})
public class GetSpecialityNameWithSpecialityIdTest {

    @Autowired
    private SpecialityRepository specialityRepository;
    static Instant startedAt;

    static List<Speciality> allSpecialities = new ArrayList<>();

    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
        allSpecialities.add(new Speciality(1, "Cardiologie"));
        allSpecialities.add(new Speciality(2,"Immunologie"));
        allSpecialities.add(new Speciality(3, "Neuropathologie diagnostique"));
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
        id = GetSpecialityIdWithSpecialityName.FromFile(specialityName, allSpecialities);

        //Asserts
        assertEquals(expectResult, id);
    }
    @ParameterizedTest(name = "Id {0} pour la spécialité {1}")
    @CsvSource({"2, Immunologie", "0, Pas en base", "1, Cardiologie"})
    public void getSpecialityNameWithSpecialityIdFromDataBase(int expectResult, String specialityName){
        //Arrange - See @CsvSource
        int id;

        //Act
        id = GetSpecialityIdWithSpecialityName.FromDataBase(specialityName);

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