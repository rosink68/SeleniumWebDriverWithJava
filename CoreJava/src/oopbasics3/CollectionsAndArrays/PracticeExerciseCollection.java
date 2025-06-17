package oopbasics3.CollectionsAndArrays;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class PracticeExerciseCollection {

	public static void main(String[] args) {
		
		int a[] ={4,5,5,5,4,6,6,9,4}; 
		
		// Ausgeben, wie oft jede Nummer im Array vorkommt
		// 4: 3x, 5: 3x, 6: 2x, 9: 1x
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		// print unique number from the list
		for(int i=0; i<a.length; i++) {
			
			// für jeden Wert zurücksetzen
			int k = 0;
			
			// wenn die Zahl noch nicht enthalten ist ==> zur Liste zufügen
			if(!al.contains(a[i])) {
				
				al.add(a[i]);
				k++; // Ziffer wurde zum 1. Mal gefunden
				
				// Prüfen, wie oft Ziffer noch im Array verkommt
				// dabei wird beim 1. Fundort + 1 beginnen zu schauen
				for(int j=i+1; j<a.length; j++) {
					
					// wenn eine gleiche Ziffer gefunden wird
					if(a[i] == a[j]) {
						k++; // Ziffer wurde erneut gefunden
					}
				}
				
				System.out.println(a[i] + " was found " + k + " times.");	
				
				// die Zahl ausgeben, die nur 1x im Array enthalten ist
				if(k==1) {
					System.out.println(a[i]+" is unique number");
				}
			}
		}
		
		// Zusatzaufgabe
		
		System.out.println("===========================================");
		
		// Ausgabe der Elemente mit forEach und Lambda
        al.forEach(element -> System.out.println(element));

		System.out.println("-------------------------------------------");

        // Umgekehrte Ausgabe mit Lambda
		// 1. die ArrayList mit Collections.reverse() umgekehren 
		// 2. mit forEach über jedes Element der umgekehrten Liste iteriert und dieses ausgegeben
		// der Lambda-Ausdruck item -> System.out.println(item) gibt jedes Element auf der Konsole aus. 
        //Collections.reverse(al);
        //al.forEach(item -> System.out.println(item));

        // Oder mit Stream und Lambda
        // 1. IntStream.range(0, list.size()) erzeugt einen Stream von Indizes von 0 bis zur Größe der Liste
        // 2. map(i -> list.size() - 1 - i) wandelt jeden Index in den entsprechenden Index der umgekehrten Liste um
        // 3. forEach(i -> System.out.println(list.get(i))) gibt dann das Element an diesem Index aus
        System.out.println("Mit Stream:");
        IntStream.range(0, al.size())
        		 .map(i -> al.size() - 1 - i)
                 .forEach(i -> System.out.println(al.get(i)));
	}

}
