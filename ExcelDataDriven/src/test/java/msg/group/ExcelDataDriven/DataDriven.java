package msg.group.ExcelDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	/**
	 * 1. Identify Testcases column by scanning the entire 1st row.
	 * 2. Once column is identified then scan entire testcase columns to 
	 *    identify purchase testcase row.
	 * 3. After you grab purchase testcase, pull the data of that row and
	 *    feed into test.
	 * 
	 * @param String testcaseName
	 * @return ArrayList<String>
	 * @throws IOException
	 */
	public ArrayList<String> getData(String testcaseName) throws IOException {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + 
				"//src//test//java//msg//group//data//demodata.xlsx");
				
		// komplette Excel-Datei
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		// Anzahl der Tabellenblätter (Sheets) 
		int sheets = workbook.getNumberOfSheets();		
		
		// Tabellenblatt (Sheet)
		for (int i=0; i<sheets; i++) {
			
			// Daten vom Tabellenblatt "testdata" holen
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				/**
				 *  1. Identify Testcases column by scanning the entire 1st row.
				 */
				
				// Anzahl der Zeilen <== sheet is colection of rows
				Iterator<Row> rows = sheet.iterator();
				
				// 1. Zeile
				Row firstRow = rows.next();
				
				// Zellen der 1. Zeile <== row is collection of cells
				Iterator<Cell> cellsFirstRow = firstRow.cellIterator();
				
				int k = 0;
				int column = 0;
				// Prüfen, ob es noch eine Zelle gibt
				while (cellsFirstRow.hasNext()) {
					
					// zur Zelle gehen
					Cell cell = cellsFirstRow.next();
					
					// in der 1. Zeile wird die Spalte "Testcases" ermittelt
					if (cell.getStringCellValue().equalsIgnoreCase("TestCases")) {

						// Nummer der Spalte "Testcases" ermitteln
						column = k;						
					}
					
					k++;
				}
				System.out.println("Spalte: " + column);
				
				
				/**
				 *  2. Once column is identified then scan entire testcase columns 
				 *  to identify purchase testcase row.
				 */
				
				// in der 1. Spalte die Zeile "Purchase" suchen
				while (rows.hasNext()) {
					
					// in die Row bewegen
					Row row = rows.next();
					
					// wenn in der Spalte "TestCases" eine Zelle "Purchase" gefunden wird
					if (row.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						
						/**
						 * 3. After you grab purchase testcase, pull the data  
						 * of that row and feed into test.
						 */
						Iterator<Cell> cellsRow = row.cellIterator();
						while (cellsRow.hasNext()) {
							
							Cell cell = cellsRow.next();

							switch (cell.getCellType()) {
							case STRING:
								arrayList.add(cell.getStringCellValue());																
								break;

							case NUMERIC:
								arrayList.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
								break;
								
							case BOOLEAN:
								 
								String boolAsString = Boolean.toString(cell.getBooleanCellValue());
								arrayList.add("XXX" + boolAsString);
								break;

							default:
								break;
							}
						}
					}			
				}
			}
		}
		
		workbook.close();
		
		return arrayList;
	}
}
