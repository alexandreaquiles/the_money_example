package com.aquiles.alexandre.money;

public class Money {
	protected int amount;

	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.amount == money.amount
		&& getClass().equals(money.getClass());
	}
}
