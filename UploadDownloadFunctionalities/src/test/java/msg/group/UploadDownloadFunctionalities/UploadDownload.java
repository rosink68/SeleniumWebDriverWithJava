package msg.group.UploadDownloadFunctionalities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadDownload {

	public static void main(String[] args) throws Exception {
		
		String fruitName = "Apple";
		String fileName = "C:/Users/rosink/Downloads/download.xlsx";
		String updatedValue = "999";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
	
		// download
		driver.findElement(By.cssSelector("#downloadButton")).click();
		// das Download braucht Zeit
		Thread.sleep(500);
				
		// edit excel 
		// get column number of Price and get row number of Apple ==> update excel with row,col
		int col = getColumnNumber(fileName, "price");
		int row = getRowNumber(fileName, "Apple");
		Assert.assertTrue(updateCell(fileName, row, col, updatedValue));
		
		
		// upload
		WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
		
		// ein automatisches Upload geht nur, wenn das <input>-Tag vom type="file" ist
		upload.sendKeys(fileName);
		
		// wait for success message to show up and wait for disappear
		By toastLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
		String toastText = driver.findElement(toastLocator).getText();
		System.out.println(toastText);
		Assert.assertEquals("Updated Excel Data Successfully.", toastText);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));
		
		
		// verify updated excel data showing in the web table
		// dynamische Ermittlung des Preis: d.h. ausgehend von der Frucht wird der Parent 
		// der Frucht ermittelt und vom Parent aus die Preisspalte
		String priceColumnId = driver.findElement(By.xpath("//div[text()='Price']")).getDomAttribute("data-column-id");
		String actualPrice = driver.findElement(By.xpath("//div[text()='" + fruitName + "']/parent::div/parent::div/div[@id='cell-" + priceColumnId + "-undefined']")).getText();
		System.out.println(actualPrice);
		Assert.assertEquals(updatedValue, actualPrice);
		
		Thread.sleep(500);
		driver.close();
	}

	private static int getColumnNumber(String fileName, String colName) throws IOException {
		
		FileInputStream fis = new FileInputStream(fileName);
				
		// komplette Excel-Datei
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		// das 1. Tabellenblatt (Sheet) holen
		XSSFSheet sheet = workbook.getSheet("Sheet1");
				
		// Anzahl der Zeilen <== sheet is colection of rows
		Iterator<Row> rows = sheet.iterator();
				
		// Zellen der 1. Zeile <== row is collection of cells
		Row firstRow = rows.next();
		Iterator<Cell> cellsFirstRow = firstRow.cellIterator();
				
		int k = 1;
		int column = 0;
		// Prüfen, ob es noch eine Zelle gibt
		while (cellsFirstRow.hasNext()) {
					
			Cell cell = cellsFirstRow.next();
					
			// in der 1. Zeile wird von der Spalte colName die Nummer der Spalte ermittelt
			if (cell.getStringCellValue().equalsIgnoreCase(colName)) {
				column = k;						
			}
					
			k++;
		}
		workbook.close();
		fis.close();

		return column;
	}

	private static int getRowNumber(String fileName, String fruitName) throws IOException {

		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);	// Excel-Datei
		XSSFSheet sheet = workbook.getSheet("Sheet1");	// Tabellenblatt

		Iterator<Row> rows = sheet.iterator();			// Anzahl der Zeilen

		int k = 1;
		int rowIndex = -1;
		// äußere Schleife ==> jede Zeile durchgehen, bis fruit gefunden wird
		while (rows.hasNext()) {
			
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();	// Zellen der Zeile
			
			// durch jede Zelle der Zeile iterieren
			while(cells.hasNext()) {
				
				Cell cell = cells.next();
				// nur in den Zellen prüfen, die vom Typ String sing, da für nummerische 
				// Zellen ansonsten eine IllegalStateException geworfen wird
				// d.h. numerische Zellen werden übersprungen
				if (cell.getCellType() == CellType.STRING 
					&& cell.getStringCellValue().equalsIgnoreCase(fruitName)) {
					rowIndex = k;
				}
			}
			k++;	
		}
		workbook.close();
		fis.close();

		return rowIndex;
	}

	private static boolean updateCell(String fileName, int row, int col, String updatedValue) throws IOException {
		
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);	// Excel-Datei
		XSSFSheet sheet = workbook.getSheet("Sheet1");	// Tabellenblatt
		
		// Zelle ermitteln, in der der Wert geändert wird
		Row rowField = sheet.getRow(row - 1);		// die 1. Zeile im Excel-Sheet hat den Index 0
		Cell cellField= rowField.getCell(col - 1);	// die 1. Spalte im Excel-Sheet hat den Index 0 
		
		// den Wert updaten
		cellField.setCellValue(updatedValue);
		
		// geänderte Zelle in die Excel-Datei zurückschreiben und speichern
		FileOutputStream fos = new FileOutputStream(fileName);
		// write öffnet die Exceldatei und schreibt die Änderungen dort hinein
		workbook.write(fos);

		workbook.close();
		fis.close();
		fos.close();
		
		return true;
	}
}
