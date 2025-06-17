package oopbasics2.ConstrustorAndKeywords;

public class Child extends Parent {

	//String name = "QAClickAcademy";
	
	public Child() {
		// call super() that means the constructor of parent class should be
		// always the first line
		super();
		System.out.println("child class constructor");
	}
	
	public static void main(String[] args) {
		
		Child child = new Child();
		child.getStringdata();
		
		// solange in Child() keine eigene Methode getData existiert, wird 
		// die getData Methode von Parent() aufgerufen, da Child() Parent erweitert
		// existiert getData auch in Child(), wird diese aufgerufen <== Methode wird überschrieben
		child.getData();
	}

	public void getStringdata() {
		// Ausgabe name von Child() <== ist Name von Child() auskommentiert, 
		// wird name vom parent() ausgegeben
		System.out.println(name);
		
		// Ausgabe name von Parent()
		System.out.println(super.name);
	}

	public void getData() {
		// Aufruf getData von Parent() 
		super.getData();

		System.out.println("I am child class");
	}
}
