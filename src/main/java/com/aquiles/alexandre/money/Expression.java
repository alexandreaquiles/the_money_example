package com.aquiles.alexandre.money;

public interface Expression {

	Money reduce(Bank bank, String to);

}
