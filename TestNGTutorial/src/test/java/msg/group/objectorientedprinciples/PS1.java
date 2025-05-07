package msg.group.objectorientedprinciples;

import org.testng.annotations.Test;

// Child class
public class PS1 extends PS {

	/**
	 * Bei Vererbung werden sobald in der Child class ein Test ausgeführt wird, 
	 * auch alle Annotations wie @BeforeMethod ... der Parent class ausgeführt.
	 */
	
	/**
	 * „Extends“ ist in Java ein Schlüsselwort, das bei der Klassendeklaration 
	 * mit der untergeordneten Klasse geschrieben wird, gefolgt vom Namen der 
	 * übergeordneten Klasse. Wenn eine untergeordnete Klasse eine Klasse erweitert, 
	 * erwirbt oder erbt sie alle Eigenschaften der übergeordneten Klasse.
	 */
	
	
	@Test
	public void testRun() {
		
		// Aufruf über Erstellung eines Objekts
		PS2 ps2 = new PS2(3);
		System.out.println(ps2.increment());
		System.out.println(ps2.decrement());
		
		//PS3 ps3 = new PS3(3);
		// PS2 erweitert PS3 und erbt somit alle Eigenschaften und Methoden von PS3
		
		System.out.println(ps2.multiplyThree());
		
		
		
		
		// es ist nicht notwendig, ein Objekt zu erstellen, um die Methode doThis() aufzurufen,
		// da PS die Klasse PS1 erweitert
		//PS ps = new PS();
		//ps.doThis();
		
		// Aufruf über Vererbung
		// d.h. die Methode in PS wird, auch ohne vorher ein Objekt zu erstellen, aufgerufen
		doThis();	// <== Methode aus der Parent class
	}
}
