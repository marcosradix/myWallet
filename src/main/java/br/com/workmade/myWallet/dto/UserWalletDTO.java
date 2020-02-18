package br.com.workmade.myWallet.dto;

import javax.validation.constraints.NotNull;

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
	
	private Long user_wallet_id;
	@NotNull(message="O id do usuário deve ser preenchido")
	private Long user;
	@NotNull(message="O id da carteira deve ser preenchido")
	private Long wallet;

}
