package br.com.workmade.myWallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.workmade.myWallet.model.Wallet;
import br.com.workmade.myWallet.repository.WalletRepository;

@Service
public class WalletService {
	
	@Autowired
	private WalletRepository walletRepository;
	
	public Wallet save(Wallet wallet) {
		return this.walletRepository.save(wallet);
		
	}
	

	

}
