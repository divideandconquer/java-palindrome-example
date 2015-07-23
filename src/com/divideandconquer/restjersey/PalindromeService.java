package com.divideandconquer.restjersey;

/**
 * This service will accept strings and return the largest palindrome in that string
 * @author divideandconquer
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.divideandconquer.palindrome.*;
import org.json.JSONObject;

@Path("/palindrome")
public class PalindromeService {
	@Path("{input}")
	@GET
	@Produces("application/json")
	public String findLargestPalindrome(@PathParam("input") String input) {
		Manacher m = new Manacher();
		String ret = m.findLargestPalindrome(input);
		
		//encode to json
		JSONObject obj = new JSONObject();
		obj.put("palindrome", ret);
		return obj.toString();
	}
	
	@GET
	@Produces("application/json")
	public String test() {
		//encode to json
		JSONObject obj = new JSONObject();
		obj.put("palindrome", "test");
		return obj.toString();
	}
}
