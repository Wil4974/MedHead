package poc.unitTests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.SpringApplication;
import poc.AppMedheadPoc;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class initialisationTest {
    static Instant startedAt;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
     }

    @BeforeEach
    public void getHospitalsWithAvailableBedsTest() {
        System.setOut(new PrintStream(outContent));
    }
    @ParameterizedTest(name = "{0} est bien Coucou!!!")
    @ValueSource(strings = {"Coucou!!!"})
    public void getConnectionToDatabaseContainer(String expectResult){
        //Arrange - See @CsvSource
        AppMedheadPoc result = new AppMedheadPoc();

        //Act
        result.run();

        //Asserts
        assertEquals(expectResult + System.lineSeparator(), outContent.toString());
    }
    @Test
    public void getConnectionToDatabaseContainer(){
        try {
            //Arrange - See @CsvSource
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medhead","wil","wil");

            //Act

            //Asserts
            assertTrue(conn.isValid(5));
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void undefGetHospitalsWithAvailableBedsTest() {
        System.setOut(originalOut);
    }

    @AfterAll
    static public void showTestDuration() {
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

}
