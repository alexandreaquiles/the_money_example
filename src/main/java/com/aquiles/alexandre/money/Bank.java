package com.aquiles.alexandre.money;

import java.util.HashMap;
import java.util.Map;

public class Bank {

	private Map<Pair, Integer> rates = new HashMap<Pair, Integer>(); 
	
	Money reduce(Expression source, String to) {
		return source.reduce(this, to);
	}

	void addRate(String from, String to, int rate) {
		rates.put(new Pair(from, to), rate);
	}
	
	int rate(String from, String to) {
		if(from.equals(to)) 
			return 1;
		return rates.get(new Pair(from, to));
	}

	private class Pair {
		private String from;
		private String to;

		public Pair(String from, String to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((from == null) ? 0 : from.hashCode());
			result = prime * result + ((to == null) ? 0 : to.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Pair other = (Pair) obj;
			if (from == null) {
				if (other.from != null)
					return false;
			} else if (!from.equals(other.from))
				return false;
			if (to == null) {
				if (other.to != null)
					return false;
			} else if (!to.equals(other.to))
				return false;
			return true;
		}

		
		
	}

}
