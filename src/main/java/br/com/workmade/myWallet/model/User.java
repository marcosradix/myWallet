package br.com.workmade.myWallet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.workmade.myWallet.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	@Column(nullable= false)
	private String email;
	@Column(nullable= false)
	private String name;
	@Column(nullable= false)
	private String password;
	
	
	public User(UserDTO dto){
		this.userId = dto.getUserId();
		this.email = dto.getEmail();
		this.name = dto.getName();
		this.password = dto.getPassword();
	}
}
