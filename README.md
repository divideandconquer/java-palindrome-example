# Java Palindrome Example
This is a simple example of a Java web service powered by JAX-RS.  If you run it and make a get request to
`/java-palindrome-example/palindrome/<string>`  The service will find the largest palindrome in
that string and return it to you in the following format:

```json
{
	"palindrome": "foobarraboof"
}
```
