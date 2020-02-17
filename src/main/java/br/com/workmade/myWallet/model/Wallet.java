package br.com.workmade.myWallet.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.workmade.myWallet.dto.WalletDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Wallet")
public class Wallet {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="wallet_id")
	private Long walletId;
	
	@Column(nullable= false)
	private String name;
	
	@Column(nullable= false)
	private BigDecimal value;
	
	
	public Wallet(WalletDTO dto) {
		this.walletId = dto.getWalletId();
		this.name = dto.getName();
		this.value = dto.getValue();
	}



}
