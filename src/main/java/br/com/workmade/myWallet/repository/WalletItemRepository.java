package br.com.workmade.myWallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.workmade.myWallet.model.WalletItem;

@Repository
public interface WalletItemRepository extends JpaRepository<WalletItem, Long> {
	
	

}
