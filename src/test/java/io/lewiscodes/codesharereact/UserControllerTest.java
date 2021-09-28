// package io.lewiscodes.codesharereact;

// import static org.hamcrest.Matchers.containsString;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.mockito.Mockito.doReturn;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.extension.ExtendWith;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// import io.lewiscodes.codesharereact.controllers.UserController;
// import io.lewiscodes.codesharereact.models.User;
// import io.lewiscodes.codesharereact.models.UserModelAssembler;
// import io.lewiscodes.codesharereact.services.CodeService;

// @ExtendWith(SpringExtension.class)
// @WebMvcTest(UserController.class)
// class UserControllerTest {
  
//   @MockBean
//   private CodeService service;
//   @MockBean
//   private UserModelAssembler assembler;
    
//   @Autowired
//   private MockMvc mockMvc;

//   @Test
//   @DisplayName("GET api/user/bob@gmail.com - Found")
// 	public void getIndex() throws Exception {
// 	  String bobsEmail = "bob@gmail.com";
// 	  User mockUser = new User(bobsEmail, "supersecretpassword");
// 	  doReturn(assembler.toModel(mockUser)).when(service).findByEmail(bobsEmail);
	  
// 		this.mockMvc.perform(get("/api/user/{email}", bobsEmail))
// 		  .andExpect(status().isOk());
// 	}
// }