package br.com.workmade.myWallet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.workmade.myWallet.enums.Type;
import br.com.workmade.myWallet.model.Wallet;
import br.com.workmade.myWallet.model.WalletItem;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class WalletItemRepositoryTest {
	@Autowired
	WalletItemRepository walletItemRepository;
	
	@Autowired
	WalletRepository walletRepository;
	
	private static final Date DATE = new Date();
	
	private static final Type TYPE = Type.ENTRADA;
	
	private static final String DESCRIPTION = "Conta de Luz";
	
	private static final BigDecimal VALUE = new BigDecimal(65);
	
	
	
	@Before
	public void setUp() {

		
	}
	
	@After
	public void tearDown() {
		
		
	}
	
	@Test
	public void testSave() {
		Wallet wallet =  Wallet.builder()
				.name("Carteira 1")
				.value(BigDecimal.valueOf(500))
				.build();
		Wallet walletSaved = walletRepository.save(wallet);
		
		WalletItem walletItem = WalletItem.builder()
				.wallet(walletSaved)
				.date(DATE)
				.type(TYPE)
				.description(DESCRIPTION)
				.value(VALUE)
				.build();
		
		
		WalletItem walletItemSaved = walletItemRepository.save(walletItem);
		
		assertNotNull(walletItemSaved);
		assertEquals(walletItemSaved.getDescription(), DESCRIPTION);
		assertEquals(walletItemSaved.getType(), TYPE);
		assertEquals(walletItemSaved.getValue(), VALUE);
		assertEquals(walletItemSaved.getDate(), DATE);
		assertEquals(walletItemSaved.getWallet().getWalletId(), walletSaved.getWalletId());
		
		

	}

}
