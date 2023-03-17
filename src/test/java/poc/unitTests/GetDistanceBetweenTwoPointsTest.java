package poc.unitTests;

import poc.util.GetDistance;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetDistanceBetweenTwoPointsTest {
    static Instant startedAt;

    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
    }

    @BeforeEach
    public void initLookingForTheClosestHospitalTest() {
        System.out.println("Début des tests");
    }

    @ParameterizedTest(name = " La distance entre le point {0}:{1} et le point {2};{3} est de {4} m .")
    @CsvSource({"51.48312, -0.11593, 51.4739, -0.0684, 3.447564445569311", " 51.48312, -0.11593, 51.47303, -0.01523, 7.063527406715057"})
    public void calculDistanceBetweenTwoPointsTest(double latitude, double longitude, double latitude2, double longitude2, double expectResult) {
        //Arrange
        double distance;

        //Act
        distance = GetDistance.BetweenTwoPoints(latitude, longitude, latitude2, longitude2);

        //Asserts
        assertEquals(expectResult, distance);
    }

    @AfterEach
    public void undefBedsAreAvailableTest() {
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
