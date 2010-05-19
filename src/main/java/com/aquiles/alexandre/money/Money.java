package com.aquiles.alexandre.money;

abstract public class Money {
	protected int amount;
	protected String currency;
	
	Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.amount == money.amount
		&& getClass().equals(money.getClass());
	}

	public static Money dollar(int amount) {
		return new Dollar(amount, "USD");
	}

	public static Franc franc(int amount) {
		return new Franc(amount, "CHF");
	}

	abstract public Money times(int amount);

	public String currency() {
		return currency;
	}

}
