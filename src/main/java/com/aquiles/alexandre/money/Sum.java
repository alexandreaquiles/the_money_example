package com.aquiles.alexandre.money;

public class Sum implements Expression {

	Expression augend;
	Expression addend;

	public Sum(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
	}

	@Override
	public Money reduce(Bank bank, String to) {
		int amount = augend.reduce(bank, to).amount 
			+ addend.reduce(bank, to).amount;
		return new Money(amount, to);
	}

	@Override
	public Expression plus(Expression addend) {
		// TODO Auto-generated method stub
		return null;
	}
}
