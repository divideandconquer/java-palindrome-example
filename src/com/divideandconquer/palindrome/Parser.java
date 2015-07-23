package com.divideandconquer.palindrome;

/**
 * A palindrome.Parser can find the largest palindrome in a given string
 * @author divideandconquer
 */
public interface Parser {
	/**
	 * This function will examine the input string and find the largest palindrome it contains
	 * @param input - a string to parse for palindromes
	 * @return String - the largest palindrome found
	 */
	public String findLargestPalindrome(String input);
}
