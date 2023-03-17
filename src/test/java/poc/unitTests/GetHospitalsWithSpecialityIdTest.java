package poc.unitTests;

import poc.model.Hospital;
import poc.util.GetHospitalWithSpecialityId;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetHospitalsWithSpecialityIdTest {
    static Instant startedAt;

    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
    }

    @BeforeEach
    public void getClosestHospitalTest() {
        System.out.println("Début des tests");
    }

    @ParameterizedTest(name = "Fred Brooks : hôpital avec la spécialité 1")
    @ValueSource(ints = {1})
    public void getHospitalsWithSpecialityId1(){
        //Arrange - See @CsvSource
        List<Hospital> expectHospital = new ArrayList<>();
        expectHospital.add(new Hospital(1, "Fred Brooks", 51.4739,-0.0684, 2));
        expectHospital.add(new Hospital(2, "Julia Crusher", 51.47303, -0.01523, 0));

        //Act
        List<Hospital> hospitalWihtSpecialityId = GetHospitalWithSpecialityId.FromDataBase(1);

        //Asserts
        assertEquals(expectHospital.size(), hospitalWihtSpecialityId.size());
    }

    @ParameterizedTest(name = "Julia Crusher : hôpital avec la spécialité 2")
    @ValueSource(ints = {2})
    public void getHospitalsWithSpecialityId2(){
        //Arrange - See @CsvSource
        List<Hospital> expectHospital = new ArrayList<>();
        expectHospital.add(new Hospital(2, "Julia Crusher", 51.47303, -0.01523, 0));
        expectHospital.add(new Hospital(3, "Beverly Bashir", 51.5031, -0.1528, 5));

        //Act
        List<Hospital> hospitalWihtSpecialityId = GetHospitalWithSpecialityId.FromDataBase(2);

        //Asserts
        assertEquals(expectHospital.size(), hospitalWihtSpecialityId.size());
    }
    @ParameterizedTest(name = "Beverly Bashir : hôpital avec la spécialité 3")
    @ValueSource(ints = {3})
    public void getHospitalsWithSpecialityId3(){
        //Arrange - See @CsvSource
        List<Hospital> expectHospital = new ArrayList<>();
        expectHospital.add(new Hospital(3, "Beverly Bashir", 51.5031, -0.1528, 5));

        //Act
        List<Hospital> hospitalWihtSpecialityId = GetHospitalWithSpecialityId.FromDataBase(3);

        //Asserts
        assertEquals(expectHospital.size(), hospitalWihtSpecialityId.size());
    }

    @AfterEach
    public void undefGetClosestHospitalTest() {
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