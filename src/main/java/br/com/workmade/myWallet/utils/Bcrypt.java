package br.com.workmade.myWallet.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Bcrypt {
	
	public static String getHash(String password) {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(StringUtils.isEmpty(password)) {
			return null;
		}
		return encoder.encode(password);
	}

}
