package br.com.workmade.myWallet.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.workmade.myWallet.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
	
	private Long userId;
	@Email(message="Email inválido")
	private String email;
	@Size(min=3, max=50, message="O nome deve conter entre 3 e 50 caracteres")
	@NotBlank(message="O nome deve ser informado")
	private String name;
	@Size(min=6, message="A senha deve conter no mínimo 6 caracteres")
	@NotBlank(message="A senha não pode ser vazia")
	private String password;
	
	public UserDTO(User user){
		this.userId = user.getUserId();
		this.email = user.getEmail();
		this.name = user.getName();
		this.password = user.getPassword();
	}
	
}
