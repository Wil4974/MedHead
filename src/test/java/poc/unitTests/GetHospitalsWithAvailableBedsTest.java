package poc.unitTests;

import poc.model.Hospital;
import poc.util.ConnectToPostgreSQL;
import poc.util.GetHospitalsWithAvailableBeds;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GetHospitalsWithAvailableBedsTest {
    static Instant startedAt;
    static List<Hospital> allHospitals = new ArrayList<>();

    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
        allHospitals.add(new Hospital(1, "Fred Brooks", 51.4739,-0.0684, 2));
        allHospitals.add(new Hospital(2, "Julia Crusher", 51.47303, -0.01523, 0));
        allHospitals.add(new Hospital(3, "Beverly Bashir", 51.5031, -0.1528, 5));
    }

    @BeforeEach
    public void getHospitalsWithAvailableBedsTest() {
        System.out.println("Début des tests");
    }
    @ParameterizedTest(name = "{0} hôpitaux ont des lits disponibles ")
    @ValueSource(ints = {2})
    public void getHospitalsWithAvailableBedsFromFile(int expectResult){
        //Arrange - See @CsvSource

        //Act
        List<Hospital> hospitalsWithAvailableBeds = GetHospitalsWithAvailableBeds.FromFile(allHospitals);

        //Asserts
        assertEquals(expectResult, hospitalsWithAvailableBeds.size());
    }
    @ParameterizedTest(name = "{0} hôpitaux ont des lits disponibles ")
    @ValueSource(ints = {2})
    public void getHospitalsWithAvailableBedsFromDataBase(int expectResult){
        //Arrange - See @CsvSource

        //Act
        List<Hospital> hospitalsWithAvailableBeds = GetHospitalsWithAvailableBeds.FromFile(ConnectToPostgreSQL.ToGetHospitalsDatas());

        //Asserts
        assertEquals(expectResult, hospitalsWithAvailableBeds.size());
    }


    @AfterEach
    public void undefGetHospitalsWithAvailableBedsTest() {
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