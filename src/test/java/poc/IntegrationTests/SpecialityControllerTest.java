package poc.IntegrationTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SpecialityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetSpecialities() throws Exception {
        mockMvc.perform(get("/speciality"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("Cardiologie")));
    }
}
