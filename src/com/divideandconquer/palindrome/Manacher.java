package com.divideandconquer.palindrome;

import java.util.Arrays;

/**
 * This class implements the Manacher algorithm for the Parser interface
 * @author divideandconquer
 */
public class Manacher implements Parser {
	
	final private static char BOUNDARY = '|';
	
	/**
	 * This function will examine the input string and find the largest palindrome it contains
	 * using the Manacher algorithm
	 * @param input - a string to parse for palindromes
	 * @return String - the largest palindrome found
	 */
	public String findLargestPalindrome(String input) {
		String result = "";
		if ( input != null && input.length() > 0 ) {
			char[] withBoundaries = addBoundaries(input.toLowerCase().toCharArray());
			int[] p = new int[withBoundaries.length]; // holds the distance to the center of the palindrome including boundaries
			int c = 0; // c marks the center of the palindrome 
			int r = 0; // r marks the right most boundary of the palindrome
			
			for ( int i = 1; i < withBoundaries.length-1; i++ ) {				
				// if we still have a palindrome of more than 1
				// p[i] is the min of the difference between the center and the right
				// and the length of its mirror index's palindrome
				if (r > i) {					
					int mirror = c*2-i; // the mirrored position of i around c
					p[i] = Math.min(r-i, p[mirror]);
				}				
				
				//search for palindromes from this point
				while ((i + (1+p[i])) < withBoundaries.length  && (i - (1+p[i])) >= 0 && withBoundaries[i + (1+p[i])] == withBoundaries[i - (1+p[i])]) {
					p[i]++; // we've found a bigger palindrome so ++
				}
				
				// if the palindrome expands past r we must recenter it
				if ( (i+p[i]) > r ) {
					c = i;
					r = i+p[i];
				}
			}
			
			// loop and find the longest
			int len = 0; c = 0;
			for (int i = 1; i < withBoundaries.length; i++ ) {
				if (len < p[i]) {
					len = p[i];
					c = i;
				}
			}
			// substring the result
			char[] charResult = Arrays.copyOfRange(withBoundaries, c-len, c+len+1);
			// remove the boundaries
			result = String.valueOf(removeBoundaries(charResult));			
		}
		return result;
	}
	
	private static char[] addBoundaries(char[] orig) {
		//The derived string will comprise N*2 + 1 elements
		// with each letter of the original surrounded by boundary characters 
		char[] result = new char[(orig.length*2) + 1];
		for (int i = 0; i < result.length-1; i = i+2) {
			// for each letter in the orig string place a boundary before it
			result[i] = BOUNDARY;
			result[i+1] = orig[i/2];
		}
		
		//add the last boundary to the end
		result[result.length-1] = BOUNDARY;
		return result;
	}
	
	private static char[] removeBoundaries(char[] derived) {
		// the derived string is N*2+1 long so we must substract 1 and divide by 2
		// in order to get back to the original length
		char[] result = new char[(derived.length-1)/2];
		
		// just in case our boundary is in the string we can't use string replace / regex
		// to help us here.
		// Instead we loop and rebuild the string
		for ( int i = 0; i < result.length; i++) {
			result[i] = derived[i*2+1];
		}
		return result;
	}
}
