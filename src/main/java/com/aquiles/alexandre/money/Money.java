package com.aquiles.alexandre.money;

abstract public class Money {
	protected int amount;

	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.amount == money.amount
		&& getClass().equals(money.getClass());
	}

	public static Money dollar(int amount) {
		return new Dollar(amount);
	}

	public static Franc franc(int amount) {
		return new Franc(amount);
	}

	abstract public Money times(int amount);
}
