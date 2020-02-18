package br.com.workmade.myWallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.workmade.myWallet.model.UserWallet;
import br.com.workmade.myWallet.repository.UserWalletRepository;

@Service
public class UserWalletService {
	
	@Autowired
	private UserWalletRepository userWalletRepository;
	
	
	public UserWallet save(UserWallet userWallet) {
		return this.userWalletRepository.save(userWallet);
		
	}
	
	

}
