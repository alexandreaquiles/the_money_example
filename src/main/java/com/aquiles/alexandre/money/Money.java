package com.aquiles.alexandre.money;

import com.aquiles.alexandre.money.exception.CurrencyNotSupportedException;

public abstract class Money implements Expression {
	protected int amount;
	protected String currency;
	
	Money(int amount, String currency) {
		this.amount = amount;  
		this.currency = currency;
	}
	
	@Override
	public String toString() {
		return amount + " " + currency;
	}

	static Money dollar(int amount) {
		return new Dollar(amount);
	}

	static Money franc(int amount) {
		return new Franc(amount);
	}

	public String currency() {
		return currency;
	}
	
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
	
	public Money reduce(Bank bank, String to) {
		int rate = bank.rate(currency, to);
		return createCurrency(to, amount / rate);
	}
	
	public static Money createCurrency(String to, int amount){
		if(to.equals("CHF"))
			return new Franc(amount);
		else if(to.equals("USD"))
			return new Dollar(amount);
		else
			throw new CurrencyNotSupportedException();

	}
	
}
