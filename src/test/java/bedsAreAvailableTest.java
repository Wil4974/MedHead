import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class bedsAreAvailableTest extends TestCase {
    @Test
     void testIdHospital2Has4Beds(){
        //Arrange
        int hospitalId = 2;
        BedsAreAvailable bedsAreAvailable = new BedsAreAvailable();

        //Act
        int bedsCount = bedsAreAvailable.count(hospitalId);

        //Asserts
        assertEquals(4, bedsCount);
    }
}