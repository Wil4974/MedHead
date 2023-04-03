package poc.unitTests;

import poc.model.Hospital;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import poc.util.DatabaseUtils;
import poc.util.HospitalUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
public class GetClosestHospitalUnitTest {
    static Instant startedAt;
    static List<Hospital> allHospitals = new ArrayList<>();
    double latitudePosition = 51.48312;
    double longitudePosition = -0.11593;

    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
        allHospitals.add(new Hospital(1, "Fred Brooks", 51.4739,-0.0684, 2));
        allHospitals.add(new Hospital(2, "Julia Crusher", 51.47303, -0.01523, 0));
        allHospitals.add(new Hospital(3, "Beverly Bashir", 51.5031, -0.1528, 5));
    }

    @BeforeEach
    public void initGetClosestHospitalUnitTest() {
        System.out.println("Début des tests");
    }
    @ParameterizedTest(name = "Hôpital le plus proche depuis le point 51.48312:-0.11593 est {0}.")
    @CsvSource({"Beverly Bashir"})
    public void getClosestHospitalFromFile(String expectResult){
        //Arrange - See @CsvSource

        //Act
        String hospitalName = HospitalUtils.GetClosestHospitalFromFile(latitudePosition, longitudePosition, allHospitals).getName();

        //Asserts
        assertEquals(expectResult, hospitalName);
    }

    @ParameterizedTest(name = "Hôpital le plus proche depuis le point 51.48312:-0.11593 est {0}.")
    @CsvSource({"Beverly Bashir"})
    public void getClosestHospitalFromDataBase(String expectResult){
        //Arrange - See @CsvSource

        //Act
        String hospitalName = HospitalUtils.GetClosestHospitalFromFile(latitudePosition, longitudePosition, DatabaseUtils.ConnectToGetHospitalsDatas()).getName();

        //Asserts
        assertEquals(expectResult, hospitalName);
    }

    @AfterEach
    public void undefGetClosestHospitalUnitTest() {
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