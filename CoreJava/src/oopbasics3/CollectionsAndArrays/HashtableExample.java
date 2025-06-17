package oopbasics3.CollectionsAndArrays;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableExample {

	public static void main(String[] args) {
		
		/**
		 * eine Hashtable is synchronized and thread safe <== im Gegensatz zum HashMap
		 * 
		 * thread safe bedeutet: wenn ein Zugriff auf eine Hashtable passiert, 
		 * müssen alle anderen Zugriffe warten, bis die Hashtable wieder freigegeben ist
		 * 
		 * Hashtable do not allow one null keys and null values
		 * 
		 * Hashtable is the only class other than vector which uses enumerator to
		 * iterate the values of Hashtable object
		 */

		// im Hashtable ist ein Key zu einem Wert gemappt
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
		ht.put(0, "Hello");
		ht.put(1, "Goodbye");
		ht.put(42, "Good Morning");
		ht.put(3, "Good Evening");
		System.out.println(ht.get(42));
		// java.lang.NullPointerException, da keine null values erlaubt sind
		//hm.put(6, null);
		
		ht.remove(42);
		System.out.println(ht.get(42));
		
		// alle Entries mit Key-Value als Set
		Enumeration<Integer> e = ht.keys();
		
		while(e.hasMoreElements()) {
			
			System.out.println("----------");

			// Getting the key of a particular entry
            int key = e.nextElement();
			System.out.println("Key: " + key);
            		
			// Value zum Key ermitteln
			System.out.println("Value: " + ht.get(key));
		}
	}
}
