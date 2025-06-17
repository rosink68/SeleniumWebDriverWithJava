package chromeDevToolsFeatures;

import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthentication {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		// URL ermitteln und erweitern
		// Bsp. httpbin.org/basic-auth/foo/bar
		// HOST: httpbin.org; Ressource: basic-auth; Parameter: foo/bar
		
		// -> Predicate logic - bedeutet eine Filterbedingung für Daten erstellen
		// uri - Predicate input/consumer (consumer consume the data and do nothing <== braucht man aber zur Manipulation der Daten)
		// --> Lambda expression
		// uri.getHost() - Filter
		// {} können weggelassen werden, da es nur eine Anweisungszeile gibt
		// Prüfen, ob der HOST httpbin.org ist
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
		
		// Indicates that a driver supports authenticating to a website in some way
		// HasAuthentication sagt dem driver, dass er die Authentifizierung akzeptieren soll
		// d.h. am driver mit predicate registrieren (predicate condition is that when it matches with domain
		// Parameter: 1. an welchen HOST authentifiziert werden soll; 2. username und password
		((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
		
		driver.get("http://httpbin.org/basic-auth/foo/bar");
		

	}

}
