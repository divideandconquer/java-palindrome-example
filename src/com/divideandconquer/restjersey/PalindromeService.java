package com.divideandconquer.restjersey;

/**
 * This service will accept strings and return the largest palindrome in that string
 * @author divideandconquer
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import com.divideandconquer.palindrome.*;
import org.json.JSONObject;

@Path("/palindrome")
public class PalindromeService {
	@Path("{input}")
	@GET
	@Produces("application/json")
	public String findLargestPalindrome(@PathParam("input") String input, @QueryParam("type") String type) {
	
		// get the requested parser type from the factory
		Parser p = AbstractFactory.Factory(type);
		
		// find the largest palindrome
		String ret = p.findLargestPalindrome(input);
		
		//encode to json
		JSONObject obj = new JSONObject();
		obj.put("palindrome", ret);
		return obj.toString();
	}
	
	// This exposes the service through the CLI
	public static void main(String[] args) {
		String type = "";
		String input = "";
		if (args.length >= 1) {
			input = args[0];
		}
		if (args.length >= 2) {
			type = args[1];
		}
		PalindromeService p = new PalindromeService();
		System.out.println(p.findLargestPalindrome(input, type));
	}
}
