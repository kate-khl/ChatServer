package org.khl.chat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.khl.chat.dto.ChatDto;
import org.khl.chat.dto.CreateRequestChat;
import org.khl.chat.dto.LoginRequestDto;
import org.khl.chat.dto.RegistrationUserRequest;
import org.khl.chat.dto.UserDto;
import org.khl.chat.service.ChatService;
import org.khl.chat.service.TokenService;
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
public class UserControllerTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private MockMvc mokMvcWithoutFilters;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private UserService uService;
    @Autowired
    private TokenService tokenService;
//    @Autowired
//    private ChatService chatService;
    
    @BeforeEach
    public void setup() {
    	this.mokMvcWithoutFilters = MockMvcBuilders.webAppContextSetup(context).build();

	}
    
	@Test
	public void createUser() throws Exception {
		RegistrationUserRequest uDto = new RegistrationUserRequest("Тест", "create@test.ru", "123", "user");
    	
    	mokMvcWithoutFilters.perform(post("/registration")	
				.content(objectMapper.writeValueAsString(uDto))
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
	}
	
	@Test
	public void authorization() throws Exception {
		
    	uService.create(new RegistrationUserRequest("Тест", "auth@test.ru", "123", "user"));
    	
		LoginRequestDto requestDto = new LoginRequestDto("auth@test.ru", "123");
		mokMvcWithoutFilters.perform(post("/auth")	
				.content(objectMapper.writeValueAsString(requestDto))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	public void removeUser() throws Exception {
		
		UserDto user = uService.create(new RegistrationUserRequest("Тест", "delete@test.ru", "123", "user"));
		mockMvc.perform(delete("/users/{id}", user.getId())
			.header("Authorization", tokenService.getToken("auth@test.ru", "123")))
		.andExpect(status().isOk());
	}
	
	@Test
	public void readAllUsers() throws Exception {
		mockMvc.perform(get("/users/list")
			.header("Authorization", tokenService.getToken("auth@test.ru", "123"))
	        .param("page", "1")
	        .param("size", "5") )   
		.andExpect(status().isOk());
	}
	
	@Test
	public void findUserById() throws Exception {
		UserDto user = uService.create(new RegistrationUserRequest("Тест", "find@test.ru", "123", "user"));
		mockMvc.perform(get("/users/{id}", user.getId())
			.header("Authorization", tokenService.getToken("auth@test.ru", "123")))
		.andExpect(status().isOk());
	}
	
	@Test
	public void editUser() throws Exception {
		UserDto uDto = uService.create(new RegistrationUserRequest("Тест", "edit@test.ru", "123", "user"));
		uDto.setName("Тест1");
		
		mockMvc.perform(patch("/users/{id}", uDto.getId())
			.header("Authorization", tokenService.getToken("auth@test.ru", "123"))
			.content(objectMapper.writeValueAsString(uDto))
			.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
//	@Test
//	public void getUsersfromChat() throws Exception {
//		
//		UserDto uDto1 = uService.create(new RegistrationUserRequest("Тест1", "getUsersFromChat1@test.ru", "123", "user"));
//		UserDto uDto2 = uService.create(new RegistrationUserRequest("Тест2", "getUsersFromChat1@test.ru", "123", "user"));
//		
//		Collection<Long> userIds = new ArrayList();
//		userIds.add(uDto1.getId());
//		userIds.add(uDto2.getId());
//
//		ChatDto chatDto = chatService.createChat(new CreateRequestChat(userIds, "Chat1", "Hello"));
//		
//		mockMvc.perform(get("/users/chats/{id}", chatDto.getId()))
//		.andExpect(status().isOk());
//	}
	
}
