package br.com.workmade.myWallet.utils;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response<T> {
	
	private T data;
	private Map<String, String> errors;
	
	public Map<String, String> getErrors(){
		if(this.errors == null) {
			return this.errors = new HashMap<>();
		}
		 return errors;
	}

}
