package oopbasics2.ConstrustorAndKeywords;

public class StaticVar {

	// instance variable
	String name;
	String adress;
	
	// a static variable is shared by all the objects
	// d.h. alle Objekte/Instancen der Klasse haben Berlin als city <== class variable
	//static String city =  "Berlin";
	//static int i = 0;
	// alternativ können die statischen Variable in einem Block initialisiert werden
	static String city;
	static int i;
	static {
		city =  "Berlin";
		i = 0;
	}
	
	public StaticVar(String name, String adress) {
		
		// assign local variable to instance variable
		this.name = name;
		this.adress = adress;
		
		// da i static ist, wird i jedes Mal um 1 erhöht, wenn ein Objekt erzeugt wird
		i++;
		System.out.println("i = " + i);
	}
	
	public void getAddress() {
		System.out.println(adress + ", " + city);
	}

	// statische Methoden sind unabhängig vom Objekt, d.h. sie benötigen kein Objekt, 
	// um aufgerufen zu werden
	public static void getCity() {
		// in statischen Methoden können nur statische Variable ausgegeben werden
		System.out.println(city);
	}
	
	public static void main(String[] args) {
		
		StaticVar eva = new StaticVar("Eva", "Thulestrasse 99");
		StaticVar max = new StaticVar("Max", "Unter den Linden 1");
		StaticVar ina = new StaticVar("Ina", "Müllerntordamm 44");
		
		eva.getAddress();
		max.getAddress();
		ina.getAddress();
		
		// Aufruf einer statischen Methode
		StaticVar.getCity();
		// Zuweisung Wert zu statischen Variable
		StaticVar.city = "Schwerin";
		
		// Zuweisung zur Klassen variable nur über Objekt möglich
		eva.name = "Evi";
		eva.getAddress();
		
	}

}
