package br.com.workmade.myWallet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.workmade.myWallet.model.User;
import br.com.workmade.myWallet.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		return this.userRepository.save(user);
		
	}
	
	public Optional<User> findByEmail(String email) {
		return this.userRepository.findByEmailEquals(email);
		
	}
	

}
