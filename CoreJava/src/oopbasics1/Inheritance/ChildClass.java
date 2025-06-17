package oopbasics1.Inheritance;

/**
 * Mit extends werden die Variablen und Methoden der Parentklasse 
 * an die Childklasse vererbt
 * 
 * Eine Childklasse kann NUR von einer Parentklasse erben!!! 
 * D.h. Mehrfachvererbung von 2 Parentklassen ist nicht möglich.
 * (Will man von mehreren erben, muss ein Interface benutzt werden.)
 */

public class ChildClass extends ParentClass {

	public static void main(String[] args) {
		
		ChildClass cc = new ChildClass();
		cc.colour();
		cc.brakes();		// aus ParentClass
		// function overriding - both have same name, same signature
		// and same parameter
		cc.audiosystem();	// in ChildClass überschrieben
	}
	
	public void engine() {
		System.out.println("new engine");
	}
	
	public void colour() {
		// colour ist in der ParentClass definiert
		System.out.println(colour);
	}

	public void audiosystem() {
		System.out.println("new audio child system");
	}

}
