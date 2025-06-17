package msg.group.ExcelDataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException {
		
		DataDriven dataDriven = new DataDriven();
		ArrayList<String> data = dataDriven.getData("Purchase");
		for (String string : data) {
			System.out.println(string);
		}
		
		System.out.println("Wert in Spalte 3: " + data.get(2));
	}

}
