package oopbasics2.DateAndCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateDemo {

	public static void main(String[] args) {
		
		Date d = new Date();
		
		// Ausgabe: Tue Jun 03 09:44:11 CEST 2025
		System.out.println(d.toString());
		
		// Umwandeln in dd.MM.yyyy HH:mm:ss <== mit Hilfe SimpleDateFormat Klasse
		// https://www.tutorialspoint.com/java/java_date_time.htm
		// Parameter: erwartetes Format
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println(sdf.format(d));
	
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		System.out.println(sdf1.format(d));

	}

}
