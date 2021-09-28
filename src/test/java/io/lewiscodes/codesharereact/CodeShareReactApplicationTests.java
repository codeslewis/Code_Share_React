package io.lewiscodes.codesharereact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.doReturn;

import io.lewiscodes.codesharereact.controllers.UserController;
import io.lewiscodes.codesharereact.models.User;
import io.lewiscodes.codesharereact.models.UserModelAssembler;
import io.lewiscodes.codesharereact.services.CodeService;

@SpringBootTest
@AutoConfigureMockMvc
class CodeShareReactApplicationTests {
    
    // @MockBean
    // private CodeService service;
    // @Autowired
    // private UserModelAssembler assembler;
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Get latest snippets returns status 200")
    void getLatest() throws Exception {
        this.mockMvc.perform(get("/api/code/latest")).andExpect(status().isOk());
    }
    
//     @Test
//     @DisplayName("GET api/user/bob@gmail.com - Found")
// 	public void getIndex() throws Exception {
//         String bobsEmail = "bob@gmail.com";
//         User mockUser = new User(bobsEmail, "supersecretpassword");
//         doReturn(assembler.toModel(mockUser)).when(service).findByEmail(bobsEmail);
	  
//         this.mockMvc.perform(get("/api/user/{email}", bobsEmail))
//           .andExpect(status().isOk());
// 	}

}
