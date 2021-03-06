package br.com.workmade.myWallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.workmade.myWallet.dto.UserDTO;
import br.com.workmade.myWallet.model.User;
import br.com.workmade.myWallet.service.UserService;
import br.com.workmade.myWallet.utils.Bcrypt;
import br.com.workmade.myWallet.utils.Response;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="user")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO userDTO, BindingResult bindResult){
		Response<UserDTO> response = new Response<UserDTO>();
		if(bindResult.hasErrors()) {
/*			List<FieldError> fieldErrors = bindResult.getFieldErrors();
			   for (FieldError fieldError : fieldErrors) {
				   response.getErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
			    }*/
			
			 bindResult.getAllErrors()
			.forEach(erro -> response.getErrors().put( ( (FieldError) erro).getField(), erro.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		userDTO.setPassword(Bcrypt.getHash(userDTO.getPassword()));
		User userSaved = userService.save(new User(userDTO));
		userSaved.setPassword(null);
		log.info("Usuário salvo:{}",userSaved);
		response.setData(new UserDTO(userSaved));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
}
