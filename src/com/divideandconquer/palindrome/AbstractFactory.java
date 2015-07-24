package com.divideandconquer.palindrome;

public class AbstractFactory {
	public static final String typeSlow = "slow";
	
	public static Parser Factory(String type) {
		if (type != null && type.equals(typeSlow)) {
			return new Recursive();
		} 
		else {
			return new Manacher();
		}
	}
}
