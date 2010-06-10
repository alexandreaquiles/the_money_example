package com.aquiles.alexandre.money.exception;

public class CurrencyNotSupportedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CurrencyNotSupportedException() {
		super("Currency Not Supported");
	}
}
