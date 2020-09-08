package org.khl.chat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.khl.chat.dto.LoginRequestDto;
import org.khl.chat.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class SimpleChatApplicationTests {

	@Autowired
	private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void authorization() throws Exception {
		
		UserDto uDto = new UserDto("Тест", "test@test.ru", "123", "user");
		mvc.perform(post("/registration")
				.content(objectMapper.writeValueAsString(uDto))
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
		
		
//		LoginRequestDto reqDto = new LoginRequestDto("test@test.ru", "123");
//		mvc.perform(post("/auth")
//				.content(objectMapper.writeValueAsString(reqDto))
//				.contentType(MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk());
	}

}
