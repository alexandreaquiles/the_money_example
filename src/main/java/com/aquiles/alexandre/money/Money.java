package com.aquiles.alexandre.money;

public class Money implements Expression {
	protected int amount;
	protected String currency;
	
	Money(int amount, String currency) {
		this.amount = amount;  
		this.currency = currency;
	}
	
	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.amount == money.amount
		&& currency().equals(money.currency());
	}

	static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	Money times(int multiplier) {
		return new Money(amount *  multiplier, currency);
	}

	public String currency() {
		return currency;
	}
	
	@Override
	public String toString() {
		return amount + " " + currency ;
	}

	Expression plus(Money addend) {
		return new Money(amount + addend.amount, currency);
	}

}
