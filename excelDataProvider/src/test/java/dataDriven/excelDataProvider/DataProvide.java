package dataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvide {
	
	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider = "driveTest")
	public void testCaseData(String greeting, String communication, String id) {
		
		System.out.println(greeting + " " + communication + " " + id);
	}
	
	@DataProvider(name = "driveTest")
	public Object[][] getData() throws IOException {
		
//		Object[][] data = {{"hello", "text", "1"}, 
//						   {"bye", "message", "143"}, 
//						   {"solo", "call", "453"}};
		
		// every row of excel should be sent to 1 array
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + 
				"//src//test//java//dataDriven//data//excelDriver.xlsx");
		
		// Exceldatei
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		// Tabellenblatt 1
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		// Anzahl der Zeilen auf dem Tabellenblatt
		int rowCount = sheet.getPhysicalNumberOfRows();
		
		// die Anzahl der Spalten wird ermittelt, indem die Nummer der letzen Spalte abgefragt wird 
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		
		// es wird ein 2-dimensionales Array erstellt
		// [rowCount-1] - Anzahl der Arrays innerhalb = Anzahl der Zeilen im Excel minus die Überschriftszeile
		// [colCount] - Anzahl der Einträge/Werte in jedem Array
		// Bsp. new Object[3][3]
		// {	{"Greeting", "Communication", "id"}		<== Kopfzeile wird rausgefiltert
		//		{"hello", "text", "1"}, 
		//		{"bye", "message", "143"}, 
		//		{"solo", "call", "453"}		}
		// als Array: row, column
		//	data[0][0] = "hello"	data[1][0] = "text"		data[2][0] = "1"
		//	data[0][1] = "bye"		data[1][1] = "message"	data[2][1] = "143"
		//	data[0][2] = "solo"		data[1][2] = "solo"		data[2][2] = "453"
		Object[][] data = new Object[rowCount-1][colCount];
		
		// wir benötigen 2 for-Schleife
		// outer for-loop: Schleife erhöht die row-Nummer
		// inner for-loop: Schleife erhöht die column-Nummer
		for(int i=0; i<rowCount-1; i++) {
			
			// i+1, da die Kopfzeile übersprungen wird
			row = sheet.getRow(i+1);
			
			// jede Spalte für die row anspringen
			for (int j=0; j<colCount; j++) {
				
				// Umwandeln der Wert in String, da wir Strings verarbeiten
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		
		workbook.close();
		
		return data;
	}
}
