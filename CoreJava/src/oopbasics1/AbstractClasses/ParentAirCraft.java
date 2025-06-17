package oopbasics1.AbstractClasses;

public abstract class ParentAirCraft {

	/**
	 * Ein abstracte Klasse hat sowohl abstracte Methoden 
	 * (d.h. Methoden ohne Implementierung/ nur mit Body) als auch
	 * non-abstrakte Methoden (d.h. Methoden mit Implementierung).
	 * Die Methoden sollten nicht private als access specifier haben.
	 * Auch Variablen sollten nicht private sein. Abstrakte Klassen
	 * werden über "extends" von den Klassen implementiert.
	 * 
	 * 
	 * Ein Interface dagegen hat nur abstrakte Methoden (d.h. ohne 
	 * Implementierung). Die Methoden müssen immer public sein. Und
	 * die Variablen public, static oder final. Inteface werden über
	 * "implements" von den Klassen implementiert. 
	 */
	
	// non-abstract method
	public void engine() {
		System.out.println("Follow Engine Guidelines");
	}
	
	// Methoden in abtrakten Klasse sollten nie private nicht als Zugriff-Modifier 
	// haben, da sie ansonsten nicht von den Childs geerbt werden können
	// private void safetyGuidelines() {
	public void safetyGuidelines() {
		System.out.println("Follow Safety Guidelines");
	}
	
	// abstract method
	public abstract void bodyColor();
}
