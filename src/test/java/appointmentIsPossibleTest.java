import org.junit.jupiter.api.Test;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Date;

import junit.framework.TestCase;

import static junit.framework.Assert.assertEquals;

public class appointmentIsPossibleTest {
    @Test
    void appointmentAt2PMThe02042023IsPossible() throws ParseException {
        //Arrange
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTimeAppointment = dfm.parse("2023-02-04 14:00:00");
        AppointmentIsPossible appointmentIsPossible = new AppointmentIsPossible();

        //Act
        boolean isTrue = appointmentIsPossible.isTrue(dateTimeAppointment);

        //Asserts
        assertEquals(true, isTrue);
    }
}
