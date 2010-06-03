package com.aquiles.alexandre.money;

public class Bank {

	Money reduce(Expression source, String to) {
		return source.reduce(to);
	}

}
