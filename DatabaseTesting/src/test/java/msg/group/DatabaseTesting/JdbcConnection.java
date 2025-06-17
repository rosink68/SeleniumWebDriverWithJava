package msg.group.DatabaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		String host = "localhost";
		String port = "3306";
		String connectionURL = "jdbc:mysql://"+host+":"+port+"/demo";
		
		// Verbindung zur Datenbank
		Connection con = DriverManager.getConnection(connectionURL, "root", "kr%MySQL%2025");

		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from credentials where scenario = 'rewardscard'");
		
		// bewegt den Zeiger vom Baseindex zum 1. Index (1. Ergebniszeile)
		//rs.next();
		
		while(rs.next()) {
			driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
			driver.findElement(By.id("password")).sendKeys(rs.getString("password"));	
			//driver.findElement(By.id("Login")).click();
		}
	}

}
