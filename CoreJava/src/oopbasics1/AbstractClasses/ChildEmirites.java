package oopbasics1.AbstractClasses;

public class ChildEmirites extends ParentAirCraft {

	public static void main(String[] args) {
		
		ChildEmirites childEmirites = new ChildEmirites();
		childEmirites.engine();
		childEmirites.safetyGuidelines();
		childEmirites.bodyColor();
		
		// von abtrakten Klasen kann kein Objekt erstellt werden
		// d.h. ParentAirCraft p = new ParentAirCraft(); <== geht nicht
		
	}

	@Override
	public void bodyColor() {
		
		// diese Methode ist im Parent abstrakt und muss 
		// deshalb im Child implementiert werden.
		System.out.println("Red color on the body");		
	}

}
