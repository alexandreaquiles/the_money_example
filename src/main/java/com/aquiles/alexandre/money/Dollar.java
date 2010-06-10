package com.aquiles.alexandre.money;

public class Dollar extends Money {

	public Dollar(int amount) {
		super(amount,"USD");
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Dollar)) 
			return false;
		Dollar dollar = (Dollar) object;
		return this.amount == dollar.amount;
	}

	
	public Expression times(int multiplier) {
		return new Dollar(amount *  multiplier);
	}
	
	public Money reduce(Bank bank, String to) {
		int rate = bank.rate(currency, to);
		return new Dollar(amount / rate);
	}


}
