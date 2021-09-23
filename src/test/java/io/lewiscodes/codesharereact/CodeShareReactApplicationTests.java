package io.lewiscodes.codesharereact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class CodeShareReactApplicationTests {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Get latest snippets returns status 200")
    void getLatest() throws Exception {
        this.mockMvc.perform(get("/api/code/latest")).andExpect(status().isOk());
    }

}
