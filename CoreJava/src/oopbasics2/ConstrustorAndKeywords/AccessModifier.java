package oopbasics2.ConstrustorAndKeywords;

public class AccessModifier {

	/**
	 * default: void abc()
	 * access method/variable anywhere ONLY in package <== no access from another package
	 * default kann nur im selben Package genutzt werden. Auch bei extends im anderen 
	 * Package kann die Methode/Variable nicht genutzt werden.
	 * 
	 * public void abc() 
	 * method/variable as public <== then you will have access across all packages
	 * public - uneingeschränkt auch in anderen Packages nutzbar.
	 * 
	 * private void abc()
	 * you can not access method/variable outside the particular class of same package 
	 * <== not even in the same package the other classes can access as usual just like public 
	 * private - nur innerhalb der Klasse nutzbar
	 * 
	 * protected void abc()
	 * method/variable as protected <== then you can access those in sub classes only (this
	 * applies for other packages) that means in the same package 
	 * <== only child classes which extends the parent class can only access the properties
	 * protected kann im selben Package uneingeschränkt genutzt werden und in anderen 
	 * Packages nur, wenn die (Child-)Klasse die (Parent-)Klasse erweitert, d.h. wenn extends
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
