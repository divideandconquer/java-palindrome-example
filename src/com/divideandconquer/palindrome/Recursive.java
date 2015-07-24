package com.divideandconquer.palindrome;

public class Recursive implements Parser{

	/**
	 * This function will examine the input string and find the largest palindrome it contains recursively
	 * @param input - a string to parse for palindromes
	 * @return String - the largest palindrome found
	 */
	public String findLargestPalindrome(String input) {
		String result = "";
		if (input != null && input.length() > 0 ) {
			result = recursiveFindLargestPalindrome(input.toLowerCase());
		}		
		return result;
	}
	
	private String recursiveFindLargestPalindrome(String input) {
		String result = "";

		if (input.equals(new StringBuilder(input).reverse().toString())) {
			result = input;
		} 
		else {
			String a = recursiveFindLargestPalindrome(input.substring(1));
			String b = recursiveFindLargestPalindrome(input.substring(0, input.length()-1));
			if (a.length() > b.length()) {
				result = a;
			} 
			else {
				result = b;
			}
		}
		
		return result;
	}
}
