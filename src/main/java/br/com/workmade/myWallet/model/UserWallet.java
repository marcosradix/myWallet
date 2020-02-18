package br.com.workmade.myWallet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="user_wallet")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserWallet {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="user_wallet_id")
	private Long userWalletId;
	
	@JoinColumn(name="user", referencedColumnName="user_id")
	@ManyToOne(fetch=FetchType.LAZY) // trará apenas o id
	private User user;
	
	@JoinColumn(name="wallet", referencedColumnName="wallet_id")
	@ManyToOne(fetch=FetchType.LAZY) // trará apenas o id
	private Wallet wallet;
	



}
