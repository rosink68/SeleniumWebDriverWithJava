package oopbasics3.CollectionsAndArrays;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		
		// HashSet, TreeSet, LikedHashset implements Set interface
		// Set interface does not accept duplicate values
		// There is no guarantee elements stored in sequential order. <== Random order
		
		HashSet<String> hs = new HashSet<String>();
		hs.add("USA");
		hs.add("UK");
		hs.add("GERMANY");
		// UK wird nicht nochmal zugefügt
		hs.add("UK");
		hs.add("INDIA");
		hs.add("DUTCH");
		hs.add("IRLAND");
		System.out.println(hs);
		
		hs.remove("INDIA");
		System.out.println(hs);
		
		System.out.println(hs.isEmpty());
		System.out.println(hs.size());
		
		Iterator<String> it = hs.iterator();
		// initial zeigt der Zeiger auf den 0. Index <== ermitteln mit next()
		// mit hasNext() wird ermittelt, ob es noch ein Element gibt
		while(it.hasNext()) {
			System.out.println(it.next());			
		}
		
		
		
		
	}
}
