import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class bedsAreAvailableTest extends TestCase {
    @Test
     void testIdHospital2HasAtLeastOneFreeBed(){
        //Arrange
        int hospitalId = 2;
        Bed bed = new Bed();

        //Act
        boolean atLeastOneBedIsAvailable = bed.isAvailable(hospitalId);

        //Asserts
        assertEquals(true, atLeastOneBedIsAvailable);
    }
}