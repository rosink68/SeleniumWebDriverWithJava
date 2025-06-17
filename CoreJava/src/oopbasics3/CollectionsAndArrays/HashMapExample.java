package oopbasics3.CollectionsAndArrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		
		/**
		 * ein HashMap is not synchronized and not thread safe <== im Gegensatz zur Hashtable
		 * 
		 * not thread safe bedeutet: mehrere Threads/Zugriffe können gleichzeitig auf einem 
		 * HashMap gemacht werden 
		 * 
		 * HashMap allows one null key and any number of null values
		 * 
		 * MashMap object values are iterated by using iterator.
		 */
		
		// im HashMap ist ein Key zu einem Wert gemappt
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(0, "Hello");
		hm.put(1, "Goodbye");
		hm.put(42, "Good Morning");
		hm.put(3, "Good Evening");
		hm.put(6, null);
		System.out.println(hm.get(42));
		
		hm.remove(42);
		System.out.println(hm.get(42));
		
		// alle Entries mit Key-Value als Set
		Set<Entry<Integer, String>> sn = hm.entrySet();
		Iterator<Entry<Integer, String>> it = sn.iterator();
		
		while(it.hasNext()) {
			
			System.out.println("----------");
			
			Entry<Integer, String> itNext = it.next();
			System.out.println(itNext);
			
			// Aufsplitten Key unf Value
			Map.Entry<Integer, String> mp = (Map.Entry<Integer, String>)itNext;
			System.out.println("Key: " + mp.getKey());
			System.out.println("Value: " + mp.getValue());
		}
	}
}
