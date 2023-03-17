package poc.unitTests;

import poc.service.SpecialityService;
import poc.controller.SpecialityController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = SpecialityController.class)
public class SpecialityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpecialityService specialityService;

    @Test
    public void testGetAllSpecialities() throws Exception {
        mockMvc.perform(get("/speciality/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddSpeciality() throws Exception {
        mockMvc.perform(post("/speciality/add:test"))
                .andExpect(status().isOk());
    }
}
