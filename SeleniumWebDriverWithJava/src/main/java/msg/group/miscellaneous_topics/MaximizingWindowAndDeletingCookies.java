package msg.group.miscellaneous_topics;

import java.util.HashMap;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class MaximizingWindowAndDeletingCookies {

	public static void main(String[] args) {
		
		/**
		 * Hilft alles nicht, um das Popup auszuschalten!!!!!!!!!!!!!!
		 */
		
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("safebrowsing.enabled", "true");
		//chromePrefs.put("download.default_directory", downloadFilePath);
		options.addArguments("--allow-running-insecure-content");
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("no-sandbox");
		options.addArguments("enable-automation");;
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.addArguments("--disable-gpu");
		options.addArguments("disable-features=DownloadBubble,DownloadBubbleV2");
		options.addArguments("--disable-features=InsecureDownloadWarnings");
		options.addArguments("--no-sandbox");
		options.addArguments("--incognito");
		
		options.addArguments("start-maximized");

		//This option u can for executing tests in a latest version of chrome in case
		// the chrome version in local system is older.
		//options.setBinary(downloadFilePath);

		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
		options.setCapability(ChromeOptions.CAPABILITY, options);
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed("sessionKey");
		//driver.manage().addCookie(null);
		
		driver.get("https://www.google.com/");
	}

}
