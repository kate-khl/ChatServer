package org.khl.chat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.khl.chat.dto.LoginRequestDto;
import org.khl.chat.dto.UserDto;
import org.khl.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class SimpleChatApplicationTests {

	@Autowired
	private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private UserService uService;
    
    
    
    @BeforeEach
    public void build() {
    	this.mvc = MockMvcBuilders.webAppContextSetup(context).build();

    }
    
	@Test
	public void createUser() throws Exception {
		
    	UserDto uDto = new UserDto("Тест", "createtest@test.ru", "123", "user");
		mvc.perform(post("/registration")	
				.content(objectMapper.writeValueAsString(uDto))
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
	}
	
	
	@Test
	public void authorization() throws Exception {
		
    	uService.create(new UserDto("Тест", "test@test.ru", "123", "user"));
		
		LoginRequestDto requestDto = new LoginRequestDto("test@test.ru", "123");
		mvc.perform(post("/auth")	
				.content(objectMapper.writeValueAsString(requestDto))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}
