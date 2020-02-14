package br.com.workmade.myWallet.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.workmade.myWallet.dto.UserDTO;
import br.com.workmade.myWallet.model.User;
import br.com.workmade.myWallet.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
//@Slf4j
public class UserControllerTest {

	@MockBean
	UserService userService;

	@Autowired
	MockMvc mockMvc;

	private static final String email = "marcosradix@gmail.com";
	private static final String name = "marcos";
	private static final String password = "123456";
	private static final Long userId = 1L;
	private static final String URL = "/user";

	@Test
	public void testSave() throws JsonProcessingException, Exception {

		BDDMockito.given(userService.save(Mockito.any(User.class))).willReturn(getMockUser());
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userId);
		userDTO.setEmail(email);
		userDTO.setName(name);
		userDTO.setPassword(password);
		
		mockMvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(userDTO))
				.contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.data.userId").value(userId))
				.andExpect(jsonPath("$.data.email").value(email))
				.andExpect(jsonPath("$.data.name").value(name))
				.andExpect(jsonPath("$.data.password").value(password));
	}
	@Test
	public void testSaveInvalidUser() throws JsonProcessingException, Exception {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userId);
		userDTO.setEmail("emailtest");
		userDTO.setName(name);
		userDTO.setPassword("1");
		mockMvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(userDTO))
				.contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors['email']").value("Email inválido"))
				.andExpect(jsonPath("$.errors['password']").value("A senha deve conter no mínimo 6 caracteres"));
		
	}

	public User getMockUser() {
		User user = new User();
		user.setUserId(userId);
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		return user;
	}

	public String getJsonPayload(UserDTO dto) throws JsonProcessingException {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(dto.getUserId());
		userDTO.setEmail(dto.getEmail());
		userDTO.setName(dto.getName());
		userDTO.setPassword(dto.getPassword());

		ObjectMapper mapper = new ObjectMapper();
		String json = null;

		json = mapper.writeValueAsString(userDTO);
		return json;

	}
}
