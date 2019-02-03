### Framework used:
Source: Micronaut 1.0.3, A JVM based fullstack framework has been used to build this application.
Unit test: Spock

Link: https://micronaut.io/

### Languages used: 
Source code: Java 1.8
Test cases: Groovy 2.4

### Useful Info to run the app:
1. Install the Java 1.8 and micronaut 1.0.3
2. To run the application: `./gradlew run`
3. A POST request on `http://localhost:8080/play` with the JSON body as

```
{
"n": 2,
"firstNMoves": [[1, 6],[2, 2]],
"playersMove": [
		[1, 5],
		[2, 6],
		[1, 3],
		[2, 4],
		[1, 5],
		[2, 2],
		[1, 6],
		[2,1],
		[1, 4],
		[2, 1],
		[1, 6],
		[2, 1],
		[1,5],
		[2, 5]
	]
}
```

### Limitation:
- It accepts 2 <= n <=6.