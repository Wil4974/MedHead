package poc.unitTests;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import poc.controller.HospitalController;
import poc.service.HospitalService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HospitalController.class)
public class HospitalControllerTest {

    private HospitalController hospitalController;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HospitalService hospitalService;

    @Before
    public void setUp() {
        hospitalController = new HospitalController();
        mockMvc = MockMvcBuilders.standaloneSetup(hospitalController).build();
    }
    @Test
    public void sentReservationTest() throws Exception {
        mockMvc.perform(post("/hospital/reservation/Julia Crusher"))
                .andExpect(status()
                .isOk());
    }

    @Test
    public void getClosestHospitalsWithSpeciality3AndAvailableBedsTest() throws Exception {
        mockMvc.perform(get("/hospital/51.48312/-0.11593/Neuropathologie diagnostique"))
                .andExpect(status()
                        .isOk());
    }

    @Test
    public void getClosestHospitalsWithSpeciality1AndAvailableBedsTest() throws Exception {
        mockMvc.perform(get("/hospital/51.48312/-0.11593/Cardiologie"))
                .andExpect(status()
                        .isOk());
    }
}
