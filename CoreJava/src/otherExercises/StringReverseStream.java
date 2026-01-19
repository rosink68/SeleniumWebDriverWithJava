package otherExercises;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringReverseStream {

	public static void main(String[] args) {
		
		String input = "Sauerkirschmarmelade";
		String reverse = reverseString(input);
		System.out.println("Original: " + input);
		System.out.println("Umgekehrt: " + reverse);
	}
	
	public static String reverseString(String str) {
		
		if (str == null || str.isEmpty()) {
			return str;
		}
		
		// Stream.of(str) - erstellt einen Stream
		return Stream.of(str)
				// Transformation auf jedes Element des Streams
				// konvertiert s (hier ein String = input) in einen StringBuilder
				// reverse kehrt die Zeichenkette um und toString konvertiert sie wieder als String
				.map(s -> new StringBuilder(s).reverse().toString())
				// collect sammelt alle Elemente des Streams (hier ein String) und verkettet sie zu einem einzigen String. 
				// Collectors.joining() ist ein Collector, der die Elemente eines Streams zu einem String zusammenfügt. 
				.collect(Collectors.joining());
		
	}
}
