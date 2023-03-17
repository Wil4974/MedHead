package poc.unitTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import poc.controller.HospitalController;
import poc.model.Hospital;
import poc.service.HospitalService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HospitalController.class)
public class HospitalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HospitalService specialityService;

    @Test
    public void testGetAllHospitals() throws Exception {
        mockMvc.perform(get("/hospital/all"))
                .andExpect(status()
                .isOk());
    }

    @Test
    public void testGetClosestHospitalsWithSpeciality3AndAvailableBeds() throws Exception {
        mockMvc.perform(get("/hospital/51.48312/-0.11593/Neuropathologie diagnostique"))
                .andExpect(status()
                        .isOk());
    }

    @Test
    public void testGetClosestHospitalsWithSpeciality1AndAvailableBeds() throws Exception {
        mockMvc.perform(get("/hospital/51.48312/-0.11593/Cardiologie"))
                .andExpect(status()
                        .isOk());
    }
}
