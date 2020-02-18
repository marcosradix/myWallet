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
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class WalletDTO {

	private Long walletId;
	
	@Column(nullable= false)
	@Size(min=3, message="O tamanho deve ser de no mínimo 3 caracters")
	@NotNull
	private String name;
	@NotNull(message="Este campo deve ser preenchido")
	@Column(nullable= false)
	private BigDecimal value;

	public WalletDTO(Wallet wallet) {
		this.walletId = wallet.getWalletId();
		this.name = wallet.getName();
		this.value = wallet.getValue();
	}

}
