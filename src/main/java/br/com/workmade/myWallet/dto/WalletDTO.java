package br.com.workmade.myWallet.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.workmade.myWallet.model.Wallet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletDTO {

	private Long walletId;
	
	@Column(nullable= false)
	@Size(min=3)
	@NotNull
	private String name;
	@NotNull
	@Column(nullable= false)
	private BigDecimal value;

	public WalletDTO(Wallet wallet) {
		this.walletId = wallet.getWalletId();
		this.name = wallet.getName();
		this.value = wallet.getValue();
	}

}
