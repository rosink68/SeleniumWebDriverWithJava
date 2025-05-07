package msg.group.java_basics;

public class StringsInJava {

	public static void main(String[] args) {

		//string is an object //String literal
		String s11 = "Rahul Shetty Academy";
		String s12 = "Rahul Shetty Academy";
		// s11 und s12 sind identisch, d.h. bei einem Literal wird kein neues Objekt angelegt
		System.out.println(s11 == s12); // return true
		String s5 = "hello";
		System.out.println(s11 == s5); // return false

		//wrid ein String mit new erzeugt, werden neue Objekte angelegt
		String s2 = new String("Welcome");
		String s3 = new String("Welcome");
		System.out.println(s2 == s3); // returns false

		System.out.println("--------------------");

		String s = "Rahul Shetty Academy";
		
		// String am Leerzeichen splitten
		String[] splittedString0 = s.split(" ");
		for (int i=0; i<splittedString0.length; i++) {
			System.out.println(splittedString0[i]);
		}
		
		System.out.println("--------");
		
		String[] splittedString = s.split("Shetty");
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[1].trim());

		System.out.println("--------------------");

		// jedes Zeichen einzeln ausgeben
		for(int i=0; i<s.length(); i++) {
			System.out.println(s.charAt(i));
		}		

		System.out.println("--------------------");

		// den String "Rahul Shetty Academy"; umdrehen
		String s_reverse = "";
		// i=s.length()-1 <== vom letzten Zeichen beginnen
		// i>=0 <== bis Index 0
		for(int i=s.length()-1; i>=0; i--) {
			s_reverse = s_reverse + s.charAt(i);
		}
		System.out.println(s_reverse);

	}
}