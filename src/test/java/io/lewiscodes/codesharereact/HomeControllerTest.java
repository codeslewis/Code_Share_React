package io.lewiscodes.codesharereact;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import io.lewiscodes.codesharereact.controllers.HomeController;

@WebMvcTest(HomeController.class)
class HomeControllerTest {
    
  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("Get request for index should return status 200")
	public void getIndex() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}
}