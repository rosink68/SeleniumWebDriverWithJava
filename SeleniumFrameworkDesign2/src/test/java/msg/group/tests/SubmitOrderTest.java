package msg.group.tests;

import msg.group.pageobjects.*;
import msg.group.testcomponents.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Diese Klasse enthält Testfälle für die Bestellung und die Bestellhistorie.
 * Sie erbt von der BaseTest-Klasse, die grundlegende Testfunktionen bereitstellt.
 */
public class SubmitOrderTest extends BaseTest {
	
	/**
	 * Positive Testfälle zur Anwendung.
	 */

	String productName = "ZARA COAT 3";

	/**
	 * Testfall für die erfolgreiche Bestellung eines Produkts.
	 * Führt die Registrierung, Anmeldung, Produktauswahl, Checkout und Bestätigung durch.
	 *
	 * @param input HashMap mit Testdaten wie Benutzerinformationen und Produktname.
	 * @throws IOException falls ein Fehler beim Lesen der Testdaten auftritt.
	 */
	@Test(dataProvider = "getData", groups = {"Purchase"})
	// Verwendung eines Object []
	//public void submitOrder(String email, String password, String productName) throws IOException {
	public void submitOrder(HashMap<String, String> input) throws IOException {

		// Registrierung durchführen
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.completeRegistration(
				input.get("firstName"),
				input.get("lastName"),
				input.get("email"),
				input.get("phoneNumber"),
				input.get("occupation"),
				input.get("gender"),
				input.get("password"),
				input.get("confirmPassword")
		);

		// Fortfahren mit der Bestellung
		String country = "India";
		
		// bei erfolgreichen Login wird automatisch zum Produktkatalog (Shop) weitergeleitet
		ProductCataloguePage productCataloguePage = landingPage.loginApplication(input.get("email"), input.get("password"));	
		
		// Shop mit Weiterleitung zum Einkaufswagen
		//List<WebElement> products = productCataloguePage.getProductList();
		// Produkt auswählen und in den Einkaufswagen legen
		productCataloguePage.addProductToCart(input.get("product"));
		// zum Warenborb "My Cart" gehen <== goToCartPage() befindet sich in der Parentklasse
		CartPage cartPage = productCataloguePage.goToCartPage();
		
		
		// My Cart mit Weiterleitung auf die Checkout-Page
		// prüfen, ob "ZARA COAT 3" im Warenkorb enthalten ist
		boolean match = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		
		// Payment mit Weiterleitung zur Bestätigungsseite
		checkoutPage.selectCountry(country);
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		
		// THANKYOU FOR THE ORDER.
		confirmationPage.waitForElementToAppear(By.tagName("h1"));
		String confirmMessage = confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		// in @AfterMethod der Parent class (BaseTest) verschoben
		//driver.quit();driver.quit();
	}

	/**
	 * Testfall für die Überprüfung der Bestellhistorie.
	 * Dieser Test ist abhängig vom erfolgreichen Abschluss des submitOrder-Testfalls.
	 */
	// dieser Test ist abhängig von submitOrder und soll deshalb erst ausgeführt werden, wenn submitOrder ausgeführt wurde
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest() {

		ProductCataloguePage productCataloguePage = landingPage.loginApplication("ewaldostehr@gmail.com", "Paul3005");	

		// da die Methode goToOrderPage() in der AbstractComponent class ist, kann sie
		// von jeder Klasse aus aufgerufen werden, die AbstractComponent erbt
		OrderPage orderPage = productCataloguePage.goToOrderPage();

		// Prüfen, ob "ZARA COAT 3" in "Your Orders" enthalten ist <== ist nur drin, wenn submitOrder() erfolgreich ausgeführt wurde 
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));	
	}

	/**
	 * DataProvider für die Testfälle.
	 * Liest Testdaten aus einer JSON-Datei und konvertiert sie in eine Liste von HashMaps.
	 *
	 * @return ein zweidimensionales Array mit Testdaten.
	 * @throws IOException falls ein Fehler beim Lesen der JSON-Datei auftritt.
	 */
	// Daten aus einem JSON-File lesen und daraus einen HashMap erstellen
	@DataProvider
	public Object[][] getData() throws IOException {
		
		// JSON-Daten in eine Liste von 2 HashMaps konvertieren
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//msg//group//data//PurchaseOrder.json");

		// der DataProvider akzeptiert HashMaps ==> aus den Einträgen im JSON-File wird eine Liste
		// mit HashMaps (pro DataSet 1 HashMap) erstellt und zurück gegeben

		// Initialisiere ein zweidimensionales Array basierend auf der Größe der Datenliste
		Object[][] dataArray = new Object[data.size()][1];

		// Fülle das Array mit den HashMaps aus der Liste
		for (int i = 0; i < data.size(); i++) {
			dataArray[i][0] = data.get(i);
		}

		return dataArray;
	}

//  // mit 2-dimensionalen Array
//	@DataProvider
//	public Object[][] getData() {
//		
//		// ein 2-dimensionale Array erstellen
//		// {{}, {}} bedeutet 2 DataSets <== ein DataSet enthält Usernamen, Passwort und Produkt
//		return new Object[][] {
//			{"ewaldostehr@gmail.com", "Paul3005", "ZARA COAT 3"}, 
//			{"ewaldostehr@gmail.com", "Paul3005", "ADIDAS ORIGINAL"}
//			};
//	}
	
//	// mit HashMap
//	@DataProvider
//	public Object[][] getData() {
//		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "ewaldostehr@gmail.com");
//		map.put("password", "Paul3005");
//		map.put("product", "ZARA COAT 3");
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "ewaldostehr@gmail.com");
//		map1.put("password", "Paul3005");
//		map1.put("product", "ADIDAS ORIGINAL");
//
//		// {{}, {}} bedeutet 2 DataSets 
//		return new Object[][] {{map}, {map1}};
//	}

}
