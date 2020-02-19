package br.com.workmade.myWallet.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.workmade.myWallet.enums.Type;
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
public class WalletItemDTO {
	
	private Long walletItemId;
	@NotBlank(message="O id da carteira deve ser informado")
	private Long wallet;
	@NotBlank(message="O valor não pode ser vazio")
	private BigDecimal value;
	@NotBlank(message="O tipo deve ser informado")
	@Pattern(regexp="^(ENTRADA|SAIDA)$", message="Apenas saão aceitos ENTRA ou SAIDA")
	private Type type;
	@NotBlank(message="A data deve ser informada")
	private Date date;
	private String description;

}
