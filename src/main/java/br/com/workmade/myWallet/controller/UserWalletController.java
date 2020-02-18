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

import br.com.workmade.myWallet.dto.UserWalletDTO;
import br.com.workmade.myWallet.model.User;
import br.com.workmade.myWallet.model.UserWallet;
import br.com.workmade.myWallet.model.Wallet;
import br.com.workmade.myWallet.service.UserWalletService;
import br.com.workmade.myWallet.utils.Response;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="userWallet")
@Slf4j
public class UserWalletController {

	@Autowired
	private UserWalletService userWalletService;
	
	@PostMapping
	public ResponseEntity<Response<UserWalletDTO>> create(@Valid @RequestBody UserWalletDTO userWalletDTO, BindingResult bindResult){
		Response<UserWalletDTO> response = new Response<UserWalletDTO>();
		if(bindResult.hasErrors()) {
			 bindResult.getAllErrors()
			.forEach(erro -> response.getErrors().put( ( (FieldError) erro).getField(), erro.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		UserWallet userWallet = UserWallet.builder()
				.user(
						User.builder().userId(userWalletDTO.getUser()).build())
				.wallet(Wallet.builder().walletId(userWalletDTO.getWallet()).build())
				.build();
		UserWallet userWalletSaved = userWalletService.save(userWallet);
	
		log.info("user Wallet salvo:{}",userWalletSaved);
		response.setData(new UserWalletDTO(userWalletSaved));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
}
