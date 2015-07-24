# Java Palindrome Example
This is a simple example of a Java web service powered by JAX-RS.  
This service uses the [Manacher algorithm](https://en.wikipedia.org/wiki/Longest_palindromic_substring) 
to find the longest palindrome in a given string.


## API

`GET /java-palindrome-example/palindrome/<string>`

Parses the string provided and finds the largest palindrome that it contains. An optional query parameter
of `type` can also be set to `slow` in this case the service will use a significantly slower recursive
algorithm.

### Example 

`GET /java-palindrome-example/palindrome/testingpalindromefoobarraboof?type=slow`

```json
{
	"palindrome": "foobarraboof"
}
```
