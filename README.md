### Framework used:
Source: Micronaut 1.0.3 (https://micronaut.io/), A JVM based fullstack framework has been used to build this application.
Unit test: Spock (http://spockframework.org/)

### Languages used: 
Source code: Java 1.8
Test cases: Groovy 2.4

### IDE Used:
- IntelliJ IDEA

### Code
Source code can be found at: `snake-board-game/src/main/java/`
Test cases can be found at: `snake-board-game/src/test/java`

### Useful Info to run the app:
1. Install the Java 1.8, micronaut 1.0.3 and gradle 4.5
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

### Test Coverage Report

![](https://github.com/shivamkrpandey/snake-board-game/blob/master/assets/test-cases.png)

and the running gif of the solution:

![](https://github.com/shivamkrpandey/snake-board-game/blob/master/assets/snakeladdergame.gif)