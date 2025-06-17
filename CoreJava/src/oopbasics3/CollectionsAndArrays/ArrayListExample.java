package oopbasics3.CollectionsAndArrays;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ArrayListExample {

	// can accept duplicate values
	// ArrayList, LinkedList und Vector implements List interface ==> sie können duplicate values haben
	// Arrays have a fixed size while the ArrayList can grow dynamically
	// you can access and insert any value in any index
	
	public static void main(String[] args) {
		
		// ArrayList ist dynamisch, während Array beim Init eine feste Größe bekommt 
		ArrayList<String> a = new ArrayList<String>();
		a.add("Eva");
		a.add("Max");
		a.add("java");
		// can accept duplicate values 
		a.add("java");
		a.add("Sarah");
		System.out.println(a);
		
		// ein Element am Anfang einfügen
		a.add(0, "Rainer");
		System.out.println(a);
		
		// Elemente löschen
		//a.remove(1);
		//a.remove("java");
		//System.out.println(a);
		// alle löschen
		//a.removeAll(a);
		//System.out.println(a);
		
		System.out.println(a.isEmpty());
		System.out.println(a.size());
		
		// das Element mit dem Index 2 ermitteln
		System.out.println(a.get(2));
		
		// Prüfen, ob ein Element in der Liste enthalten ist
		System.out.println(a.contains("java"));
		System.out.println(a.contains("selenium"));
		
		// Ermitteln des Index eines Elements 
		System.out.println(a.indexOf("Sarah"));
		
		
		// Übungen
		System.out.println("========================== Übungen ==========================");
		
		/**
		 * 1. ArrayList Manipulation:
		 * - In the main function, modify the ArrayList a to contain the elements 
		 * 	 "apple", "banana", "cherry", "mango", "apple" (with duplicates).
		 * - Print the ArrayList after these additions.
		 */
        ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");
        fruits.add("mango");
        fruits.add("apple");
        System.out.println("All fruits: " + fruits);
        
        /**
         * 2. Element Removal:
         * - Remove the first occurrence of "apple" from the ArrayList.
         * - Print the ArrayList after the removal.
         */
        fruits.remove(0);
        System.out.println("Fruits without last apple: " + fruits);
        
        /**
         * 3. Element Search:
         * - Check if the ArrayList contains the element "orange".
         * - Print a message indicating whether "orange" is found or not.
         */
        if (fruits.contains("orange")) {
        	System.out.println("orange is found in the list..");
        } else {
        	System.out.println("orange is not found in the list");
        }
        
        /**
         * 4. Size and Content Check
         * - Print the size of the ArrayList.
         * - Use a loop to iterate through the ArrayList and print the index and value of each element.
         */
        System.out.println("Size: " + fruits.size());
        for (String fruit : fruits) {
			System.out.println(fruit);
		}
        
        System.out.println("----------- using stream -----------");
        // Ausgabe jedes Elements mit Zeilenumbruch
        Stream<String> stream = fruits.stream();
        stream.forEach(System.out::println);

        System.out.println("----------- using stream and Lambda-Ausdruck -----------");
        // Alternative mit Lambda-Ausdruck
        Stream<String> stream2 = fruits.stream();
        stream2.forEach(fruit -> System.out.println(fruit));
	}
}
