package poc.IntegrationTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import poc.util.ClosestHospitalWithSpecialityAndAvailableBeds;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClosestHospitalWithSpecialityAndAvailableBedsTest {
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
    @ParameterizedTest(name = "Hôpital le plus proche : {0}")
    @CsvSource({"Fred Brooks, 51.48312, -0.11593, Cardiologie", "Beverly Bashir, 51.48312, -0.11593, Neuropathologie diagnostique"})
    public void getClosestHospitalWithSpecialityAndAvailableBedsFromFile(String expectResult, Double latitude, Double longitude, String specialityName){
        //Arrange - See @CsvSource

        //Act
        String nameHospital = ClosestHospitalWithSpecialityAndAvailableBeds.name(latitude, longitude, specialityName);

        //Asserts
        assertEquals(expectResult, nameHospital);
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
