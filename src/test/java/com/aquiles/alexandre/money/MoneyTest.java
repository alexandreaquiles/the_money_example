package com.aquiles.alexandre.money;

import junit.framework.TestCase;

public class MoneyTest extends TestCase {
	
	public void testMultiplication(){
		Money five = new Dollar(5);
		assertEquals(new Dollar(10), five.times(2));
		assertEquals(new Dollar(15), five.times(3));
	}
		
	public void testFrancMultiplication(){
		Money five = new Franc(5);
		assertEquals(new Franc(10), five.times(2));
		assertEquals(new Franc(15), five.times(3));
	}
	
	public void testEquality(){
		assertTrue(new Dollar(5).equals(new Dollar(5)));
		assertFalse(new Dollar(5).equals(new Dollar(6)));
		assertFalse(new Franc(5).equals(new Dollar(5)));
	}
	
	public void testCurrency(){
		assertEquals("USD", new Dollar(1).currency());
		assertEquals("CHF", new Franc(1).currency());
	}
	
	public void testSimpleAddition(){
		Money five = new Dollar(5); 
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, "USD");
		assertEquals(new Dollar(10), reduced);
	}
	
	public void testPlusReturnsSum(){
		Money five = new Dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum) result;
		assertEquals(five, sum.augend);
		assertEquals(five, sum.addend);
	}
	
	public void testReduceSum(){
		Expression sum = new Sum(new Dollar(3), new Dollar(4));
		Bank bank = new Bank();
		Money result = bank.reduce(sum, "USD");
		assertEquals(new Dollar(7), result);
	}
	
	public void testReduceMoney(){
		Bank bank = new Bank();
		Money result = bank.reduce(new Dollar(1), "USD");
		assertEquals(new Dollar(1), result);
	}
	
	public void testReduceMoneyDifferentCurrency(){
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(new Franc(2), "USD");
		assertEquals(new Dollar(1), result);
	}
	
	public void testIdentityRate(){
		assertEquals(1, new Bank().rate("USD", "USD"));
	}
	
	public void testMixedAddition(){
		Expression fiveBucks = new Dollar(5);
		Expression tenFrancs = new Franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
		assertEquals(new Dollar(10), result);
	}
	
	public void testSumPlusMoney(){
		Expression fiveBucks = new Dollar(5);
		Expression tenFrancs = new Franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
		Money result = bank.reduce(sum, "USD");
		assertEquals(new Dollar(15), result);
	}
	
	public void testSumTimes(){
		Expression fiveBucks = new Dollar(5);
		Expression tenFrancs = new Franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
		Money result = bank.reduce(sum, "USD");
		assertEquals(new Dollar(20), result);
	}
}
