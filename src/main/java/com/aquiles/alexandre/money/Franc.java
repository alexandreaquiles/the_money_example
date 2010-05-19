package com.aquiles.alexandre.money;

public class Franc extends Money {

	Franc(int amount) {
		this.amount = amount;
	}

	public Money times(int multiplier) {
		return Money.franc(amount *  multiplier);
		
	}
	
}
