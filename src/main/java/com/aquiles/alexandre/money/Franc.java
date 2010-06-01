package com.aquiles.alexandre.money;

public class Franc extends Money {

	Franc(int amount, String currency) {
		super(amount, currency);
	}

	public Money times(int multiplier) {
		return new Money(amount *  multiplier, currency);
	}

}
