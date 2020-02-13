package br.com.workmade.myWallet.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.workmade.myWallet.model.User;
import br.com.workmade.myWallet.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserRepository userRepository;
	
	private static final String email = "marcosradix@gmail.com";
	
	@Before
	public void setUp() {
		User user = new User();
		user.setEmail(email);
		user.setName("marcos");
		user.setPassword("123456");
		userRepository.save(user);
		
	}
	
	@After
	public void tearDown() {
		userRepository.deleteAll();
		
	}
	
	@Test
	public void testFindByEmail() {
		 Optional<User> userByEmail = userRepository.findByEmailEquals(email);
		 assertTrue(userByEmail.isPresent());
		 assertEquals(userByEmail.get().getEmail(), email);
	}
	
	@Test
	public void testSave() {
		
		User user = new User();
		user.setEmail(email);
		user.setName("marcos");
		user.setPassword("123456");
		User userSaved = userRepository.save(user);
		
		assertNotNull(userSaved);
	}

}
