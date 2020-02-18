package br.com.workmade.myWallet.dto;

import javax.validation.constraints.NotNull;

import br.com.workmade.myWallet.model.UserWallet;
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
public class UserWalletDTO {
	
	private Long userWalletId;
	@NotNull(message="O id do usuário deve ser preenchido")
	private Long user;
	@NotNull(message="O id da carteira deve ser preenchido")
	private Long wallet;
	
	public UserWalletDTO(UserWallet userWallet) {
		this.userWalletId = userWallet.getUserWalletId();
		this.wallet = userWallet.getWallet().getWalletId();
		this.user = userWallet.getUser().getUserId();
		
	}

}
