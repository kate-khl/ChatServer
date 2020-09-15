package org.khl.chat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.khl.chat.dto.LoginRequestDto;
import org.khl.chat.dto.UserDto;
import org.khl.chat.entity.User;
import org.khl.chat.service.ChatService;
import org.khl.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

	@Autowired
	private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private UserService uService;
//    @Autowired
//    private ChatService chatService;
    
    
    
    @Before
    public void setup() {
    	this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
	@Test
	public void createUser() throws Exception {
    	UserDto uDto = new UserDto("Тест", "create@test.ru", "123", "user");
		mvc.perform(post("/registration")	
				.content(objectMapper.writeValueAsString(uDto))
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
	}
	
	@Test
	public void authorization() throws Exception {
    	uService.create(new UserDto("Тест", "auth@test.ru", "123", "user"));
		LoginRequestDto requestDto = new LoginRequestDto("auth@test.ru", "123");
		mvc.perform(post("/auth")	
				.content(objectMapper.writeValueAsString(requestDto))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	public void removeUser() throws Exception {
		UserDto user = uService.create(new UserDto("Тест", "delete@test.ru", "123", "user"));
		mvc.perform(delete("/users/{id}", user.getId()))	
		.andExpect(status().isOk());
	}
	
	@Test
	public void readAllUsers() throws Exception {
		mvc.perform(get("/users/list")
        .param("page", "1")
        .param("size", "5") )   
		.andExpect(status().isOk());
	}
	
	@Test
	public void findUserById() throws Exception {
		UserDto user = uService.create(new UserDto("Тест", "find@test.ru", "123", "user"));
		mvc.perform(get("/users/{id}", user.getId()))
		.andExpect(status().isOk());
	}
	
//	@Test
//	public void editUser() throws Exception {
//		UserDto user = uService.create(new UserDto("Тест", "edit@test.ru", "123", "user"));
//		mvc.perform(get("/users/{id}", user.getId()))
//		.andExpect(status().isOk());
//	}
	
//	@Test
//	public void getUsersfromChat() throws Exception {
//		
//		
//		UserDto user = uService.create(new UserDto("Тест", "find@test.ru", "123", "user"));
//		mvc.perform(get("/users/{id}", user.getId()))
//		.andExpect(status().isOk());
//	}
	
}
