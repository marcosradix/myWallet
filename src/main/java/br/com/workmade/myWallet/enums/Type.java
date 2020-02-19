package br.com.workmade.myWallet.enums;

public enum Type {

	ENTRADA("ENTRADA"), SAIDA("SAIDA");

	private final String value;

	Type(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static Type getType(String value) {
		for (Type t : values()) {
			if (value.equals(t.getValue())) {
				return t;
			}

		}
		return null;

	}

}
