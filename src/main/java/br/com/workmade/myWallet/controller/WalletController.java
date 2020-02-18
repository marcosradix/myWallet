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

import br.com.workmade.myWallet.dto.WalletDTO;
import br.com.workmade.myWallet.model.Wallet;
import br.com.workmade.myWallet.service.WalletService;
import br.com.workmade.myWallet.utils.Response;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="wallet")
@Slf4j
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@PostMapping
	public ResponseEntity<Response<WalletDTO>> create(@Valid @RequestBody WalletDTO walletDTO, BindingResult bindResult){
		Response<WalletDTO> response = new Response<WalletDTO>();
		if(bindResult.hasErrors()) {
			 bindResult.getAllErrors()
			.forEach(erro -> response.getErrors().put( ( (FieldError) erro).getField(), erro.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		Wallet walletSaved = walletService.save(new Wallet(walletDTO));
	
		log.info("Carteira criada: {}",walletSaved);
		response.setData(new WalletDTO(walletSaved));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
}
