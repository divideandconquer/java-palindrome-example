# Java Palindrome Example
This is a simple example of a Java web service powered by JAX-RS.  This service uses the [Manacher algorithm](https://en.wikipedia.org/wiki/Longest_palindromic_substring) to find the longest palindrome in a given string.


## API

`GET /java-palindrome-example/palindrome/<string>`

Parses the string provided and finds the largest palindrome that is contains.

### Eaxample 

`GET /java-palindrome-example/palindrome/testingpalindromefoobarraboof`

```json
{
	"palindrome": "foobarraboof"
}
```
