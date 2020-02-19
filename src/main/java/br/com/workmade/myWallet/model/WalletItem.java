package br.com.workmade.myWallet.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "wallet_item")
@ToString
public class WalletItem {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="wallet_item_id")
	private Long walletItemId;
	
	@JoinColumn(name="wallet", referencedColumnName="wallet_id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Wallet wallet;
	
	private String description;
	
	@Column(nullable= false)
	private BigDecimal value;
	
	@Column(nullable= false)
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Column(nullable= false)
	private Date date;

}
