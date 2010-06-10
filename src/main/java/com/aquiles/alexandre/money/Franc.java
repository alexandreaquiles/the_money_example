package com.aquiles.alexandre.money;

public class Franc extends Money {

	public Franc(int amount) {
		super(amount,"CHF");
	}

	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.amount == money.amount
		&& currency().equals(money.currency());
	}
	
	public Expression times(int multiplier) {
		return new Franc(amount *  multiplier);
	}

}
