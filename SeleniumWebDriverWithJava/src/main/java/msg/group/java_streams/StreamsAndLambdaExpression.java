package msg.group.java_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;


public class StreamsAndLambdaExpression {
		
	//@Test
	public void regular() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Max");
		names.add("Emma");
		names.add("Johannes");
		names.add("Annegret");
		names.add("Adam");
	
		// Count the number of names starting with alphabet A in list

		int count = 0;
		
		// alle Namen zählen, die mit A beginnen
		for (int i=0; i<names.size(); i++) {
			
			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}	
		}
		
		System.out.println(count);

		
		System.out.println("===========================");

		// alle Namen zählen, die mit A beginnen
		for (int i=0; i<names.size(); i++) {
			
			String actual = names.get(i);
			if (actual.length() > 4) {
				System.out.println(actual);;
			}	
		}

	}

	//@Test
	public void streamFilter() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Max");
		names.add("Emma");
		names.add("Johannes");
		names.add("Annegret");
		names.add("Adam");
		
		// Stream auf names anwenden, d.h. names in einen Stream konvertieren <== names wird nicht geändert
		// <== Stream ist eine Collection von Strings
		// Streams führen die Operationen parallel aus
		// filter() - filtern die ArrayList nach einer bestimmten Bedingung
		
		// Lambda-Ausdrücke: 
		// linke Seite: Deklaration Parameter -> rechte Seite: Aktionen, die ausgeführt werden sollen
		// Parameter actual iteriert durch alle Namen von names <== entspricht names.get(i);
		// actual.startsWith("A") <== entspricht if (actual.startsWith("A"))
		
		// filter erzeugt neuen String, auf dem die Operation count() ausgeführt wird
		// ==> count() wird auf filter(actual->actual.startsWith("A")) angewendet
		// d.h. es werden alle Namen gezählt, die mit "A" beginnen
		// !!!count() wird NUR ausgeführt, wenn filter(actual->actual.startsWith("A")) true zurückgibt!!!
		long count = names.stream().filter(actual->actual.startsWith("A")).count();
		System.out.println(count);
		
		// direkt einen Stream erstellen mit Stream.of()
		// in {} können mehrere Codezeilen stehen
		long c = Stream.of("Max", "Emma", "Johannes", "Annegret", "Adam").filter(s-> 
		{
			s.startsWith("A");
			//return false; // <== da hier false zurückgegeben wird, wird count() nicht ausgeführt
			return true; 	// <== c wird 5, da für jede Filterung true zurückgegeben wird 
		}).count();
		System.out.println(c);

		
		System.out.println("===========================");				
		
		// alle Namen der ArrayList ausgeben, die mindestens 5 Buchstaben haben
		// filter(name-> name.length()>4) erzeugt einen neuen String
		// ==> mit forEach wird jeder name, der vorher gefiltert wurde ausgegeben, 
		// d.h. forEach scannt das gefilterte Array
		names.stream().filter(name-> name.length()>4)
					  .forEach(nameFiltered->System.out.println(nameFiltered));
		
		// nur das 1. Ergebnis von filter(name-> name.length()>4) weiterverarbeiten
		names.stream().filter(name-> name.length()>4)
					  .limit(1)
					  .forEach(nameFiltered->System.out.println(nameFiltered));
	}
	
	//@Test
	public void streamMap() {
		
		// die Namen, die auf "a" enden, in Großbuchstaben ausgeben
		// 1. alle Namen rausfiltern, die auf "a" enden
		// 2. die gefilterten Name mit map() in Großbuchstaben umwandeln, d.h.
		//	  jeden ermittelten Namen mappen in uppercase <== manipuliert den Namen
		// 3. den in Großbuchstaben konvertierten Namen ausgeben
		Stream.of("Max", "Emma", "Johannes", "Annegret", "Berta")
				.filter(name-> name.endsWith("a"))			// Emma, Berta
				.map(name-> name.toUpperCase())				// EMMA, BERTA
				.forEach(name-> System.out.println(name));
		
		// alle Namen in Großbuchstaben ausgeben ==> filter werglassen
		Stream.of("Max", "Emma", "Johannes", "Annegret", "Berta")
					.map(name-> name.toUpperCase())				
					.forEach(name-> System.out.println(name));

		
		System.out.println("===========================");
		
		// da stream nur auf ArrayList angewendet werden können, muss das Array in eine (Array)List konvertiert werden 
		List<String> names = Arrays.asList("Arun", "Anton", "Johannes", "Adam", "Berta");
		// die Namen, die mit "A" beginnen, in Großbuchstaben und sortiert ausgeben
		names.stream().filter(name-> name.startsWith("A"))
					  .sorted()
					  .map(name-> name.toUpperCase())
					  .forEach(name-> System.out.println(name));
		
		// die Liste sortieren und ausgeben
		names.stream().sorted().forEach(name-> System.out.println(name));

		
		System.out.println("===========================");
	}
	
	//@Test
	public void mapTwoStreamList() {
		
		// 2 Listen zusammenfügen
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Max");
		names.add("Emma");
		names.add("Sarah");

		List<String> names1 = Arrays.asList("Max", "Anton", "Johannes", "Adam", "Berta");
		
		// erzeugen eines neuen Streams durch Verketten der beiden Listen 
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(name-> System.out.println(name));
		
		// Prüfen, ob "Adam" in der neuen Liste/Stream ist
		Stream<String> newStream1 = Stream.concat(names.stream(), names1.stream());
		// newStream kann nicht genommen werden, weil ein bereits modifizierten Stream nicht funktioniert
		// flag ist true, wenn "Adam" enthalten ist
		// ACHTUNG! Hier wird nicht filter() genommen, weil filter() eine Teilliste zurückgibt,
		// 			mit der ggf. noch andere Operationen ausgeführt werden
		boolean flag = newStream1.anyMatch(name-> name.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollect() {
		
		// eine neue, modifizierte Liste erstellen
		
		// collect(Collectors.toList()) - sammelt die Ergebnisse der map()-Methode in eine Liste 
		List<String> ls = Stream.of("Max", "Emma", "Johannes", "Annegret", "Berta")
					.filter(name-> name.endsWith("a"))	// Emma, Berta
					.map(name-> name.toUpperCase())		// EMMA, BERTA
					.collect(Collectors.toList());
		
		// 1. Element der neuen Liste ausdrucken
		System.out.println(ls.get(0));
		
		
		// die Nummer ohne Dopplung sortiert ausgeben
		List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
		values.stream().distinct()
					   .sorted()
					   .forEach(value-> System.out.println(value));
		
		// das 3. Element der sortierten Liste ausgeben
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}
}
